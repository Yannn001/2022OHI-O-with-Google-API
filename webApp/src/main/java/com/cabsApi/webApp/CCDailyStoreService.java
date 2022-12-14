package com.cabsApi.webApp;

import com.cabsApi.webApp.cabsApiJsonClasses.Prediction;
import com.cabsApi.webApp.cabsApiJsonClasses.Result;
import com.cabsApi.webApp.cabsApiJsonClasses.Vehicle;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@AllArgsConstructor
@Service
public class CCDailyStoreService {

    private HashMap<String, Double>[] timeMap;
    private final CCInfoRepository ccInfoRepository;
//    private String predictionCountdown;
//    private String prevPredictionCountdown;

    public HashMap<String, Double>[] getDailyTimeGrid(){
        HashMap<String, Double> map = new HashMap<>();
        HashMap<String, Double>[] arr = new HashMap[96]; //96 * 15min = 24hours

        return arr;
    }
}
