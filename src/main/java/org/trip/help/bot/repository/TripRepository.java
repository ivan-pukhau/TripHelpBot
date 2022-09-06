package org.trip.help.bot.repository;

import org.trip.help.bot.model.Trip;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TripRepository {

    private List<Trip> trips = new ArrayList<>();

    public TripRepository() {
    }

    public TripRepository(List<Trip> trips) {
        this.trips = trips;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public String addTrip(Trip trip) {
        String id = UUID.randomUUID().toString();
        trip.setId(id);
        trips.add(trip);
        return id;
    }
}
