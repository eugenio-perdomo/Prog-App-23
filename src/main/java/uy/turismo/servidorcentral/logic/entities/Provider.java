package uy.turismo.servidorcentral.logic.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import uy.turismo.servidorcentral.logic.datatypes.DtProvider;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;
import uy.turismo.servidorcentral.logic.datatypes.DtUser;

@Entity
public class Provider extends User {
	
	@Column(length = 150)
	private String description;
	
	@Column(length = 60, name = "web_site")
	private String webSite; 
	
	@OneToMany(mappedBy = "provider", fetch = FetchType.EAGER)
	private List<TouristicActivity> touristicActivities;

	//Constructors
	public Provider() {
		// TODO Auto-generated constructor stub
	}

	public Provider(Long id, String name, String nickname, String email, String lastName, LocalDate birthDate, String description, String webSite) {
		super(id, name, nickname, email, lastName, birthDate);
		this.description = description;
		this.webSite = webSite;
		this.InitLists();
		// TODO Auto-generated constructor stub
	}
	
	//Iniciadores	
	private void InitLists() {
		this.touristicActivities = new ArrayList<TouristicActivity>();
	}


	//Getters and Setters
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
	
	/**
	 * Crea un DtProvdier con todos los datos del objeto y lo devuelve
	 * @return
	 */
	@Override
	public DtUser getDt() {
		
		List<DtTouristicActivity> listDtActivities = new ArrayList<DtTouristicActivity>();
		
		for(TouristicActivity td : this.touristicActivities) {
			listDtActivities.add(td.getShortDt());
		}
		
		DtProvider DtOutput = new DtProvider(
				this.id,
				this.name,
				this.nickname,
				this.email,
				this.lastName,
				this.birthDate,
				this.webSite,
				this.description,
				listDtActivities);	
		return DtOutput;
	}
}
