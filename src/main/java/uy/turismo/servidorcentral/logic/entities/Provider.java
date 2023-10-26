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
	
	public Provider(
			Long id,
			String nickname,
			String email) {
		super(id,nickname,email);
	}

	public Provider(
			Long id, 
			String name, 
			String nickname,
			String email, 
			String lastName, 
			LocalDate birthDate,
			String description, 
			String webSite, 
			String password) {
		super(id, name, nickname, email, lastName, birthDate, password);
		this.description = description;
		this.webSite = webSite;
		this.InitLists();
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
	 * @throws Exception 
	 */
	@Override
	public DtUser getDt() throws Exception {
		
		List<DtTouristicActivity> listDtActivities = new ArrayList<DtTouristicActivity>();
		
		if(this.touristicActivities != null) {
			for(TouristicActivity td : this.touristicActivities) {
				listDtActivities.add(td.getShortDt());
			}
			
		}
		
		DtProvider dtOutput = null;

		try {
		dtOutput = new DtProvider(
				this.id,
				this.name,
				this.nickname,
				this.email,
				this.lastName,
				this.birthDate,
				this.getImage(),
				this.webSite,
				this.description,
				listDtActivities,
				this.password);		
		} catch (Exception e) {
			throw e;
		}
		return dtOutput;
	}

	@Override
	public DtUser getShortDt() throws Exception {
		DtUser dtOutput = null;
		try {
			dtOutput = new DtProvider(
					this.id, 
					this.nickname,
					this.email,
					this.getImage());
			
		} catch (Exception e) {
			throw e;
		}
	
		return dtOutput;
	}
}
