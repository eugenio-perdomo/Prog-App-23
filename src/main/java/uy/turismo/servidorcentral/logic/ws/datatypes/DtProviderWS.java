package uy.turismo.servidorcentral.logic.ws.datatypes;

import jakarta.xml.bind.annotation.XmlElement;
import uy.turismo.servidorcentral.logic.datatypes.DtProvider;
import uy.turismo.servidorcentral.logic.datatypes.DtTourist;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;
import uy.turismo.servidorcentral.logic.datatypes.DtUser;

public class DtProviderWS extends DtUserWS {

	private String url;
	private String description;
	private DtTouristicActivityWS[] touristicActivities;

	public DtProviderWS(DtProvider p, Boolean isShort) {
		super(
				p.getId(),
				p.getNickname(),
				p.getEmail(),
				Converter.convertImageToArray(p.getImage()));
			
		if(!isShort) {
			this.name = p.getName();
			this.lastName = p.getLastName();
			this.password = p.getPassword();
			this.url = p.getUrl();
			this.description = p.getDescription();
			
			if(p.getTouristicActivities() != null && !p.getTouristicActivities().isEmpty()) {
				this.touristicActivities = new DtTouristicActivityWS[p.getTouristicActivities().size()];
				int i = 0;
				for(DtTouristicActivity a : p.getTouristicActivities()) {
					this.touristicActivities[i] = new DtTouristicActivityWS(a, true);
					i++;
				}	
			}
			
			if(p.getFollows() != null && !p.getFollows().isEmpty()) {
				this.follows = new DtUserWS[p.getFollows().size()];
				int i = 0;
				for(DtUser user : p.getFollows()) {
					if(user instanceof DtTourist) {
						this.follows[i] = new DtTouristWS((DtTourist) user, true);
					}else {
						this.follows[i] = new DtProviderWS((DtProvider) user, true);
						
					}
					i++;
				}
			}

			if(p.getFollowers() != null && !p.getFollowers().isEmpty()) {
				this.followers = new DtUserWS[p.getFollowers().size()];
				int i = 0;
				for(DtUser user : p.getFollowers()) {
					if(user instanceof DtTourist) {
						this.followers[i] = new DtTouristWS((DtTourist) user, true);
					}else {
						this.followers[i] = new DtProviderWS((DtProvider) user, true);
						
					}
					i++;
				}
				
			}
		}
		
	}
	
	@XmlElement
	public String getUrl() {
		return url;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	@XmlElement
	public DtTouristicActivityWS[] getTouristicActivities() {
		return touristicActivities;
	}

}
