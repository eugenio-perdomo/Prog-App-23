package uy.turismo.servidorcentral.logic.ws.datatypes;

import jakarta.xml.bind.annotation.XmlElement;
import uy.turismo.servidorcentral.logic.datatypes.DtInscription;

public class DtInscriptionWS extends DtBaseEntityWS {

	@XmlElement
	private String inscriptionDate;
	@XmlElement
	private Double totalCost;
	@XmlElement
	private Integer touristAmount;
	@XmlElement
	private DtTouristWS tourist;
	@XmlElement
	private DtTouristicDepartureWS departure;
	
	public DtInscriptionWS() {
		
	}
	
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

	
	public String getInscriptionDate() {
		return inscriptionDate;
	}

	
	public Double getTotalCost() {
		return totalCost;
	}

	
	public Integer getTouristAmount() {
		return touristAmount;
	}

	
	public DtTouristWS getTourist() {
		return tourist;
	}

	
	public DtTouristicDepartureWS getTouristicDeparture() {
		return departure;
	}

}
