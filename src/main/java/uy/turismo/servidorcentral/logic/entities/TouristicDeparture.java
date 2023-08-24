/**
 * 
 */
package uy.turismo.servidorcentral.logic.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;

@Entity(name = "Touristic_Departure")
public class TouristicDeparture extends BaseEntity {

	@Column(length = 100, unique = true)
	private String name;
	
	@Column(name = "max_tourist")
	private Integer maxTourist;
	
	@Column(name = "upload_date")
	private LocalDate uploadDate;
	
	@Column(name = "departure_date_time")
	private LocalDateTime departureDateTime;

	@Column(length = 150)
	private String place;
	
	@ManyToOne
	@JoinColumn(name = "touristic_activity")
	private TouristicActivity touristicActivity;
	
	@OneToMany(mappedBy = "touristicDeparture")
	private List<Inscription> inscriptions;

//  Constructors
	
	public TouristicDeparture() {
		
	}
	
	public TouristicDeparture(Long id, String name, Integer maxTourist, LocalDate uploadDate,
			LocalDateTime departureDateTime, String place, TouristicActivity touristicActivity) {
		super(id);
		this.name = name;
		this.maxTourist = maxTourist;
		this.uploadDate = uploadDate;
		this.departureDateTime = departureDateTime;
		this.place = place;
		this.touristicActivity = touristicActivity;
		this.initLists();
	}
	
	//Iniciadores
	private void initLists() {
		this.inscriptions = new ArrayList<Inscription>();
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


	public LocalDate getuploadDate() {
		return uploadDate;
	}


	public void setuploadDate(LocalDate uploadDate) {
		this.uploadDate = uploadDate;
	}


	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}


	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	/**
	 * Crea un DtTouristicDeparture con el id y el nombre del objeto
	 * @return
	 */
	public DtTouristicDeparture getShortDt() {
		return null;
	}
	
	/**
	 * Crea un DtTouristicDeparture con todos los datos del objeto
	 * @return
	 */
	public DtTouristicDeparture getDt() {
		return null;
	}
	
	
}
