package fr.alteca.mobithinkvelo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
@Table(name="Event",schema="public")
public class Event implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identifiant;
	private Long id;
	private String eventName;
	private String startCatchTime;
	private double startCatchLatitude;
	private double startCatchLongitude;
	private String endCatchTime;
	private double endCatchLatitude;
	private double endCatchLongitude;
	private String eventType;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(Long id, String eventName, String startCatchTime, double startCatchLatitude,
			double startCatchLongitude, String endCatchTime, double endCatchLatitude, double endCatchLongitude,
			String eventType) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.startCatchTime = startCatchTime;
		this.startCatchLatitude = startCatchLatitude;
		this.startCatchLongitude = startCatchLongitude;
		this.endCatchTime = endCatchTime;
		this.endCatchLatitude = endCatchLatitude;
		this.endCatchLongitude = endCatchLongitude;
		this.eventType = eventType;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getStartCatchTime() {
		return startCatchTime;
	}

	public void setStartCatchTime(String startCatchTime) {
		this.startCatchTime = startCatchTime;
	}

	public double getStartCatchLatitude() {
		return startCatchLatitude;
	}

	public void setStartCatchLatitude(double startCatchLatitude) {
		this.startCatchLatitude = startCatchLatitude;
	}

	public double getStartCatchLongitude() {
		return startCatchLongitude;
	}

	public void setStartCatchLongitude(double startCatchLongitude) {
		this.startCatchLongitude = startCatchLongitude;
	}

	public String getEndCatchTime() {
		return endCatchTime;
	}

	public void setEndCatchTime(String endCatchTime) {
		this.endCatchTime = endCatchTime;
	}

	public double getEndCatchLatitude() {
		return endCatchLatitude;
	}

	public void setEndCatchLatitude(double endCatchLatitude) {
		this.endCatchLatitude = endCatchLatitude;
	}

	public double getEndCatchLongitude() {
		return endCatchLongitude;
	}

	public void setEndCatchLongitude(double endCatchLongitude) {
		this.endCatchLongitude = endCatchLongitude;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Event{")
				.append("id: ").append(id)
				.append(", eventName: ").append(eventName)
				.append(", startCatchTime: ").append(startCatchTime)
				.append(", startCatchLatitude: ").append(startCatchLatitude)
				.append(", startCatchLongitude: ").append(startCatchLongitude)
				.append(", endCatchTime: ").append(endCatchTime)
				.append(", endCatchLatitude: ").append(endCatchLatitude)
				.append(", endCatchLongitude: ").append(endCatchLongitude)
				.append(", eventType: ").append(eventType)
				.append("}").toString();
	}

}
