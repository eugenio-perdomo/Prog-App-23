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
import uy.turismo.servidorcentral.logic.datatypes.DtPurchase;
import uy.turismo.servidorcentral.logic.datatypes.DtTourist;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicBundle;

@Entity
public class Purchase implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "purchase_date")
	private LocalDate purchaseDate;

	@Column(name = "tourist_amount")
	private Integer touristAmount;

	@Column(name = "total_cost")
	private Double totalCost;

	@Column(name = "expire_date")
	private LocalDate expireDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tourist")
	private Tourist tourist;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "touristic_bundle")
	private TouristicBundle touristicBundle;
	
//	Constructors
	public Purchase() {
		
	}

	public Purchase(Long id, LocalDate purchaseDate, Integer touristAmount, Double totalCost, LocalDate expireDate,
			Tourist tourist, TouristicBundle touristicBundle) {
		this.id = id;
		this.purchaseDate = purchaseDate;
		this.touristAmount = touristAmount;
		this.totalCost = totalCost;
		this.expireDate = expireDate;
		this.tourist = tourist;
		this.touristicBundle = touristicBundle;
	}

//	Getters and Setters
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Integer getTouristAmount() {
		return touristAmount;
	}

	public void setTouristAmount(Integer touristAmount) {
		this.touristAmount = touristAmount;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public LocalDate getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

	public Tourist getTourist() {
		return tourist;
	}

	public TouristicBundle getTouristicBundle() {
		return touristicBundle;
	}
	

	public DtTouristicBundle getBundleShortDt() {
		return this.touristicBundle.getShortDt();
	}
	
	public DtPurchase getPurchaseDt() {
		
		DtTourist touristData = null;
		
		try {
			touristData = (DtTourist) this.tourist.getShortDt();
		} catch (Exception e) {
			
			System.out.println("Exception: " + e.getMessage());
		}
		
		
		DtPurchase purchase = new DtPurchase(this.id,
				this.purchaseDate,
				this.touristAmount,
				this.totalCost,
				this.expireDate,
				touristData,
				this.touristicBundle.getShortDt());
		
		return purchase;
	}
	
	
	public DtPurchase getDtForTourist() {
		return new DtPurchase(
				null,
				this.purchaseDate,
				this.touristAmount,
				this.totalCost,
				this.expireDate,
				null,
				this.touristicBundle.getShortDt());	
	}
}
