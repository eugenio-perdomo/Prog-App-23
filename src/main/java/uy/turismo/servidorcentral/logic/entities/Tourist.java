package uy.turismo.servidorcentral.logic.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import uy.turismo.servidorcentral.logic.datatypes.DtInscription;
import uy.turismo.servidorcentral.logic.datatypes.DtPurchase;
import uy.turismo.servidorcentral.logic.datatypes.DtTourist;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicBundle;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;
import uy.turismo.servidorcentral.logic.datatypes.DtUser;

@Entity
public class Tourist extends User {
	
	@Column(length = 20)
	private String nationality;
	
	@OneToMany(mappedBy = "tourist", fetch = FetchType.EAGER)
	private List<Inscription> inscriptions;

	//preguntar a los pibe
	@OneToMany(mappedBy = "tourist", fetch = FetchType.EAGER)
	private List<Purchase> purchases;

	
	//Constructors
	public Tourist() {

	}

	public Tourist(
			Long id,
			String nickname,
			String email) {
		super(id,nickname,email);
	}
	
	public Tourist(Long id, String name,
			String nickname, String email, String lastName, 
			LocalDate birthDate, String nationality, String password) {
		super(id, name, nickname, email, lastName, birthDate, password);
		this.nationality = nationality;
		this.initLists();
		// TODO Auto-generated constructor stub
	}
	
	//Iniciadores
	private void initLists() {
		this.inscriptions = new ArrayList<Inscription>();
		this.purchases = new ArrayList<Purchase>();
	}

	//Getters and Setter
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	/**
	 * Crea un DtTourist con todos los datos del objeto y lo devuelve
	 * @return
	 * @throws Exception 
	 */
	@Override
	public DtUser getDt()  {
		List<DtTouristicDeparture> listDepartures = new ArrayList<DtTouristicDeparture>();
		List<DtInscription> listInscriptions = new ArrayList<DtInscription>();
		List<DtTouristicBundle> listBundles = new ArrayList<DtTouristicBundle>();
		List<DtPurchase> listPurchases = new ArrayList<DtPurchase>();
		
		if(this.inscriptions != null) {
			for(Inscription inscription : this.inscriptions) {
				listDepartures.add(inscription.getDepartureShortDt());
				listInscriptions.add(inscription.getDt());
			}
			
		}
		
		
		if(this.purchases != null) {
			for(Purchase purchase : this.purchases) {
				listPurchases.add(purchase.getDtForTourist());
				listBundles.add(purchase.getBundleShortDt());
			}
		}
		
		DtTourist outTouristData = null;
		
		try {
			outTouristData = new DtTourist(
					this.id,
					this.name,
					this.nickname,
					this.email,
					this.lastName,
					this.birthDate,
					this.getImage(),
					this.nationality,
					listDepartures,
					this.password,
					listInscriptions,
					listBundles,
					listPurchases);
		} catch (Exception e) {
			throw e;
		}
		
		return outTouristData;
	}

	@Override
	public DtUser getShortDt() throws Exception {
		
		DtUser dtOutput = null;
		
		dtOutput = new DtTourist(
				this.id, 
				this.nickname,
				this.email,
				this.getImage());
		
	
		return dtOutput;
	}
	
	

	

}
