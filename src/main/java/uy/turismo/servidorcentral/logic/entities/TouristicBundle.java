package uy.turismo.servidorcentral.logic.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "Touristic_Bundle")
public class TouristicBundle extends BaseEntity {
	
	@Column(length = 100, unique = true)
	private String name;

	@Column(length = 150)
	private String description;
	
	private Integer validityPeriod;
	
	private Double discount;
	
	@Column(name = "upload_date")
	private LocalDate uploadDate;
	
	//Constructors
	public TouristicBundle() {
		// TODO Auto-generated constructor stub
	}

	public TouristicBundle(Long id, String name, String description, Integer validityPeriod, Double discount, LocalDate uploadDate) {
		super(id);
		this.name = name;
		this.description = description;
		this.validityPeriod = validityPeriod;
		this.discount = discount;
		this.uploadDate = uploadDate;
	}
	
	

	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Integer validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	

	public LocalDate getUploadDate() {
		return uploadDate;
	}
	
	public void setUploadDate(LocalDate uploadDate) {
		this.uploadDate = uploadDate;
	}

}
