package uy.turismo.servidorcentral.logic.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	protected Long id;
	

	//Constructor
	
	public BaseEntity() {
	}
	
	public BaseEntity(Long id) {
		this.id = id;
	}


	//Getters and Setter
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
