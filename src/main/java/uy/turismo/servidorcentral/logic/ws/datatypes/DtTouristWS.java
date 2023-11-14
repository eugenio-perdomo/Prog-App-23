package uy.turismo.servidorcentral.logic.ws.datatypes;

import java.awt.image.DataBufferByte;
import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlElement;
import uy.turismo.servidorcentral.logic.datatypes.DtInscription;
import uy.turismo.servidorcentral.logic.datatypes.DtProvider;
import uy.turismo.servidorcentral.logic.datatypes.DtPurchase;
import uy.turismo.servidorcentral.logic.datatypes.DtTourist;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicBundle;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;
import uy.turismo.servidorcentral.logic.datatypes.DtUser;

public class DtTouristWS extends DtUserWS {

	private String nationality;
	private DtTouristicActivityWS[] favActivities;
	private DtTouristicDepartureWS[] departures;
	private DtInscriptionWS[] inscriptions;
	private DtTouristicBundleWS[] bundles;
	private DtPurchaseWS[] purchases;
	
	public DtTouristWS(DtTourist t, Boolean isShort) {
		super(
				t.getId(), 
				t.getNickname(), 
				t.getEmail(), 
				Converter.convertImageToArray(t.getImage()));
		
		if(!isShort) {
			this.name = t.getName();
			this.lastName = t.getLastName();
			this.password = t.getPassword();
			this.birthDate = Converter.convertDateToString(t.getBirthDate());
			this.nationality = t.getNationality();
			
			if(t.getDepartures() != null && !t.getDepartures().isEmpty()) {
				this.departures = new DtTouristicDepartureWS[t.getDepartures().size()];
				int i = 0;
				for(DtTouristicDeparture d : t.getDepartures()) {
					this.departures[i] = new DtTouristicDepartureWS(d, true);
					i++;
				}
			}

			if(t.getInscriptions() != null && !t.getInscriptions().isEmpty()) {
				this.inscriptions = new DtInscriptionWS[t.getInscriptions().size()];
				int i = 0;
				for(DtInscription ins : t.getInscriptions()) {
					this.inscriptions[i] = new DtInscriptionWS(ins);
					i++;
				}
			}
			

			if(t.getBundles() != null && !t.getBundles().isEmpty()) {
				this.bundles = new DtTouristicBundleWS[t.getBundles().size()];
				int i = 0;
				for(DtTouristicBundle b : t.getBundles()) {
					this.bundles[i] = new DtTouristicBundleWS(b, true);
					i++;
				}
			}
			

			if(t.getPurchases() != null && !t.getPurchases().isEmpty()) {
				this.purchases = new DtPurchaseWS[t.getPurchases().size()];
				int i = 0;
				for(DtPurchase p : t.getPurchases()) {
					this.purchases[i] = new DtPurchaseWS(p);
					i++;
				}
			}
			
			if(t.getFollows() != null && !t.getFollows().isEmpty()) {
				this.follows = new DtUserWS[t.getFollows().size()];
				int i = 0;
				for(DtUser user : t.getFollows()) {
					if(user instanceof DtTourist) {
						this.follows[i] = new DtTouristWS((DtTourist) user, true);
					}else {
						this.follows[i] = new DtProviderWS((DtProvider) user, true);
						
					}
					i++;
				}
			}

			if(t.getFollowers() != null && !t.getFollowers().isEmpty()) {
				this.followers = new DtUserWS[t.getFollowers().size()];
				int i = 0;
				for(DtUser user : t.getFollowers()) {
					if(user instanceof DtTourist) {
						this.followers[i] = new DtTouristWS((DtTourist) user, true);
					}else {
						this.followers[i] = new DtProviderWS((DtProvider) user, true);
						
					}
					i++;
				}
			}

			if(t.getFavActivties() != null && !t.getFavActivties().isEmpty()) {
				this.favActivities = new DtTouristicActivityWS[t.getFavActivties().size()];
				int i = 0;
				for(DtTouristicActivity a : t.getFavActivties()) {
					this.favActivities[i] = new DtTouristicActivityWS(a, true);
					i++;
				}
			}
			
		}
		
	}

	@XmlElement
	public String getNationality() {
		return nationality;
	}
	@XmlElement
	public DtTouristicDepartureWS[] getDepartures() {
		return departures;
	}
	@XmlElement
	public DtInscriptionWS[] getInscriptions() {
		return inscriptions;
	}
	@XmlElement
	public DtPurchaseWS[] getPurchases() {
		return purchases;
	}
	@XmlElement
	public DtTouristicBundleWS[] getBundles() {
		return bundles;
	}

	@XmlElement
	public DtTouristicActivityWS[] getFavActivities() {
		return favActivities;
	}
	
	
}
