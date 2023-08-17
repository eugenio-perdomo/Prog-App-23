package uy.turismo.servidorcentral.logic.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Tourist extends User {
	
	@Column(length = 20)
	private String nationality;

	//Constructors
	public Tourist() {

	}

	public Tourist(Long id, String name, String nickname, String email, String lastName, LocalDate birthDate, String nationality) {
		super(id, name, nickname, email, lastName, birthDate);
		this.nationality = nationality;
		// TODO Auto-generated constructor stub
	}

	//Getters and Setter
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	

	

}
