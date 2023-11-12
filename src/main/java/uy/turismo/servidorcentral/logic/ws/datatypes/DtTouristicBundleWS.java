package uy.turismo.servidorcentral.logic.ws.datatypes;

import jakarta.xml.bind.annotation.XmlElement;
import uy.turismo.servidorcentral.logic.datatypes.DtCategory;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicBundle;


public class DtTouristicBundleWS extends DtBaseEntityWS {

	private String description;
	private Integer validityPeriod;
	private Double discount;
	private Double price;
	private String uploadDate;
	private byte[] image;
	private DtTouristicActivityWS[] activities;
	private DtCategoryWS[] categories;
	
	public DtTouristicBundleWS(DtTouristicBundle b, Boolean isShort) {
		super(
				b.getId(),
				b.getName());
		this.image = Converter.convertImageToArray(b.getImage());
		
		if(!isShort) {
			this.description = b.getDescription();
			this.validityPeriod = b.getValidityPeriod();
			this.discount = b.getDiscount();
			this.price = b.getPrice();
			this.uploadDate = Converter.convertDateToString(b.getUploadDate());
			
			if(b.getActivities() != null && !b.getActivities().isEmpty()) {
				this.activities = new DtTouristicActivityWS[b.getActivities().size()];
				int i = 0;
				for(DtTouristicActivity a : b.getActivities()) {
					this.activities[i] = new DtTouristicActivityWS(a, true);
					i++;
				}
			}
			
			if(b.getCategories() != null && !b.getCategories().isEmpty()) {
				this.categories = new DtCategoryWS[b.getCategories().size()];
				int i = 0;
				for(DtCategory c : b.getCategories()) {
					this.categories[i] = new DtCategoryWS(c, true);
					i++;
				}
			}
		}
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	@XmlElement
	public Integer getValidityPeriod() {
		return validityPeriod;
	}

	@XmlElement
	public Double getDiscount() {
		return discount;
	}

	@XmlElement
	public String getUploadDate() {
		return uploadDate;
	}
	
	@XmlElement
	public byte[] getImage() {
		return image;
	}

	@XmlElement
	public DtTouristicActivityWS[] getActivities() {
		return activities;
	}

	@XmlElement
	public DtCategoryWS[] getCategories(){
		return categories;
	}

	@XmlElement
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
