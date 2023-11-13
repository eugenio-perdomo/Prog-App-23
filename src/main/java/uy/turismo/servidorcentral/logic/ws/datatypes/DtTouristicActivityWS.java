package uy.turismo.servidorcentral.logic.ws.datatypes;

import jakarta.xml.bind.annotation.XmlElement;
import uy.turismo.servidorcentral.logic.datatypes.DtCategory;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicBundle;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;
import uy.turismo.servidorcentral.logic.enums.ActivityState;

public class DtTouristicActivityWS extends DtBaseEntityWS {

	private String description;
	private Double duration;
	private Double costPerTourist;
	private String city;
	private byte[] image;
	private ActivityState state;
	private String uploadDate;
	private DtProviderWS provider;
	private DtDepartmentWS department;
	private DtTouristicDepartureWS[] departures;
	private DtTouristicBundleWS[] bundles;
	private DtCategoryWS[] categories;
	private Integer visitsAmount;
	private String urlVideo;

	public DtTouristicActivityWS(DtTouristicActivity a, Boolean isShort) {
		super(
				a.getId(),
				a.getName());
		this.image = Converter.convertImageToArray(a.getImage());
		this.state = a.getState();
		this.description = a.getDescription();
		this.department = new DtDepartmentWS(a.getDepartment(), true);
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
			this.uploadDate = Converter.convertDateToString(a.getUploadDate());
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

	@XmlElement
	public String getDescription() {
		return description;
	}


	@XmlElement
	public Double getDuration() {
		return duration;
	}


	@XmlElement
	public Double getCostPerTourist() {
		return costPerTourist;
	}


	@XmlElement
	public String getCity() {
		return city;
	}


	@XmlElement
	public byte[] getImage() {
		return image;
	}

	@XmlElement
	public String getUploadDate() {
		return uploadDate;
	}

	@XmlElement
	public DtProviderWS getProvider() {
		return provider;
	}

	@XmlElement
	public DtDepartmentWS getDepartment() {
		return department;
	}

	@XmlElement
	public DtTouristicDepartureWS[] getDepartures() {
		return departures;
	}

	@XmlElement
	public DtTouristicBundleWS[] getBundles() {
		return bundles;
	}

	// codigo agregado: LT
	@XmlElement
	public DtCategoryWS[] getCategories() {
		return categories;
	}

	@XmlElement
	public ActivityState getState() {
		return state;
	}
	
	@XmlElement
	public Integer getVisitsAmount() {
		return visitsAmount;
	}

	@XmlElement
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
