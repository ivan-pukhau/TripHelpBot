package org.trip.help.bot.model;

import java.util.ArrayList;
import java.util.List;

public class Trip {

    private String id;
    private String user;
    private String startPoint;
    private List<String> additionalPoints = new ArrayList<>();
    private String endPoint;
    private String date;
    private Boolean isTripActive;
    private String tripDescription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public List<String> getAdditionalPoints() {
        return additionalPoints;
    }

    public void setAdditionalPoints(List<String> additionalPoints) {
        this.additionalPoints = additionalPoints;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getTripActive() {
        return isTripActive;
    }

    public void setTripActive(Boolean tripActive) {
        isTripActive = tripActive;
    }

    public String getTripDescription() {
        return tripDescription;
    }

    public void setTripDescription(String tripDescription) {
        this.tripDescription = tripDescription;
    }
}
