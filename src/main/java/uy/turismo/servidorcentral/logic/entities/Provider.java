package uy.turismo.servidorcentral.logic.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Provider extends User {
	
	@Column(length = 150)
	private String description;
	
	@Column(length = 60, name = "web_site")
	private String webSite; 

	//Constructors
	public Provider() {
		// TODO Auto-generated constructor stub
	}

	public Provider(Long id, String name, String nickname, String email, String lastName, LocalDate birthDate, String description, String webSite) {
		super(id, name, nickname, email, lastName, birthDate);
		this.description = description;
		this.webSite = webSite;
		
		// TODO Auto-generated constructor stub
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
	
	

}
