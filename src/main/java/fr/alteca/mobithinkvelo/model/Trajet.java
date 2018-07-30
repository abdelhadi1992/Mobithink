package fr.alteca.mobithinkvelo.model;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Trajet",schema="public")
public class Trajet implements Serializable{
	@Id
	private Long id;
	private String startTrajet;
	private String endTrajet;
//	private List<RollingPoint> rollingPoints = new Vector<RollingPoint>();
//	private List<Event> events = new Vector<Event>();
	public Trajet() {
	}
	
	

	
	public Trajet(Long id, String startTrajet, String endTrajet) {
	
		this.id = id;
		this.startTrajet = startTrajet;
		this.endTrajet = endTrajet;
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
	
	@Override
	public String toString() {
		return new StringBuilder().append("Trajet{")
				.append("id: ").append(id)
				.append(", startTrajet: ").append(startTrajet)
				.append(", endTrajet: ").append(endTrajet)
				.append("}").toString();
	}
}
