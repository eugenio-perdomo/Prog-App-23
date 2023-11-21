package uy.turismo.servidorcentral.logic.datatypes;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import uy.turismo.servidorcentral.logic.ws.datatypes.DtTouristicDepartureWS;

public class DtTouristicDeparture extends DtBaseEntity {

	private Integer maxTourist;
	private Integer visitsAmount;
	private LocalDate uploadDate;
	private LocalDateTime departureDateTime;
	private String place;
	private BufferedImage image;
	private DtTouristicActivity touristicActivity;
	private ArrayList<DtTourist> tourists;

	public DtTouristicDeparture(DtTouristicDepartureWS d) {
		super(d.getId(), d.getName());
		this.maxTourist = d.getMaxTourist();
		this.uploadDate = Converter.convertStringToLD(d.getUploadDate());
		this.departureDateTime = Converter.convertstringToLDT(d.getDepartureDateTime());
		this.place = d.getPlace();
		this.image = Converter.convertArrayToBI(d.getImage());
		this.touristicActivity = new DtTouristicActivity(d.getTouristicActivity());
	}

	public DtTouristicDeparture(Long id) {
		super(id);
	}
	
	public DtTouristicDeparture(Long id, String name, BufferedImage image) {
		super(id, name);
		this.image = image;
	}
	
	public DtTouristicDeparture(Long id, String name, DtTouristicActivity activity, Integer visits ) {
		super(id, name);
		this.touristicActivity = activity;
		this.visitsAmount = visits;
	}

	public DtTouristicDeparture(
			Long id, 
			String name, 
			Integer maxTourist, 
			LocalDate uploadDate, 
			LocalDateTime departureDateTime, 
			String place,
			BufferedImage image,
			DtTouristicActivity touristicActivity, 
			Integer visits,
			ArrayList<DtTourist> tourists) {
		super(id, name);
		this.maxTourist = maxTourist;
		this.uploadDate = uploadDate;
		this.departureDateTime = departureDateTime;
		this.place = place;
		this.image = image;
		this.touristicActivity = touristicActivity;
		this.tourists = tourists;
		this.visitsAmount = visits;
	}

	public DtTouristicDeparture(Long id, String name, BufferedImage image, LocalDateTime departureDateTime) {
		super(id, name);
		this.image = image;
		this.departureDateTime = departureDateTime;
	}

	//Getters
	public Integer getMaxTourist() {
		return maxTourist;
	}

	public LocalDate getUploadDate() {
		return uploadDate;
	}

	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}

	public String getPlace() {
		return place;
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public DtTouristicActivity getTouristicActivity() {
		return touristicActivity;
	}

	public ArrayList<DtTourist> getTourists() {
		return tourists;
	}
	
	public Integer getVisits() {
		return visitsAmount;
	}
	
	@Override
	 public boolean equals(Object obj) {
		 
		 if(!(obj instanceof DtTouristicDeparture)) {
			 return false;
		 }
		 
		 if(this.id == ((DtTouristicDeparture) obj).getId()) {
			 return true;
		 }
		 
		 return false;
	 }
}
