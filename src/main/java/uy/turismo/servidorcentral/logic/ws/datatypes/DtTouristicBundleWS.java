package uy.turismo.servidorcentral.logic.ws.datatypes;

import jakarta.xml.bind.annotation.XmlElement;
import uy.turismo.servidorcentral.logic.datatypes.DtCategory;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicBundle;


public class DtTouristicBundleWS extends DtBaseEntityWS {

	@XmlElement
	private String description;
	@XmlElement
	private Integer validityPeriod;
	@XmlElement
	private Double discount;
	@XmlElement
	private Double price;
	@XmlElement
	private String uploadDate;
	@XmlElement
	private byte[] image;
	@XmlElement
	private DtTouristicActivityWS[] activities;
	@XmlElement
	private DtCategoryWS[] categories;
	
	public DtTouristicBundleWS() {
		
	}
	
	public DtTouristicBundleWS(DtTouristicBundle b, Boolean isShort) {
		super(
				b.getId(),
				b.getName());
		this.image = Converter.convertImageToArray(b.getImage());
		this.uploadDate = Converter.convertDateToString(b.getUploadDate());

		if(b.getCategories() != null && !b.getCategories().isEmpty()) {
			this.categories = new DtCategoryWS[b.getCategories().size()];
			int i = 0;
			for(DtCategory c : b.getCategories()) {
				this.categories[i] = new DtCategoryWS(c, true);
				i++;
			}
		}
		
		if(!isShort) {
			this.description = b.getDescription();
			this.validityPeriod = b.getValidityPeriod();
			this.discount = b.getDiscount();
			this.price = b.getPrice();
			
			if(b.getActivities() != null && !b.getActivities().isEmpty()) {
				this.activities = new DtTouristicActivityWS[b.getActivities().size()];
				int i = 0;
				for(DtTouristicActivity a : b.getActivities()) {
					this.activities[i] = new DtTouristicActivityWS(a, true);
					i++;
				}
			}
			
		}
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

	
	public String getUploadDate() {
		return uploadDate;
	}
	
	
	public byte[] getImage() {
		return image;
	}

	
	public DtTouristicActivityWS[] getActivities() {
		return activities;
	}

	
	public DtCategoryWS[] getCategories(){
		return categories;
	}

	
	public Double getPrice(){
		return price;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(!(obj instanceof DtTouristicBundleWS)) {
			return false;
		}
		
		if(((DtTouristicBundleWS) obj).getId() != this.id) {
			return false;
		}
		
		return true;
		
		
	}
}
