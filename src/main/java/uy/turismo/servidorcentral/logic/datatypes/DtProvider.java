package uy.turismo.servidorcentral.logic.datatypes;

import java.time.LocalDate;
import java.util.List;

public class DtProvider extends DtUser {

	private String url;
	private String description;
	private List<DtTouristicActivity> touristicActivities;

	public DtProvider(Long id, String name, String nickname, String email,
			String lastName, LocalDate birthDate, String url, String description,
			List<DtTouristicActivity> touristicActivities) {
		super(id, name, nickname, email, lastName, birthDate);
		this.url = url;
		this.description = description;
		this.touristicActivities = touristicActivities;
		// TODO Auto-generated constructor stub
	}

	public String getUrl() {
		return url;
	}

	public String getDescription() {
		return description;
	}

	public List<DtTouristicActivity> getTouristicActivities() {
		return touristicActivities;
	}
	
	

}
