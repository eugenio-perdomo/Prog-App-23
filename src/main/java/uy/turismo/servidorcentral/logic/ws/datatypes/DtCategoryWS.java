package uy.turismo.servidorcentral.logic.ws.datatypes;

import jakarta.xml.bind.annotation.XmlElement;
import uy.turismo.servidorcentral.logic.datatypes.DtCategory;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicBundle;

public class DtCategoryWS extends DtBaseEntityWS{

	private DtTouristicActivityWS[] activities;
	private DtTouristicBundleWS[] bundles;
	
	public DtCategoryWS(DtCategory c, Boolean isShort) {
		super(c.getId(), c.getName());
		if(!isShort) {

			if(c.getActivities() != null && !c.getActivities().isEmpty()) {
				this.activities = new DtTouristicActivityWS[c.getActivities().size()];
				int i = 0;
				for(DtTouristicActivity a : c.getActivities()) {
					this.activities[i] = new DtTouristicActivityWS(a, true);
					i++;
				}
			}

			if(c.getBundles() != null && !c.getBundles().isEmpty()) {
				this.bundles = new DtTouristicBundleWS[c.getBundles().size()];
				int i = 0;
				for(DtTouristicBundle b : c.getBundles()) {
					this.bundles[i] = new DtTouristicBundleWS(b, true);
					i++;
				}
			}
		}
	}

	@XmlElement
	public DtTouristicActivityWS[] getActivities() {
		return activities;
	}

	@XmlElement
	public DtTouristicBundleWS[] getBundles() {
		return bundles;
	}



}
