package uy.turismo.servidorcentral.logic.datatypes;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.List;


public class DtTouristicBundle extends DtBaseEntity {

	private String description;
	private Integer validityPeriod;
	private Double discount;
	private LocalDate uploadDate;
	private BufferedImage image;
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

	
	public DtTouristicBundle(Long id, String  name, String description, Integer validity, Double discount, LocalDate uploadDate, 
			BufferedImage image, List<DtTouristicActivity> activities) {
		super (id,name);
		this.description  = description;
		this.validityPeriod = validity;
		this.discount = discount;
		this.uploadDate = uploadDate;
		this.image = image;
		this.activities  = activities;
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
	

	public BufferedImage getImage() {
		return image;
	}

	public List<DtTouristicActivity> getActivities() {
		return activities;
	}

	
}
