package uy.turismo.servidorcentral.logic.datatypes;

import java.time.LocalDate;

public class DtInscription {

	private LocalDate inscriptionDate;
	private Double totalCost;
	private Integer touristAmount;
	private Long touristId;
	private Long departureId;
	
	public DtInscription(LocalDate inscriptionDate, Double totalCost, Integer touristAmount, Long touristId,
			Long departureId) {
		super();
		this.inscriptionDate = inscriptionDate;
		this.totalCost = totalCost;
		this.touristAmount = touristAmount;
		this.touristId = touristId;
		this.departureId = departureId;
	}
	
	
	
	
	
}
