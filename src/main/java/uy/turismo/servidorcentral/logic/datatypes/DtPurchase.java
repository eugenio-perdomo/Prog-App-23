package uy.turismo.servidorcentral.logic.datatypes;

import java.time.LocalDate;

import uy.turismo.servidorcentral.logic.ws.datatypes.DtPurchaseWS;

public class DtPurchase extends DtBaseEntity {
	
	private LocalDate purchaseDate;
	private Integer touristAmount;
	private Double totalCost;
	private LocalDate expireDate;
	private DtTourist tourist;
	private DtTouristicBundle bundle;
	
	public DtPurchase(DtPurchaseWS p) {
		super(p.getId());
		this.purchaseDate = Converter.convertStringToLD(p.getPurchaseDate());
		this.touristAmount = p.getTouristAmount();
		this.totalCost = p.getTotalCost();
		this.expireDate = Converter.convertStringToLD(p.getExpireDate());
		this.tourist = new DtTourist(p.getTourist().getId());
		this.bundle = new DtTouristicBundle(p.getBundle().getId());
	}
	
	public DtPurchase(
			Long id, 
			LocalDate purchaseDate, 
			Integer touristAmount, 
			Double totalCost, 
			LocalDate expireDate,
			DtTourist tourist, 
			DtTouristicBundle bundle) {
		super(id);
		this.purchaseDate = purchaseDate;
		this.touristAmount = touristAmount;
		this.totalCost = totalCost;
		this.expireDate = expireDate;
		this.tourist = tourist;
		this.bundle = bundle;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public Integer getTouristAmount() {
		return touristAmount;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public LocalDate getExpireDate() {
		return expireDate;
	}

	public DtTourist getTourist() {
		return tourist;
	}

	public DtTouristicBundle getBundle() {
		return bundle;
	}
	
}
