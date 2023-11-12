package uy.turismo.servidorcentral.logic.datatypes;

import java.util.ArrayList;

import uy.turismo.servidorcentral.logic.ws.datatypes.DtDepartmentWS;

public class DtDepartment extends DtBaseEntity {

	private String description;
	private String webSite; 
	private ArrayList<DtTouristicActivity> activities;

	public DtDepartment(Long id) {
		super(id);
	}
	public DtDepartment(Long id, String name) {
		super(id, name);
	}

	public DtDepartment(DtDepartmentWS d) {
		super(
				d.getId(), 
				d.getName());
		this.description = d.getDescription();
		this.webSite = d.getWebSite();
	}
	
	public DtDepartment(Long id, String name,String description, String webSite, ArrayList<DtTouristicActivity> activities) {
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

	public ArrayList<DtTouristicActivity> getActivities() {
		return activities;
	}

	

}
