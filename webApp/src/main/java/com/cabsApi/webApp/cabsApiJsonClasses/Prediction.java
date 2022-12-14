package com.cabsApi.webApp.cabsApiJsonClasses;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Prediction {

    @SerializedName("routeCode")
    @Expose
    private String routeCode;
    @SerializedName("routeColor")
    @Expose
    private String routeColor;
    @SerializedName("predictionCountdown")
    @Expose
    private String predictionCountdown;
    @SerializedName("isDelayed")
    @Expose
    private Boolean isDelayed;
    @SerializedName("darkColor")
    @Expose
    private String darkColor;
    @SerializedName("predictionTime")
    @Expose
    private String predictionTime;
    @SerializedName("timeToArrivalInSeconds")
    @Expose
    private Integer timeToArrivalInSeconds;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("stopId")
    @Expose
    private String stopId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("systemTime")
    @Expose
    private String systemTime;
    @SerializedName("vehicleId")
    @Expose
    private String vehicleId;
    @SerializedName("vehicleDistanceInFeet")
    @Expose
    private Integer vehicleDistanceInFeet;
    @SerializedName("stopName")
    @Expose
    private String stopName;

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getRouteColor() {
        return routeColor;
    }

    public void setRouteColor(String routeColor) {
        this.routeColor = routeColor;
    }

    public String getPredictionCountdown() {
        return predictionCountdown;
    }

    public void setPredictionCountdown(String predictionCountdown) {
        this.predictionCountdown = predictionCountdown;
    }

    public Boolean getIsDelayed() {
        return isDelayed;
    }

    public void setIsDelayed(Boolean isDelayed) {
        this.isDelayed = isDelayed;
    }

    public String getDarkColor() {
        return darkColor;
    }

    public void setDarkColor(String darkColor) {
        this.darkColor = darkColor;
    }

    public String getPredictionTime() {
        return predictionTime;
    }

    public void setPredictionTime(String predictionTime) {
        this.predictionTime = predictionTime;
    }

    public Integer getTimeToArrivalInSeconds() {
        return timeToArrivalInSeconds;
    }

    public void setTimeToArrivalInSeconds(Integer timeToArrivalInSeconds) {
        this.timeToArrivalInSeconds = timeToArrivalInSeconds;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(String systemTime) {
        this.systemTime = systemTime;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getVehicleDistanceInFeet() {
        return vehicleDistanceInFeet;
    }

    public void setVehicleDistanceInFeet(Integer vehicleDistanceInFeet) {
        this.vehicleDistanceInFeet = vehicleDistanceInFeet;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

}