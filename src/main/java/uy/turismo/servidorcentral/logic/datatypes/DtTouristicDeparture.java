package uy.turismo.servidorcentral.logic.datatypes;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import uy.turismo.servidorcentral.logic.entities.Category;


public class DtTouristicDeparture extends DtBaseEntity {

	private Integer maxTourist;
	private LocalDate uploadDate;
	private LocalDateTime departureDateTime;
	private String place;
	private BufferedImage image;
	private DtTouristicActivity touristicActivity;
	private List<DtTourist> tourists;
	
	
	public DtTouristicDeparture() {
		// TODO Auto-generated constructor stub
	}

	public DtTouristicDeparture(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public DtTouristicDeparture(Long id, String name, BufferedImage image) {
		super(id, name);
		this.image = image;
		// TODO Auto-generated constructor stub
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
			List<DtTourist> tourists) {
		super(id, name);
		this.maxTourist = maxTourist;
		this.uploadDate = uploadDate;
		this.departureDateTime = departureDateTime;
		this.place = place;
		this.image = image;
		this.touristicActivity = touristicActivity;
		this.tourists = tourists;
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

	public List<DtTourist> getTourists() {
		return tourists;
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
