package uy.turismo.servidorcentral.logic.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import uy.turismo.servidorcentral.logic.datatypes.DtUser;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User extends BaseEntity {
	
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

	// Constructor

	public User() {
	}

	public User(Long id, String name, String nickname, String email, String lastName, LocalDate birthDate) {
		super(id);
		this.nickname = nickname;
		this.email = email;
		this.lastName = lastName;
		this.birthDate = birthDate;
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
	
	//Methods
	
	/**
	 * Crea un DtUser con id, nickname y name del objeto y lo devuelve
	 * @return 
	 */
	public DtUser getShortDt() {
		
		return null;
	}
	
	/**
	 * Operacion abstracta que implementaran Provider y Tourist
	 * @return
	 */
	public abstract DtUser getDt();

}
