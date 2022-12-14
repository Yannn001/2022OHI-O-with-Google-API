package com.cabsApi.webApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import com.cabsApi.webApp.cabsApiJsonClasses.Prediction;
import com.cabsApi.webApp.cabsApiJsonClasses.Result;
import com.cabsApi.webApp.cabsApiJsonClasses.Vehicle;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;

@Component
public class ScheduledTasks {
    private String predictionCountdown = "";
    private String prevPredictionCountdown = "DUE";

    int i = 0;
    int recordedTime;
    Timer timer = new Timer();
    String stopName;
    String prevStopName = "";
    boolean flag = true;

    @Scheduled(fixedRate = 1000)
    public void saveSQL()
            throws Exception {
        timer = new Timer();

        Gson gson = new Gson();
        String json = readURLtoString("https://content.osu.edu/v2/bus/routes/CC/vehicles");
        // String json = readSampletoString(urlString);

        // Parse Json using Gson
        Result result = gson.fromJson(json, Result.class);
        //initialize prevPredictionCountdown to "DUE" so that the first predictionCountdown could be stored.

        // Get data from OSU API
        //for (Vehicle bus : result.getData().getVehicles()) {
        if(flag) {
            timer.schedule(new TimerTask() {
                public void run() {
                    System.out.println(i + " second passed");
                    i++;
                }
            }, 1000, 1000);

            prevStopName = getFirstStopName(result);
            System.out.println("**************Heading to: " + prevStopName + "**************");
            flag = false; //flag might be reinitialzied
        }
        stopName = getFirstStopName(result);

        if (!stopName.equals(prevStopName)) {
            timer.cancel();
            i = 0;
            timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    System.out.println(i + " second passed");
                    i++;
                }
            }, 1000, 1000);

            prevStopName = stopName;
            System.out.println("**************Heading to: " + prevStopName + "**************");
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

    public String getFirstStopName(Result result) {
        Vehicle bus = result.getData().getVehicles().get(0);
        Prediction prediction = bus.getPredictions().get(0);
        return prediction.getStopName();
    }

    public String getSecondStopName(Result result) {
        Vehicle bus = result.getData().getVehicles().get(0);
        Prediction prediction = bus.getPredictions().get(1);
        return prediction.getStopName();
    }
}

