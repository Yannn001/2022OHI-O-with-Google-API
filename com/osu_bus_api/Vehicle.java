package com.osu_bus_api;

import java.util.List;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Vehicle {

    @SerializedName("routeCode")
    @Expose
    private String routeCode;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("heading")
    @Expose
    private Integer heading;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("patternId")
    @Expose
    private String patternId;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("delayed")
    @Expose
    private Boolean delayed;
    @SerializedName("speed")
    @Expose
    private Integer speed;
    @SerializedName("predictions")
    @Expose
    private List<Prediction> predictions = null;
    @SerializedName("service")
    @Expose
    private String service;
    @SerializedName("lastStop")
    @Expose
    private Object lastStop;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("bus_id")
    @Expose
    private Object busId;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("longitude")
    @Expose
    private Double longitude;

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getHeading() {
        return heading;
    }

    public void setHeading(Integer heading) {
        this.heading = heading;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getPatternId() {
        return patternId;
    }

    public void setPatternId(String patternId) {
        this.patternId = patternId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Boolean getDelayed() {
        return delayed;
    }

    public void setDelayed(Boolean delayed) {
        this.delayed = delayed;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public List<Prediction> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<Prediction> predictions) {
        this.predictions = predictions;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Object getLastStop() {
        return lastStop;
    }

    public void setLastStop(Object lastStop) {
        this.lastStop = lastStop;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getBusId() {
        return busId;
    }

    public void setBusId(Object busId) {
        this.busId = busId;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}