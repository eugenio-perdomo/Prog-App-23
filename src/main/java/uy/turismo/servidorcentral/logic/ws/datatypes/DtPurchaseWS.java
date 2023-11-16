package uy.turismo.servidorcentral.logic.ws.datatypes;

import jakarta.xml.bind.annotation.XmlElement;
import uy.turismo.servidorcentral.logic.datatypes.DtPurchase;

public class DtPurchaseWS extends DtBaseEntityWS {

	@XmlElement
	private String purchaseDate;
	@XmlElement
	private Integer touristAmount;
	@XmlElement
	private Double totalCost;
	@XmlElement
	private String expireDate;
	@XmlElement
	private DtTouristWS tourist;
	@XmlElement
	private DtTouristicBundleWS bundle;
	
	public DtPurchaseWS() {
		
	}
	
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

	
	public String getPurchaseDate() {
		return purchaseDate;
	}

	
	public Integer getTouristAmount() {
		return touristAmount;
	}

	
	public Double getTotalCost() {
		return totalCost;
	}

	
	public String getExpireDate() {
		return expireDate;
	}

	
	public DtTouristWS getTourist() {
		return tourist;
	}

	
	public DtTouristicBundleWS getBundle() {
		return bundle;
	}
	
}
