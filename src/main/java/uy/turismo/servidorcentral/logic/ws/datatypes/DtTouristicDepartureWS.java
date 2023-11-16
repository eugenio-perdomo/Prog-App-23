package uy.turismo.servidorcentral.logic.ws.datatypes;

import jakarta.xml.bind.annotation.XmlElement;
import uy.turismo.servidorcentral.logic.datatypes.DtTourist;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;

public class DtTouristicDepartureWS extends DtBaseEntityWS {

	@XmlElement
	private Integer maxTourist;
	@XmlElement
	private String uploadDate;
	@XmlElement
	private String departureDateTime;
	@XmlElement
	private String place;
	@XmlElement
	private byte[] image;
	@XmlElement
	private Integer visitsAmount;
	@XmlElement
	private DtTouristicActivityWS touristicActivity;
	@XmlElement
	private DtTouristWS[] tourists;
	
	public DtTouristicDepartureWS() {
		
	}

	public DtTouristicDepartureWS(DtTouristicDeparture d, Boolean isShort) {
		super(
				d.getId(),
				d.getName());
		this.image = Converter.convertImageToArray(d.getImage());
		
		if(!isShort) {
			this.maxTourist = d.getMaxTourist();
			this.uploadDate = Converter.convertDateToString(d.getUploadDate());
			this.departureDateTime = Converter.convertDateTimeToString(d.getDepartureDateTime());
			this.place = d.getPlace();
			this.visitsAmount = d.getVisits();
			this.touristicActivity = new DtTouristicActivityWS(d.getTouristicActivity(), true);
			
			if(d.getTourists() != null && !d.getTourists().isEmpty()) {
				this.tourists = new DtTouristWS[d.getTourists().size()];
				int i = 0;
				for(DtTourist t : d.getTourists()) {
					this.tourists[i] = new DtTouristWS(t, true);
				}
			}
			
		}
	}

	//Getters
	
	public Integer getMaxTourist() {
		return maxTourist;
	}

	
	public String getUploadDate() {
		return uploadDate;
	}

	
	public String getDepartureDateTime() {
		return departureDateTime;
	}

	
	public String getPlace() {
		return place;
	}

	
	public byte[] getImage() {
		return image;
	}

	
	public DtTouristicActivityWS getTouristicActivity() {
		return touristicActivity;
	}

	
	public DtTouristWS[] getTourists() {
		return tourists;
	}
	
	
	public Integer getVisitsAmount() {
		return visitsAmount;
	}

	@Override
	 public boolean equals(Object obj) {
		 
		 if(!(obj instanceof DtTouristicDepartureWS)) {
			 return false;
		 }
		 
		 if(this.id == ((DtTouristicDepartureWS) obj).getId()) {
			 return true;
		 }
		 
		 return false;
	 }
}
