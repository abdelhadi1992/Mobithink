package fr.alteca.mobithinkvelo.model;

import java.util.UUID;

public class TrajetId {
    private UUID uuid;

    public TrajetId(UUID uuid) {

        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrajetId tripId = (TrajetId) o;

        return uuid != null ? uuid.equals(tripId.uuid) : tripId.uuid == null;
    }

    @Override
    public int hashCode() {
        return uuid != null ? uuid.hashCode() : 0;
    }

    @Override
    public String toString() {
        return uuid.toString();
    }
}
