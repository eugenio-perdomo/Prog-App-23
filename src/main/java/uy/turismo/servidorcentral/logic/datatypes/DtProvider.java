package uy.turismo.servidorcentral.logic.datatypes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import uy.turismo.servidorcentral.logic.ws.datatypes.DtProviderWS;

public class DtProvider extends DtUser {

	private String url;
	private String description;
	private ArrayList<DtTouristicActivity> touristicActivities;

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
			ArrayList<DtTouristicActivity> touristicActivities, 
			String password,
			ArrayList<DtUser> follows,
			ArrayList<DtUser> followers) {
		super(id, name, nickname, email, lastName, birthDate, image, password, follows, followers);

		this.url = url;
		this.description = description;
		this.touristicActivities = touristicActivities;
	}
	

	public DtProvider(Long id) {
		super(id);
	}
	
	public DtProvider(DtProviderWS p) {
		super(
				p.getId(),
				p.getName(),
				p.getNickname(),
				p.getEmail(),
				p.getLastName(),
				Converter.convertStringToLD(p.getBirthDate()),
				Converter.convertArrayToBI(p.getImage()),
				p.getPassword()
				);
		this.description = p.getDescription();
		this.url = p.getUrl();
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

	public ArrayList<DtTouristicActivity> getTouristicActivities() {
		return touristicActivities;
	}

}
