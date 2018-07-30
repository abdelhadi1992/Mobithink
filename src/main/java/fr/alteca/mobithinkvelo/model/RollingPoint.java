package fr.alteca.mobithinkvelo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="RollingPoint",schema="public")
public class RollingPoint implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identifiant;
	private Long id;
	private String catchTime;
	private double catchLatitude;
	private double catchLongitude;
	
	public RollingPoint() {
		super();
	}

	public RollingPoint(Long id, String catchTime, double catchLatitude, double catchLongitude) {
		super();
		this.id = id;
		this.catchTime = catchTime;
		this.catchLatitude = catchLatitude;
		this.catchLongitude = catchLongitude;
	}
	
	public int getIdentifiant() {
		return identifiant;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCatchTime() {
		return catchTime;
	}
	public void setCatchTime(String catchTime) {
		this.catchTime = catchTime;
	}
	public double getCatchLatitude() {
		return catchLatitude;
	}
	public void setCatchLatitude(double catchLatitude) {
		this.catchLatitude = catchLatitude;
	}
	public double getCatchLongitude() {
		return catchLongitude;
	}
	public void setCatchLongitude(double catchLongitude) {
		this.catchLongitude = catchLongitude;
	}
	
	

	@Override
	public String toString() {
		return new StringBuilder().append("RollingPoint{")
				.append("id: ").append(id)
				.append(", catchTime: ").append(catchTime)
				.append(", catchLatitude: ").append(catchLatitude)
				.append(", catchLongitude: ").append(catchLongitude)
				.append("}").toString();
	}
    
    
    
}
