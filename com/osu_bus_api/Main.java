package com.osu_bus_api;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

// @EnableScheduling
public class Main {

    public static String readSampletoString(String sampleString) throws Exception {
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(sampleString));

        StringBuffer buffer = new StringBuffer();
        int read;
        char[] chars = new char[1024];
        try {
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static String readURLtoString(String urlString) throws Exception {
        URL url = new URL(urlString);
        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(url.openStream()));

        StringBuffer buffer = new StringBuffer();
        int read;
        char[] chars = new char[1024];
        try {
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    // @Scheduled(cron = "0 */1 7-22 ? ? 1-5")
    public static Map<String, String> saveSQL(String urlString, PreparedStatement preparedStatement,
            Map<String, String> busStop)
            throws Exception {

        Gson gson = new Gson();
        String json = readURLtoString(urlString);
        // String json = readSampletoString(urlString);

        // Parse Json using Gson
        Result result = gson.fromJson(json, Result.class);

        // Get data from OSU API, store in mySQL
        for (Vehicle bus : result.getData().getVehicles()) {
            String busID = bus.getId();
            System.out.println(busID);

            String stopName = bus.getPredictions().get(0).getStopName();

            if (!busStop.containsKey(busID)) {
                busStop.put(busID, stopName);
                preparedStatement.setString(1, busID);
                preparedStatement.setString(2, stopName);
                preparedStatement.setObject(3, java.sql.Date.from(Instant.parse((bus.getUpdated()))));
                preparedStatement.setObject(4,
                        java.sql.Date.from(Instant.parse((bus.getPredictions().get(0).getPredictionTime()))));
                preparedStatement.executeUpdate();
            } else if (!busStop.get(busID).equals(stopName)) {
                busStop.replace(busID, stopName);
                preparedStatement.setString(1, busID);
                preparedStatement.setString(2, stopName);
                preparedStatement.setObject(3, java.sql.Date.from(Instant.parse((bus.getUpdated()))));
                preparedStatement.setObject(4,
                        java.sql.Date.from(Instant.parse((bus.getPredictions().get(0).getPredictionTime()))));
                preparedStatement.executeUpdate();
            }
        }
        return busStop;
    }

    static final String DB_URL = "jdbc:mysql://localhost:3306/OSU_BUS_CC";
    static final String USER = "";
    static final String PASS = "";

    public static void main(String[] args) throws Exception {
        // Gson gson = new Gson();
        String sampleString = "sample_data.json";
        String urlString = "https://content.osu.edu/v2/bus/routes/CC/vehicles";

        Connection connect = null;
        PreparedStatement preparedStatement = null;

        try {
            Map<String, String> busStop = new HashMap<String, String>();

            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // DB connection setup
            connect = DriverManager.getConnection(DB_URL, USER, PASS);

            // PreparedStatements
            preparedStatement = connect
                    .prepareStatement("insert into RECORD_TIME values (default, ?, ?, ?, ?)");

            for (int i = 1; i < 60; i++) {
                busStop = saveSQL(urlString, preparedStatement, busStop);
                System.out.println(busStop.toString());
                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }

            } catch (Exception e) {

            }
        }
    }
}
