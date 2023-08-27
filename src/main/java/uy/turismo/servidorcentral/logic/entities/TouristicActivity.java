package uy.turismo.servidorcentral.logic.entities;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;


@Entity(name = "Touristic_Activity")
public class TouristicActivity extends BaseEntity {
	

	@Column(length = 100, unique = true)
	protected String name;
	
	@Column(length = 150)
	private String description;
	
	private Double duration;
	
	@Column(name = "cost_per_tourist")
	private Double costPerTourist;
	
	@Column(name = "upload_date")
	private LocalDate uploadDate;
	
	@Column(length = 50)
	private String city;
	
	@ManyToOne
	@JoinColumn(name = "provider")
	private Provider provider;	
	
	@ManyToOne
	@JoinColumn(name = "department")
	private Department department;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<TouristicBundle> touristicBundle;
	
	@OneToMany(mappedBy = "touristicActivity")
	private List<TouristicDeparture> touristicDepartures;

	
	//Constructor
	public TouristicActivity() {
		// TODO Auto-generated constructor stub
	}
	public TouristicActivity(Long id, String name, String description, Double duration, Double costPerTourist,
			LocalDate uploadDate, String city, Provider provider, Department department) {
		super(id);
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.costPerTourist = costPerTourist;
		this.uploadDate = uploadDate;
		this.city = city;
		this.provider = provider;
		this.department = department;
		this.InitLists();
	}
	
	//Iniciadores 
	private void InitLists() {
		this.touristicBundle = new ArrayList<TouristicBundle>();
		this.touristicDepartures = new ArrayList<TouristicDeparture>();
	}

	//Getters y Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public Double getCostPerTourist() {
		return costPerTourist;
	}
	public void setCostPerTourist(Double costPerTourist) {
		this.costPerTourist = costPerTourist;
	}
	public LocalDate getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(LocalDate uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public List<TouristicBundle> getTouristicBundle() {
		return touristicBundle;
	}
	public void setTouristicBundle(List<TouristicBundle> touristicBundle) {
		this.touristicBundle = touristicBundle;
	}
	public List<TouristicDeparture> getTouristicDepartures() {
		return touristicDepartures;
	}
	public void setTouristicDepartures(List<TouristicDeparture> touristicDepartures) {
		this.touristicDepartures = touristicDepartures;
	}
	
	/**
	 * Devuelve un DtTouristicActivity con id y nombre del objeto 
	 * @return
	 */
	public DtTouristicActivity getShortDt() {
		return null;
	}
	
	/**
	 * Devuelve un DtTouristicActivity con todos los datos del objeto 
	 * @return
	 */
	
	public DtTouristicActivity getDt() {
		return null;	
	}
	
}
