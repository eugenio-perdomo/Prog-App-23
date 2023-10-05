package uy.turismo.servidorcentral.logic.datatypes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

public class DtProvider extends DtUser {

	private String url;
	private String description;
	private List<DtTouristicActivity> touristicActivities;

	public DtProvider(Long id, String name,
			String nickname, String email,
			String lastName, LocalDate birthDate,
			BufferedImage image,
			String url, String description,
			List<DtTouristicActivity> touristicActivities) {
		super(id, name, nickname, email, lastName, birthDate, image);
		this.url = url;
		this.description = description;
		this.touristicActivities = touristicActivities;
	}
	
	public DtProvider(Long id, String nickname, String email) {
		super(id, nickname, email);
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
