package fr.alteca.mobithinkvelo.model;


import java.util.ArrayList;
import java.util.List;

public class StoreTrajetData {

	
	
//	@SerializedName("startTimeTrajet")
//	@Expose
	public Long id;
	public String startTrajet;
	public String endTrajet;
	public List<RollingPoint> rollingPoints;
	public List<Event> events;


	
	public StoreTrajetData() {
		rollingPoints =new ArrayList<RollingPoint>();
		events = new ArrayList<Event>();
	}
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStartTrajet() {
		return startTrajet;
	}



	public void setStartTrajet(String startTrajet) {
		this.startTrajet = startTrajet;
	}



	public String getEndTrajet() {
		return endTrajet;
	}



	public void setEndTrajet(String endTrajet) {
		this.endTrajet = endTrajet;
	}



	public List<RollingPoint> getRollingPoints() {
		return rollingPoints;
	}

	public void setRollingPoints(List<RollingPoint> rollingPoints) {
		this.rollingPoints = rollingPoints;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
	@Override
	public String toString() {
		return new StringBuilder().append("Trajet{")
				.append("id: ").append(id)
				.append(", startTrajet: ").append(startTrajet)
				.append(", endTrajet: ").append(endTrajet)
				.append(", Events: ").append(events)
				.append(", RollingPoints: ").append(rollingPoints)
				.append("}").toString();
	}
	
	
	
}
