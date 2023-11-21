package uy.turismo.servidorcentral.logic.ws.datatypes;

import jakarta.xml.bind.annotation.XmlElement;
import uy.turismo.servidorcentral.logic.datatypes.DtDepartment;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;

public class DtDepartmentWS extends DtBaseEntityWS {

	@XmlElement
	private String description;
	@XmlElement
	private String webSite; 
	@XmlElement
	private DtTouristicActivityWS[] activities;

	public DtDepartmentWS(){
		
	}

	public DtDepartmentWS(DtDepartment d, Boolean isShort, Boolean alsoActivities) {
		super(d.getId(), d.getName());
		
		if(alsoActivities) {
			if(d.getActivities() != null && !d.getActivities().isEmpty()) {
				this.activities = new DtTouristicActivityWS[d.getActivities().size()];
				int i = 0;
				for(DtTouristicActivity a : d.getActivities()) {
					this.activities[i] = new DtTouristicActivityWS(a, true);
					i++;
				}
			}
		}
		
		if(!isShort) {
			this.description = d.getDescription();
			this.webSite = d.getWebSite();

			if(d.getActivities() != null && !d.getActivities().isEmpty()) {
				this.activities = new DtTouristicActivityWS[d.getActivities().size()];
				int i = 0;
				for(DtTouristicActivity a : d.getActivities()) {
					this.activities[i] = new DtTouristicActivityWS(a, true);
					i++;
				}
			}
		}
	}

	public String getDescription() {
		return description;
	}

	public String getWebSite() {
		return webSite;
	}

	public DtTouristicActivityWS[] getActivities() {
		return activities;
	}
}
