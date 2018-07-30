package fr.alteca.mobithinkvelo.model;

import fr.alteca.mobithinkvelo.dao.Trajets;

public class StoreTrajet {
    private Trajets trajets;
    private static Long id;
    public StoreTrajet(Trajets trajets) {
        this.trajets = trajets;
    }

    public void store(StoreTrajetData data) {
    	this.id = trajets.create(data.getId(),data.getStartTrajet(), data.getEndTrajet());
        
        System.out.println("Store Trajet Store data " + data.getId() + " "+ data.toString());
        //$$$$$$$$$$$$$$$$
        System.out.println("Store Trajet Store  rs" + data.getRollingPoints().size());
        System.out.println("Store Trajet Store  es" + data.getEvents().size());
        int i = 0;
        //$$$$$$$$$$$$$$$$$$$
        for(Event event : data.getEvents()) {
        	System.out.println("Boucle Event " + i + " " + event.toString());
        	event.setId(id);
        	trajets.addEvent(event);
        	System.out.println("sec" + i++);
        }
        
        for(RollingPoint point: data.getRollingPoints()) {
        	point.setId(id);
        	trajets.addRollingPoint(point);
            System.out.println("Boucle RollingPoint" + i++);
        }

        
    }
}
