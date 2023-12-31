package uy.turismo.servidorcentral.logic.datatypes;

import java.time.LocalDate;

import uy.turismo.servidorcentral.logic.entities.Tourist;
import uy.turismo.servidorcentral.logic.entities.TouristicDeparture;

public class DtInscription extends DtBaseEntity {

	private LocalDate inscriptionDate;
	private Double totalCost;
	private Integer touristAmount;
	private DtTourist tourist;
	private DtTouristicDeparture departure;
	
	public DtInscription() {
		// TODO Auto-generated constructor stub
	}

	public DtInscription(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}	
	
	public DtInscription(Long id,
			LocalDate inscriptionDate,
			Double totalCost,
			Integer touristAmount,
			DtTourist tourist,
			DtTouristicDeparture departure) {
		super(id);
		this.inscriptionDate = inscriptionDate;
		this.totalCost = totalCost;
		this.touristAmount = touristAmount;
		this.tourist = tourist;
		this.departure = departure;
	}
		
	public LocalDate getInscriptionDate() {
		return inscriptionDate;
	}
	
	public Double getTotalCost() {
		return totalCost;
	}
	
	public Integer getTouristAmount() {
		return touristAmount;
	}
	
	public DtTourist getTourist() {
		return tourist;
	}
	
	public DtTouristicDeparture getTouristicDeparture() {
		return departure;
	}

}
