package uy.turismo.servidorcentral.logic.datatypes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

public class DtTourist extends DtUser {

	private String nationality;
	private List<DtTouristicDeparture> departures;
	
	public DtTourist() {
		// TODO Auto-generated constructor stub
	}

	public DtTourist(Long id, String nickname, String email, BufferedImage image) {
		super(id, nickname, email, image);
		// TODO Auto-generated constructor stub
	}

	public DtTourist(Long id, String name, String nickname,
			String email, String lastName, LocalDate birthDate,
			BufferedImage image, String nationality,
			List<DtTouristicDeparture> departures, String password) {
		super(id, name, nickname, email, lastName, birthDate, image, password);
		this.nationality = nationality;
		this.departures = departures;
		// TODO Auto-generated constructor stub
	}

	public String getNationality() {
		return nationality;
	}

	public List<DtTouristicDeparture> getDepartures() {
		return departures;
	}

}
