package uy.turismo.servidorcentral.logic.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;

@Entity
public class Inscription extends BaseEntity {

	@Column(name = "inscription_date")
	private LocalDate inscriptionDate;
	
	@Column(name = "total_cost")
	private Double totalCost;

	@Column(name = "tourist_amount")
	private Integer touristAmount;
	
	@ManyToOne
	@JoinColumn(name = "tourist")
	private Tourist tourist;
	
	@ManyToOne
	@JoinColumn(name = "touristic_departure")
	private TouristicDeparture touristicDeparture;

//	Constructor
	public Inscription() {
		
	}
	
	public Inscription(Long id, LocalDate inscriptionDate, Double totalCost, Integer touristAmount, Tourist tourist,
			TouristicDeparture touristicDeparture) {
		super(id);
		this.inscriptionDate = inscriptionDate;
		this.totalCost = totalCost;
		this.touristAmount = touristAmount;
		this.tourist = tourist;
		this.touristicDeparture = touristicDeparture;
	}

	
//  Getters and Setters
	public LocalDate getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(LocalDate inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Integer getTouristAmount() {
		return touristAmount;
	}

	public void setTouristAmount(Integer touristAmount) {
		this.touristAmount = touristAmount;
	}

	public Tourist getTourist() {
		return tourist;
	}

	public TouristicDeparture getTouristicDeparture() {
		return touristicDeparture;
	}
	
	public DtTouristicDeparture getDepartureShortDt() {
		return this.touristicDeparture.getShortDt();
	}
	
	
	
}
