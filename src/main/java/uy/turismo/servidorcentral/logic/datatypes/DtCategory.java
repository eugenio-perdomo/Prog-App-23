package uy.turismo.servidorcentral.logic.datatypes;

import java.util.List;

public class DtCategory extends DtBaseEntity{

	private List<DtTouristicActivity> activities;
	private List<DtTouristicBundle> bundles;
	
	public DtCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DtCategory(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public DtCategory(Long id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}


	public DtCategory(Long id, String name, List<DtTouristicActivity> activities, List<DtTouristicBundle> bundles) {
		super(id,name);
		this.activities = activities;
		this.bundles = bundles;
	}
	
	public List<DtTouristicActivity> getActivities() {
		return activities;
	}
	
	public List<DtTouristicBundle> getBundles(){
		return bundles;
	}
}
