package uy.turismo.servidorcentral.logic.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Purchase extends BaseEntity {
	
	@Column(name = "purchase_date")
	private LocalDate purchaseDate;

	@Column(name = "tourist_amount")
	private Integer touristAmount;

	@Column(name = "total_cost")
	private Double totalCost;

	@Column(name = "expire_date")
	private LocalDate expireDate;
	
	@ManyToOne
	@JoinColumn(name = "tourist")
	private Tourist tourist;
	
	@ManyToOne
	@JoinColumn(name = "touristic_bundle")
	private TouristicBundle touristicBundle;
	
//	Constructors
	public Purchase() {
		
	}

	public Purchase(Long id, LocalDate purchaseDate, Integer touristAmount, Double totalCost, LocalDate expireDate,
			Tourist tourist, TouristicBundle touristicBundle) {
		super(id);
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
	
	

}
