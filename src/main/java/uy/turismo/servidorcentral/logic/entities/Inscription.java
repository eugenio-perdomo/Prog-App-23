package uy.turismo.servidorcentral.logic.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;
import uy.turismo.servidorcentral.logic.datatypes.DtInscription;
import uy.turismo.servidorcentral.logic.datatypes.DtTourist;

@Entity
public class Inscription implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "inscription_date")
	private LocalDate inscriptionDate;
	
	@Column(name = "total_cost")
	private Double totalCost;

	@Column(name = "tourist_amount")
	private Integer touristAmount;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tourist")
	private Tourist tourist;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "touristic_departure")
	private TouristicDeparture touristicDeparture;

//	Constructor
	public Inscription() {
		
	}
	
	public Inscription(Long id, LocalDate inscriptionDate, Double totalCost, Integer touristAmount, Tourist tourist,
			TouristicDeparture touristicDeparture) {
		this.id = id;
		this.inscriptionDate = inscriptionDate;
		this.totalCost = totalCost;
		this.touristAmount = touristAmount;
		this.tourist = tourist;
		this.touristicDeparture = touristicDeparture;
	}

	
//  Getters and Setters
//	public Long getId() {
//		return id;
//	}
//	
//	public void setId(Long id) {
//		this.id = id;
//	}
//	
//	public LocalDate getInscriptionDate() {
//		return inscriptionDate;
//	}
//
//	public void setInscriptionDate(LocalDate inscriptionDate) {
//		this.inscriptionDate = inscriptionDate;
//	}
//
//	public Double getTotalCost() {
//		return totalCost;
//	}
//
//	public void setTotalCost(Double totalCost) {
//		this.totalCost = totalCost;
//	}
//
//	public Integer getTouristAmount() {
//		return touristAmount;
//	}
//
//	public void setTouristAmount(Integer touristAmount) {
//		this.touristAmount = touristAmount;
//	}
//
//	public Tourist getTourist() {
//		return tourist;
//	}
//
//	public TouristicDeparture getTouristicDeparture() {
//		return touristicDeparture;
//	}
	
	public DtTouristicDeparture getDepartureShortDt() {
		return this.touristicDeparture.getShortDt();
	}
	
	public DtTourist getTouristShortDt() {
		
		DtTourist dtOutPut = null;
		
		try {
			dtOutPut = (DtTourist) this.tourist.getShortDt();
			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		return dtOutPut;
	}
	
	public DtInscription getDt() {
		return new DtInscription(
				null,
				this.inscriptionDate,
				this.totalCost,
				this.touristAmount,
				null,
				null
				);
				
				
	}
}
