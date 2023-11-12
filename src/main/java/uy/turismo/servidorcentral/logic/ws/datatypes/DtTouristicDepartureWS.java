package uy.turismo.servidorcentral.logic.ws.datatypes;

import jakarta.xml.bind.annotation.XmlElement;
import uy.turismo.servidorcentral.logic.datatypes.DtTourist;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;

public class DtTouristicDepartureWS extends DtBaseEntityWS {

	private Integer maxTourist;
	private String uploadDate;
	private String departureDateTime;
	private String place;
	private byte[] image;
	private Integer visitsAmount;
	private DtTouristicActivityWS touristicActivity;
	private DtTouristWS[] tourists;
	

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
	@XmlElement
	public Integer getMaxTourist() {
		return maxTourist;
	}

	@XmlElement
	public String getUploadDate() {
		return uploadDate;
	}

	@XmlElement
	public String getDepartureDateTime() {
		return departureDateTime;
	}

	@XmlElement
	public String getPlace() {
		return place;
	}

	@XmlElement
	public byte[] getImage() {
		return image;
	}

	@XmlElement
	public DtTouristicActivityWS getTouristicActivity() {
		return touristicActivity;
	}

	@XmlElement
	public DtTouristWS[] getTourists() {
		return tourists;
	}
	
	@XmlElement
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
