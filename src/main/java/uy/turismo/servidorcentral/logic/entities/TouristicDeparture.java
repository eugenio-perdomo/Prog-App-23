/**
 * 
 */
package uy.turismo.servidorcentral.logic.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity(name = "Touristic_Departure")
public class TouristicDeparture extends BaseEntity {

	@Column(length = 100, unique = true)
	private String name;
	
	@Column(name = "max_tourist")
	private Integer maxTourist;
	
	@Column(name = "upload_date_time")
	private LocalDateTime uploadDateTime;
	
	@Column(name = "departure_date_time")
	private LocalDateTime departureDateTime;
	
	@ManyToOne
	@JoinColumn(name = "touristic_activity")
	TouristicActivity touristicActivity;

//  Constructors
	
	public TouristicDeparture() {
		
	}
	
	public TouristicDeparture(Long id, String name, Integer maxTourist, LocalDateTime uploadDateTime,
			LocalDateTime departureDateTime) {
		super(id);
		this.name = name;
		this.maxTourist = maxTourist;
		this.uploadDateTime = uploadDateTime;
		this.departureDateTime = departureDateTime;
	}

//	Getters and Setter
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getMaxTourist() {
		return maxTourist;
	}


	public void setMaxTourist(Integer maxTourist) {
		this.maxTourist = maxTourist;
	}


	public LocalDateTime getUploadDateTime() {
		return uploadDateTime;
	}


	public void setUploadDateTime(LocalDateTime uploadDateTime) {
		this.uploadDateTime = uploadDateTime;
	}


	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}


	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}
	
	
	
	
	
}
