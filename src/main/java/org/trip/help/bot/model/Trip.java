package org.trip.help.bot.model;

public class Trip {

    private String id;
    private String user;
    private String route;
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

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
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
