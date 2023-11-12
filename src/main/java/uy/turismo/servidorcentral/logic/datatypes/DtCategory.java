package uy.turismo.servidorcentral.logic.datatypes;

import java.util.ArrayList;

import uy.turismo.servidorcentral.logic.ws.datatypes.DtCategoryWS;

public class DtCategory extends DtBaseEntity{

	private ArrayList<DtTouristicActivity> activities;
	private ArrayList<DtTouristicBundle> bundles;

	
	public DtCategory(DtCategoryWS c) {
		super(c.getId(), c.getName());
	}
	
	public DtCategory(Long id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}


	public DtCategory(Long id, String name, ArrayList<DtTouristicActivity> activities, ArrayList<DtTouristicBundle> bundles) {
		super(id,name);
		this.activities = activities;
		this.bundles = bundles;
	}
	
	
	public ArrayList<DtTouristicActivity> getActivities() {
		return activities;
	}
	
	public ArrayList<DtTouristicBundle> getBundles(){
		return bundles;
	}
}
