package uy.turismo.servidorcentral.logic.datatypes;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.List;


public class DtTouristicActivity extends DtBaseEntity {

	private String description;
	private Double duration;
	private Double costPerTourist;
	private String city;
	private BufferedImage image;
	private LocalDate uploadDate;
	private DtProvider provider;
	private DtDepartment department;
	private List<DtTouristicDeparture> departures;
	private List<DtTouristicBundle> bundles;
	
	
	public DtTouristicActivity() {
		// TODO Auto-generated constructor stub
	}

	public DtTouristicActivity(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public DtTouristicActivity(Long id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}
	
	
	public DtTouristicActivity(Long id, String name, String description, Double duration, Double costPerTourist, String city,
			BufferedImage image, LocalDate uploadDate, DtProvider provider, DtDepartment department, List<DtTouristicDeparture> departures,
			List<DtTouristicBundle> bundles) {
		super(id, name);
		this.description = description;
		this.duration = duration;
		this.costPerTourist = costPerTourist;
		this.city = city;
		this.image = image;
		this.uploadDate = uploadDate;
		this.provider = provider;
		this.department = department;
		this.departures = departures;
		this.bundles = bundles;
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
	
}
