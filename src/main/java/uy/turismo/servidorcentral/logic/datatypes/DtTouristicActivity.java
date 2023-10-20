package uy.turismo.servidorcentral.logic.datatypes;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import uy.turismos.servidorcentral.logic.enums.ActivityState;


public class DtTouristicActivity extends DtBaseEntity {

	private String description;
	private Double duration;
	private Double costPerTourist;
	private String city;
	private BufferedImage image;
	private ActivityState state;
	private LocalDate uploadDate;
	private DtProvider provider;
	private DtDepartment department;
	private List<DtTouristicDeparture> departures;
	private List<DtTouristicBundle> bundles;
	//codigo agregado: LT
	private List<DtCategory> categories;
	
	public DtTouristicActivity() {
		// TODO Auto-generated constructor stub
	}

	public DtTouristicActivity(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public DtTouristicActivity(Long id, String name, BufferedImage image, ActivityState state, String description,DtDepartment department , List<DtCategory> categories) {
		super(id, name);
		this.image = image;
		this.state = state;
		this.description = description;
		this.department = department;
		this.categories = categories;
		// TODO Auto-generated constructor stub
	}
	
	
	//codigo agregado: LT
	public DtTouristicActivity(
			Long id,
			String name,
			String description,
			Double duration,
			Double costPerTourist,
			String city,
			BufferedImage image,
			ActivityState state,
			LocalDate uploadDate,
			DtProvider provider,
			DtDepartment department,
			List<DtTouristicDeparture> departures,
			List<DtTouristicBundle> bundles,
			List<DtCategory> categories) {
		
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

	public List<DtTouristicDeparture> getDepartures() {
		return departures;
	}

	public List<DtTouristicBundle> getBundles() {
		return bundles;
	}
	
	//codigo agregado: LT
	public List<DtCategory> getCategories(){
		return categories;
	}
	
	public ActivityState getState() {
		return state;
	}
	
}
