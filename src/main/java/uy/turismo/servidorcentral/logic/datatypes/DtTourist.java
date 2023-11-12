package uy.turismo.servidorcentral.logic.datatypes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlElement;
import uy.turismo.servidorcentral.logic.ws.datatypes.DtTouristWS;

public class DtTourist extends DtUser {

	private String nationality;
	private ArrayList<DtTouristicActivity> favActivities;
	private ArrayList<DtTouristicDeparture> departures;
	private ArrayList<DtInscription> inscriptions;
	private ArrayList<DtTouristicBundle> bundles;
	private ArrayList<DtPurchase> purchases;
	
	
	public DtTourist(DtTouristWS t) {
		super(
				t.getId(),
				t.getName(),
				t.getNickname(),
				t.getEmail(),
				t.getLastName(),
				Converter.convertStringToLD(t.getBirthDate()),
				Converter.convertArrayToBI(t.getImage()),
				t.getPassword()
				);
		this.nationality = t.getNationality();
	}
	
	public DtTourist(Long id) {
		super(id);
	}

	public DtTourist(Long id, String nickname, String email, BufferedImage image) {
		super(id, nickname, email, image);
		// TODO Auto-generated constructor stub
	}

	public DtTourist(
			Long id, 
			String name, 
			String nickname,
			String email, 
			String lastName, 
			LocalDate birthDate,
			BufferedImage image, 
			String nationality,
			ArrayList<DtTouristicDeparture> departures, 
			String password,
			ArrayList<DtInscription> inscriptions,
			ArrayList<DtTouristicBundle> bundles,
			ArrayList<DtPurchase> purchases,
			ArrayList<DtUser> follows,
			ArrayList<DtUser> followers,
			ArrayList<DtTouristicActivity> activities) {
		super(id, name, nickname, email, lastName, birthDate, image, password, follows, followers);
		this.nationality = nationality;
		this.departures = departures;
		this.inscriptions = inscriptions;
		this.bundles = bundles;
		this.purchases = purchases;
		this.favActivities = activities;
		// TODO Auto-generated constructor stub
	}

	@XmlElement
	public String getNationality() {
		return nationality;
	}
	
	public ArrayList<DtTouristicActivity> getFavActivties() {
		return favActivities;
	}

	public ArrayList<DtTouristicDeparture> getDepartures() {
		return departures;
	}

	public ArrayList<DtInscription> getInscriptions() {
		return inscriptions;
	}

	public ArrayList<DtPurchase> getPurchases() {
		return purchases;
	}

	public ArrayList<DtTouristicBundle> getBundles() {
		return bundles;
	}
}
