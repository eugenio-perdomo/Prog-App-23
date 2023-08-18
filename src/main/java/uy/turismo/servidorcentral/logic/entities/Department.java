package uy.turismo.servidorcentral.logic.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Department extends BaseEntity {


	@Column(length = 50, unique = true)
	private String name;
	
	@Column(length = 250)
	private String description;
	
	@Column(length = 60, name = "web_site")
	private String webSite; 
	
	//Constructor
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(Long id, String name, String description, String webSite) {
		super(id);
		this.name = name;
		this.description = description;
		this.webSite = webSite;
		// TODO Auto-generated constructor stub
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
	
	

}
