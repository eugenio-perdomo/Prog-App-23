package uy.turismo.servidorcentral.logic.datatypes;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;

import uy.turismo.servidorcentral.logic.ws.datatypes.DtTouristicBundleWS;


public class DtTouristicBundle extends DtBaseEntity {

	private String description;
	private Integer validityPeriod;
	private Double discount;

	private Double price;
	
	private LocalDate uploadDate;
	private BufferedImage image;
	private ArrayList<DtTouristicActivity> activities;
	private ArrayList<DtCategory> categories;
	

	public DtTouristicBundle(DtTouristicBundleWS b) {
		super(b.getId(), b.getName());
		this.description = b.getDescription();
		this.validityPeriod = b.getValidityPeriod();
		this.discount = b.getDiscount();
		this.price = b.getPrice();
		this.uploadDate = Converter.convertStringToLD(b.getUploadDate());
		this.image = Converter.convertArrayToBI(b.getImage());
	}	
	
	public DtTouristicBundle(
			Long id, 
			String name, 
			BufferedImage image,
			LocalDate uploadDate,
			ArrayList<DtCategory> categories) {
		super(id, name);
		this.image = image;
		this.uploadDate = uploadDate;
		this.categories = categories;
	}

	public DtTouristicBundle(Long id) {
		super(id);
	}
	

	public DtTouristicBundle(Long id, String  name, String description, Integer validity, Double discount, LocalDate uploadDate, 
			BufferedImage image, ArrayList<DtTouristicActivity> activities, ArrayList<DtCategory> categories, Double price) {

		super (id,name);
		this.description  = description;
		this.validityPeriod = validity;
		this.discount = discount;
		this.uploadDate = uploadDate;
		this.image = image;
		this.activities  = activities;
		this.categories = categories;
		this.price = price;
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

	public ArrayList<DtTouristicActivity> getActivities() {
		return activities;
	}
	
	public ArrayList<DtCategory> getCategories(){
		return categories;
	}

	public Double getPrice(){
		return price;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(!(obj instanceof DtTouristicBundle)) {
			return false;
		}
		
		if(((DtTouristicBundle) obj).getId() != this.id) {
			return false;
		}
		
		return true;
		
		
	}
}
