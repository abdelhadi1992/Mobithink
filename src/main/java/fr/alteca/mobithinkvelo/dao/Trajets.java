package fr.alteca.mobithinkvelo.dao;

import fr.alteca.mobithinkvelo.model.Event;
import fr.alteca.mobithinkvelo.model.RollingPoint;

public interface Trajets {

	Long create(Long id,String startTrajet, String endTrajet);

    void addRollingPoint(RollingPoint rollingPoint);//Long id, String catchTime, double catchLatitude, double catchLongitude);

    void addEvent(Event event);//Long id, String eventName, String startCatchTime, double startCatchLatitude, double startCatchLongitude, String endCatchTime, double endCatchLatitude, double endCatchLongitude, String eventType);
    

}
