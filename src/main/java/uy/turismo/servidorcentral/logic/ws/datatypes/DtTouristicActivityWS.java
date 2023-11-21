package uy.turismo.servidorcentral.logic.ws.datatypes;

import jakarta.xml.bind.annotation.XmlElement;
import uy.turismo.servidorcentral.logic.datatypes.DtCategory;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicBundle;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;
import uy.turismo.servidorcentral.logic.enums.ActivityState;

public class DtTouristicActivityWS extends DtBaseEntityWS {

	@XmlElement
	private String description;
	@XmlElement
	private Double duration;
	@XmlElement
	private Double costPerTourist;
	@XmlElement
	private String city;
	@XmlElement
	private byte[] image;
	@XmlElement
	private ActivityState state;
	@XmlElement
	private String uploadDate;
	@XmlElement
	private DtProviderWS provider;
	@XmlElement
	private DtDepartmentWS department;
	@XmlElement
	private DtTouristicDepartureWS[] departures;
	@XmlElement
	private DtTouristicBundleWS[] bundles;
	@XmlElement
	private DtCategoryWS[] categories;
	@XmlElement
	private Integer visitsAmount;
	@XmlElement
	private String urlVideo;

	public DtTouristicActivityWS() {
		
	}
	
	public DtTouristicActivityWS(DtTouristicActivity a, Boolean isShort) {
		super(
				a.getId(),
				a.getName());
		this.image = Converter.convertImageToArray(a.getImage());
		this.state = a.getState();
		this.uploadDate = Converter.convertDateToString(a.getUploadDate());
		this.description = a.getDescription();
		this.department = new DtDepartmentWS(a.getDepartment(), true, false);
		this.visitsAmount = a.getVisits();
		this.urlVideo = a.getVideoURL();

		if(a.getCategories() != null && !a.getCategories().isEmpty()) {
			this.categories = new DtCategoryWS[a.getCategories().size()];
			int i = 0;
			for(DtCategory c : a.getCategories()) {
				this.categories[i] = new DtCategoryWS(c, true);
				i++;
			}
		}
		
		if(!isShort) {
			this.duration = a.getDuration();
			this.costPerTourist = a.getCostPerTourist();
			this.city = a.getCity();
			this.provider = new DtProviderWS(a.getProvider(), true);
			
			if(a.getBundles() != null && !a.getBundles().isEmpty()) {
				this.bundles = new DtTouristicBundleWS[a.getBundles().size()];
				int i = 0;
				for(DtTouristicBundle b : a.getBundles()) {
					this.bundles[i] = new DtTouristicBundleWS(b, true);
					i++;
				}
			}
			
			if(a.getDepartures() != null && !a.getDepartures().isEmpty()) {
				this.departures = new DtTouristicDepartureWS[a.getDepartures().size()];
				int i = 0;
				for(DtTouristicDeparture d : a.getDepartures()) {
					this.departures[i] = new DtTouristicDepartureWS(d, true);
					i++;
				}
			}
		}
		
		
	}

	
	public String getDescription() {
		return description;
	}


	
	public Double getDuration() {
		return duration;
	}


	
	public Double getCostPerTourist() {
		return costPerTourist;
	}


	
	public String getCity() {
		return city;
	}


	
	public byte[] getImage() {
		return image;
	}

	
	public String getUploadDate() {
		return uploadDate;
	}

	
	public DtProviderWS getProvider() {
		return provider;
	}

	
	public DtDepartmentWS getDepartment() {
		return department;
	}

	
	public DtTouristicDepartureWS[] getDepartures() {
		return departures;
	}

	
	public DtTouristicBundleWS[] getBundles() {
		return bundles;
	}

	// codigo agregado: LT
	
	public DtCategoryWS[] getCategories() {
		return categories;
	}

	
	public ActivityState getState() {
		return state;
	}
	
	
	public Integer getVisitsAmount() {
		return visitsAmount;
	}

	
	public String getUrlVideo() {
		return urlVideo;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof DtTouristicActivityWS)) {
			return false;
		}

		if (this.id == ((DtTouristicActivityWS) obj).getId()) {
			return true;
		}

		return false;
	}

}
