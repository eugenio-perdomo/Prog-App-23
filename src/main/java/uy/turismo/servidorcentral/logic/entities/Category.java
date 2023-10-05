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

import jakarta.persistence.ManyToMany;
import uy.turismo.servidorcentral.logic.datatypes.DtCategory;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;


@Entity(name = "Categories")
public class Category implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, unique = true)
	private String name;
	

	@ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
	private List<TouristicActivity> touristicActivities;
	
	
	public Category() {
		
	}

	public Category(Long id, String name, List<TouristicActivity> activities) {
		this.id = id;
		this.name = name;
		this.InitLists();
		this.touristicActivities = activities;
	}
	
	//iniciador
	private void InitLists() {
		this.touristicActivities = new ArrayList<TouristicActivity>();
	}
	
	
	
	//getter y setter
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<TouristicActivity> getTouristicActivites(){
		return touristicActivities;
	}
	
	public void setCategoriesToActivites(List<TouristicActivity> activitiesCats) {
		this.touristicActivities = activitiesCats;
	}
	
	
	
	//shortDt
	public DtCategory getShortDt() {
		DtCategory shortCategoryDt = new  DtCategory(this.id, this.name);
		return shortCategoryDt;
	}
	
	
	
	//dt con actividades
	public DtCategory getCategoryDt() {
		
		List<DtTouristicActivity> activities= new ArrayList<DtTouristicActivity>();
		
		if(this.touristicActivities != null) {
			for (int i = 0; i < this.touristicActivities.size(); i++) {
				activities.add(touristicActivities.get(i).getShortDt());
			}
			
		}
		
		DtCategory dt = new DtCategory(this.id, this.name, activities);
		return dt;
	}
	 
}

