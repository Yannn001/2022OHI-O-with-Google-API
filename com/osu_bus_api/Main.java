package com.osu_bus_api;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

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

    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        String sampleString = "/Users/a2xyz/AU22_O3_API/2022OHI-O-with-Google-API/com/osu_bus_api/sample_data.json";
        String urlString = "https://content.osu.edu/v2/bus/routes/CC/vehicles";
        try {
            // String json = readSampletoString(sampleString);
            String json = readURLtoString(urlString);

            Result result = gson.fromJson(json, Result.class);

            for (Vehicle bus : result.getData().getVehicles()) {
                System.out.println(bus.getId()); // Bus ID
                System.out.println(bus.getUpdated()); // Updated time
                for (Prediction pred : bus.getPredictions()) {
                    System.out.println(pred.getPredictionTime());
                    System.out.println(pred.getStopName());
                    break;
                }
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
