package uy.turismo.servidorcentral.logic.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
//import uy.turismo.servidorcentral.logic.datatypes.DtDepartment; to clean later
import uy.turismo.servidorcentral.logic.datatypes.DtUser;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User implements Serializable  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Column(length = 30)
	protected String name;

	@Column(unique = true, length = 30)
	protected String nickname;
		
	@Column(unique = true, length = 50)
	protected String email;

	@Column(length = 50, name = "last_name")
	protected String lastName;

	@Column(name = "birth_date")
	protected LocalDate birthDate;

	@Column(length = 100)
	protected String password;
	
	// Constructor

	public User() {
	}

	public User(Long id, String name, String nickname, String email, String lastName, LocalDate birthDate, String password) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.password = password;
	}

	// Getters and Setter
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//Methods
	
	/**
	 * Crea un DtUser con id, nickname y email del objeto y lo devuelve
	 * @return 
	 */
	public abstract DtUser getShortDt();
	
	
	/**
	 * Operacion abstracta que implementaran Provider y Tourist
	 * @return
	 */
	public abstract DtUser getDt();

}
