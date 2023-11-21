package uy.turismo.servidorcentral.logic.datatypes;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;

import uy.turismo.servidorcentral.logic.enums.ActivityState;
import uy.turismo.servidorcentral.logic.ws.datatypes.DtCategoryWS;
import uy.turismo.servidorcentral.logic.ws.datatypes.DtTouristicActivityWS;

public class DtTouristicActivity extends DtBaseEntity {
	
	private Integer visitsAmount;
	private String urlVideo;
	private String description;
	private Double duration;
	private Double costPerTourist;
	private String city;
	private BufferedImage image;
	private ActivityState state;
	private LocalDate uploadDate;
	private DtProvider provider;
	private DtDepartment department;
	private ArrayList<DtTouristicDeparture> departures;
	private ArrayList<DtTouristicBundle> bundles;
	// codigo agregado: LT
	private ArrayList<DtCategory> categories;
	
	public DtTouristicActivity() {
	}

	public DtTouristicActivity(DtTouristicActivityWS a) {
		super(a.getId(), a.getName());
		this.description = a.getDescription();
		this.duration = a.getDuration();
		this.costPerTourist = a.getCostPerTourist();
		this.city = a.getCity();
		this.image = Converter.convertArrayToBI(a.getImage());
		this.state = a.getState();
		this.urlVideo = a.getUrlVideo();
		
		if(a.getUploadDate() != null) {
			this.uploadDate = Converter.convertStringToLD(a.getUploadDate());	
		}
		if(a.getDepartment() != null) {
			this.provider = new DtProvider(a.getProvider().getId());
		}
		if(a.getProvider() != null) {
			this.department = new DtDepartment(a.getDepartment().getId());
			
		}
		
		if(a.getCategories() != null) {
			this.categories = new ArrayList<DtCategory>();
			for(DtCategoryWS category : a.getCategories()) {
				this.categories.add(new DtCategory(category));
			}
		}
	}

	//Para el ShortDt
	public DtTouristicActivity(
			Long id, 
			String name, 
			LocalDate uploadDate,
			BufferedImage image, 
			ActivityState state, 
			String description,
			DtDepartment department, 
			ArrayList<DtCategory> categories) {
		super(id, name);
		this.image = image;
		this.uploadDate = uploadDate;
		this.state = state;
		this.description = description;
		this.department = department;
		this.categories = categories;
	}
	
	public DtTouristicActivity(Long id, String name, DtProvider provider, ArrayList<DtTouristicDeparture> departures, Integer visits) {
		super(id, name);
		this.provider = provider;
		this.departures = departures;
		this.visitsAmount = visits;
	}
	
	public DtTouristicActivity(Long id, String name, DtProvider provider) {
		super(id, name);
		this.provider = provider;
	}

	// codigo agregado: LT
	public DtTouristicActivity(Long id, String name, String description, Double duration, Double costPerTourist,
			String city, BufferedImage image, ActivityState state, LocalDate uploadDate, DtProvider provider,
			DtDepartment department, ArrayList<DtTouristicDeparture> departures, ArrayList<DtTouristicBundle> bundles,
			ArrayList<DtCategory> categories, Integer visits, String videoURL) {

		super(id, name);
		this.description = description;
		this.duration = duration;
		this.costPerTourist = costPerTourist;
		this.city = city;
		this.image = image;
		this.state = state;
		this.uploadDate = uploadDate;
		this.provider = provider;
		this.department = department;
		this.departures = departures;
		this.bundles = bundles;
		this.categories = categories;
		this.visitsAmount = visits;
		this.urlVideo = videoURL;
	}
	
	
	public Integer getVisits() {
		return visitsAmount;
	}
	
	public String getVideoURL() {
		return urlVideo;
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


	public BufferedImage getImage() {
		return image;
	}

	public LocalDate getUploadDate() {
		return uploadDate;
	}

	public DtProvider getProvider() {
		return provider;
	}

	public DtDepartment getDepartment() {
		return department;
	}

	public ArrayList<DtTouristicDeparture> getDepartures() {
		return departures;
	}

	public ArrayList<DtTouristicBundle> getBundles() {
		return bundles;
	}

	// codigo agregado: LT
	public ArrayList<DtCategory> getCategories() {
		return categories;
	}

	public ActivityState getState() {
		return state;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof DtTouristicActivity)) {
			return false;
		}

		if (this.id == ((DtTouristicActivity) obj).getId()) {
			return true;
		}

		return false;
	}

}
