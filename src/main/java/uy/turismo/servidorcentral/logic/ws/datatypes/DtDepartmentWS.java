package uy.turismo.servidorcentral.logic.ws.datatypes;

import jakarta.xml.bind.annotation.XmlElement;
import uy.turismo.servidorcentral.logic.datatypes.DtDepartment;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;

public class DtDepartmentWS extends DtBaseEntityWS {

	private String description;
	private String webSite; 
	private DtTouristicActivityWS[] activities;


	public DtDepartmentWS(DtDepartment d, Boolean isShort) {
		super(d.getId(), d.getName());
		
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

	@XmlElement
	public String getDescription() {
		return description;
	}

	@XmlElement
	public String getWebSite() {
		return webSite;
	}

	@XmlElement
	public DtTouristicActivityWS[] getActivities() {
		return activities;
	}
}
