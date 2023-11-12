package uy.turismo.servidorcentral.logic.ws.datatypes;

import jakarta.xml.bind.annotation.XmlElement;
import uy.turismo.servidorcentral.logic.datatypes.DtPurchase;

public class DtPurchaseWS extends DtBaseEntityWS {
	
	private String purchaseDate;
	private Integer touristAmount;
	private Double totalCost;
	private String expireDate;
	private DtTouristWS tourist;
	private DtTouristicBundleWS bundle;
	
	public DtPurchaseWS(DtPurchase p) {
		super(p.getId());
		this.purchaseDate = Converter.convertDateToString(p.getPurchaseDate());
		this.touristAmount = p.getTouristAmount();
		this.totalCost = p.getTotalCost();
		this.expireDate = Converter.convertDateToString(p.getExpireDate());
		if(p.getTourist() != null) {
			this.tourist = new DtTouristWS(p.getTourist(), true);
			
		}
		if(p.getBundle() != null) {
			this.bundle = new DtTouristicBundleWS(p.getBundle(), true);
			
		}
	}

	@XmlElement
	public String getPurchaseDate() {
		return purchaseDate;
	}

	@XmlElement
	public Integer getTouristAmount() {
		return touristAmount;
	}

	@XmlElement
	public Double getTotalCost() {
		return totalCost;
	}

	@XmlElement
	public String getExpireDate() {
		return expireDate;
	}

	@XmlElement
	public DtTouristWS getTourist() {
		return tourist;
	}

	@XmlElement
	public DtTouristicBundleWS getBundle() {
		return bundle;
	}
	
}
