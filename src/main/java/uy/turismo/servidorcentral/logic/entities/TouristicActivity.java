package uy.turismo.servidorcentral.logic.entities;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


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
	Provider provider;	
	
	@ManyToOne
	@JoinColumn(name = "department")
	Department department;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<TouristicBundle> touristicBundle;

	
	//Constructor
	public TouristicActivity() {
		// TODO Auto-generated constructor stub
	}
	public TouristicActivity(Long id, String name, String description, Double duration, Double costPerTourist,
			LocalDate uploadDate, String city) {
		super(id);
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.costPerTourist = costPerTourist;
		this.uploadDate = uploadDate;
		this.city = city;
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
	public LocalDate getuploadDate() {
		return uploadDate;
	}
	public void setuploadDate(LocalDate uploadDate) {
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
	
}
