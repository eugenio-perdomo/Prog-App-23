package uy.turismo.servidorcentral.logic.datatypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class DtTouristicDeparture extends DtBaseEntity {

	private Integer maxTourist;
	private LocalDate uploadDate;
	private LocalDateTime departureDateTime;
	private String place;
	private DtTouristicActivity touristicActivity;
	private List<DtTourist> tourists;
	
	
	public DtTouristicDeparture() {
		// TODO Auto-generated constructor stub
	}

	public DtTouristicDeparture(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public DtTouristicDeparture(Long id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	public DtTouristicDeparture(
			Long id, 
			String name, 
			Integer maxTourist, 
			LocalDate uploadDate, 
			LocalDateTime departureDateTime, 
			String place,
			DtTouristicActivity touristicActivity, 
			List<DtTourist> tourists) {
		super(id, name);
		this.maxTourist = maxTourist;
		this.uploadDate = uploadDate;
		this.departureDateTime = departureDateTime;
		this.place = place;
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

	public DtTouristicActivity getTouristicActivity() {
		return touristicActivity;
	}

	public List<DtTourist> getTourists() {
		return tourists;
	}
	
	
	
	

}
