package uy.turismo.servidorcentral.logic.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne; to clean later
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import uy.turismo.servidorcentral.logic.datatypes.DtDepartment;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;

@Entity
public class Department implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, unique = true)
	private String name;
	
	@Column(length = 250)
	private String description;
	
	@Column(length = 60, name = "web_site")
	private String webSite; 
	
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	private List<TouristicActivity> touristicActivities;
	
	//Constructor
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(Long id, String name, String description, String webSite) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.webSite = webSite;
		this.InitLists();
		// TODO Auto-generated constructor stub
	}
	
	//Iniciadores	
	private void InitLists() {
		this.touristicActivities = new ArrayList<TouristicActivity>();
	}

	//Getters and Setter
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TouristicActivity> getTouristicActivities() {
		return touristicActivities;
	}

	public void setTouristicActivities(List<TouristicActivity> touristicActivities) {
		this.touristicActivities = touristicActivities;
	}

	/**
	 * Devuelve un DtDepartment con id y nombre del objeto
	 * @return
	 */
	public DtDepartment getShortDt() {
		DtDepartment dtOutput = new DtDepartment(
				this.id, 
				this.name);
		return dtOutput;
	}
	
	/**
	 * Devuelve un DtDepartment con todos los datos y sus actividades turisticas
	 * @return
	 */
	public DtDepartment getDtWithActivities() {
		
		List<DtTouristicActivity> listDtActivities = new ArrayList<DtTouristicActivity>();
		
		for(TouristicActivity td : this.touristicActivities) {
			listDtActivities.add(td.getShortDt());
		}
		
		DtDepartment dtOutput = new DtDepartment(
				this.id,
				this.name,
				this.description,
				this.webSite,
				listDtActivities);
		return dtOutput;
	}

}
