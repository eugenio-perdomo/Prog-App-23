package uy.turismo.servidorcentral.logic.datatypes;

import java.time.LocalDate;
import java.util.List;

import uy.turismo.servidorcentral.logic.entities.BaseEntity;

public class DtTouristicBundle extends DtBaseEntity {

	private String description;
	private Integer validityPeriod;
	private Double discount;
	private LocalDate uploadDate;
	private List<DtTouristicActivity> activities;
	
	
	public DtTouristicBundle() {
		// TODO Auto-generated constructor stub
	}

	public DtTouristicBundle(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}	
	
	public DtTouristicBundle(Long id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
		return description;
	}

	public Integer getValidityPeriod() {
		return validityPeriod;
	}

	public Double getDiscount() {
		return discount;
	}

	public LocalDate getUploadDate() {
		return uploadDate;
	}

	public List<DtTouristicActivity> getActivities() {
		return activities;
	}

	
}