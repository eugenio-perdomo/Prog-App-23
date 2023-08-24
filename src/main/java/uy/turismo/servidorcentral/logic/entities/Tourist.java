package uy.turismo.servidorcentral.logic.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import uy.turismo.servidorcentral.logic.datatypes.DtUser;

@Entity
public class Tourist extends User {
	
	@Column(length = 20)
	private String nationality;
	
	@OneToMany(mappedBy = "tourist")
	private List<Inscription> inscriptions;

	//Constructors
	public Tourist() {

	}

	public Tourist(Long id, String name, String nickname, String email, String lastName, LocalDate birthDate, String nationality) {
		super(id, name, nickname, email, lastName, birthDate);
		this.nationality = nationality;
		this.initLists();
		// TODO Auto-generated constructor stub
	}
	
	//Iniciadores
	private void initLists() {
		this.inscriptions = new ArrayList<Inscription>();
	}

	//Getters and Setter
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	/**
	 * Crea un DtTourist con todos los datos del objeto y lo devuelve
	 * @return
	 */
	@Override
	public DtUser getDt() {
		return null;
	}
	
	

	

}
