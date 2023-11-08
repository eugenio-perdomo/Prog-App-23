package uy.turismo.servidorcentral.logic.datatypes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

public class DtTourist extends DtUser {

	private String nationality;
	private List<DtTouristicDeparture> departures;
	private List<DtInscription> inscriptions;
	private List<DtTouristicBundle> bundles;
	private List<DtPurchase> purchases;
	private List<DtTouristicActivity> favActivities;
	
	
	public DtTourist() {
		// TODO Auto-generated constructor stub
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
			List<DtTouristicDeparture> departures, 
			String password,
			List<DtInscription> inscriptions,
			List<DtTouristicBundle> bundles,
			List<DtPurchase> purchases) {
		super(id, name, nickname, email, lastName, birthDate, image, password);
		this.nationality = nationality;
		this.departures = departures;
		this.inscriptions = inscriptions;
		this.bundles = bundles;
		this.purchases = purchases;
		// TODO Auto-generated constructor stub
	}

	public String getNationality() {
		return nationality;
	}
	
	public List<DtTouristicActivity> getFavActivties() {
		return favActivities;
	}

	public List<DtTouristicDeparture> getDepartures() {
		return departures;
	}

	public List<DtInscription> getInscriptions() {
		return inscriptions;
	}

	public List<DtPurchase> getPurchases() {
		return purchases;
	}

	public List<DtTouristicBundle> getBundles() {
		return bundles;
	}
}
