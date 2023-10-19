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

	public DtProvider(
			Long id, 
			String name,
			String nickname, 
			String email,
			String lastName, 
			LocalDate birthDate,
			BufferedImage image,
			String url, 
			String description,
			List<DtTouristicActivity> touristicActivities, 
			String password) {
		super(id, name, nickname, email, lastName, birthDate, image, password);

		this.url = url;
		this.description = description;
		this.touristicActivities = touristicActivities;
	}
	
	public DtProvider(Long id, String nickname, String email, BufferedImage image) {
		super(id, nickname, email, image);
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
