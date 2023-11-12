package uy.turismo.servidorcentral.logic.ws.datatypes;

import jakarta.xml.bind.annotation.XmlElement;
import uy.turismo.servidorcentral.logic.datatypes.DtInscription;

public class DtInscriptionWS extends DtBaseEntityWS {

	private String inscriptionDate;
	private Double totalCost;
	private Integer touristAmount;
	private DtTouristWS tourist;
	private DtTouristicDepartureWS departure;
	
	public DtInscriptionWS(DtInscription i ) {
		super(i.getId());
		this.inscriptionDate = Converter.convertDateToString(i.getInscriptionDate());
		this.totalCost = i.getTotalCost();
		this.touristAmount = i.getTouristAmount();
		if(i.getTourist() != null) {
			
			this.tourist = new DtTouristWS(i.getTourist(), true);
		}
		if(i.getTouristicDeparture() != null) {
			this.departure = new DtTouristicDepartureWS(i.getTouristicDeparture(), true);
		}
	}	

	@XmlElement
	public String getInscriptionDate() {
		return inscriptionDate;
	}

	@XmlElement
	public Double getTotalCost() {
		return totalCost;
	}

	@XmlElement
	public Integer getTouristAmount() {
		return touristAmount;
	}

	@XmlElement
	public DtTouristWS getTourist() {
		return tourist;
	}

	@XmlElement
	public DtTouristicDepartureWS getTouristicDeparture() {
		return departure;
	}

}
