package uy.turismo.servidorcentral.logic.datatypes;

import java.util.List;

public class DtDepartment extends DtBaseEntity {

	private String description;
	private String webSite; 
	private List<DtTouristicActivity> activities;

	public DtDepartment() {
		// TODO Auto-generated constructor stub
	}
	public DtDepartment(Long id) {
		super(id);
	}

	public DtDepartment(Long id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}
	
	public DtDepartment(Long id, String name,String description, String webSite, List<DtTouristicActivity> activities) {
		super(id, name);
		this.description = description;
		this.webSite = webSite;
		this.activities = activities;
	}

	public String getDescription() {
		return description;
	}

	public String getWebSite() {
		return webSite;
	}

	public List<DtTouristicActivity> getActivities() {
		return activities;
	}

	

}
