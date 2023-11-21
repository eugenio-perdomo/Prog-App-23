/**
 * 
 */
package uy.turismo.servidorcentral.logic.entities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import uy.turismo.servidorcentral.logic.datatypes.DtTourist;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;

@Entity(name = "Touristic_Departure")
public class TouristicDeparture implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, unique = true)
	private String name;
	
	@Column(name = "max_tourist")
	private Integer maxTourist;
	
	@Column(name = "upload_date")
	private LocalDate uploadDate;
	
	@Column(name = "departure_date_time")
	private LocalDateTime departureDateTime;

	@Column(length = 150)
	private String place;
	
	@Column(length = 104)
	private String image;
	
	@Column(name = "visits_amount")
	private Integer visitsAmount;
	
	@ManyToOne(targetEntity = TouristicActivity.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "touristic_activity")
	private TouristicActivity touristicActivity;
	
	@OneToMany(mappedBy = "touristicDeparture", fetch = FetchType.EAGER)
	private List<Inscription> inscriptions;

//  Constructors
	
	public TouristicDeparture() {
		
	}
	
	public TouristicDeparture(
			Long id, 
			String name, 
			Integer maxTourist,
			LocalDate uploadDate,
			LocalDateTime departureDateTime, 
			String place,
			TouristicActivity touristicActivity) {
		this.id = id;
		this.name = name;
		this.maxTourist = maxTourist;
		this.uploadDate = uploadDate;
		this.departureDateTime = departureDateTime;
		this.place = place;
		this.image = null;
		this.touristicActivity = touristicActivity;
		this.initLists();
		this.visitsAmount = 0;
	}
	
	//Iniciadores
	private void initLists() {
		this.inscriptions = new ArrayList<Inscription>();
	}

//	Getters and Setter
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public Integer getMaxTourist() {
		return maxTourist;
	}


	public void setMaxTourist(Integer maxTourist) {
		this.maxTourist = maxTourist;
	}


	public LocalDate getUploadDate() {
		return uploadDate;
	}


	public void setUploadDate(LocalDate uploadDate) {
		this.uploadDate = uploadDate;
	}


	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}


	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	public Integer getVisits() {
		return visitsAmount;
	}


	public void setVisits(Integer visits) {
		this.visitsAmount = visits;
	}
	
	
	public BufferedImage getImage() {
		
		BufferedImage image = null;
		
		if(this.image == null) {
			return image;
		}
		
		InputStream inputStram = getClass().getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		
		try {
			properties.load(inputStram);
			String imagesDirPath = properties.getProperty("imagesDirPath").concat("Departure/");
			File readFile = new File(imagesDirPath + this.image);
			image = ImageIO.read(readFile);
			
		} catch (Exception e) {
			System.err.println("Error al cargar la imagen: " + e.getMessage());
		}
		
		return image;	
	}
	
	public void setImage(BufferedImage image) {

		String imageName = this.name + ".png";
		InputStream inputStram = getClass().getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		
		try {
			properties.load(inputStram);
			String imagesDirPath = properties.getProperty("imagesDirPath").concat("Departure/");
			File saveFile = new File(imagesDirPath + imageName);
			ImageIO.write(image, "png", saveFile);
			
		} catch (Exception e) {
			System.err.println("Error al guardar la imagen: " + e.getMessage());
		}finally {
			this.image = imageName;
		}
		
	}
	
	public TouristicActivity getTouristicActivity() {
		return touristicActivity;
	}

	public void setTouristicActivity(TouristicActivity touristicActivity) {
		this.touristicActivity = touristicActivity;
	}

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	/**
	 * Crea un DtTouristicDeparture con el id y el nombre del objeto
	 * @return
	 */
	public DtTouristicDeparture getShortDt() {
		DtTouristicDeparture dtDepartureShort = new DtTouristicDeparture(
				this.id,
				this.name,
				this.getImage());
		return dtDepartureShort;
	}
	
	public DtTouristicDeparture getVisitDt() {
		DtTouristicDeparture dtDepartureVisits = new DtTouristicDeparture(
				this.id,
				this.name,
				this.touristicActivity.getProviderDt(),
				this.visitsAmount);
		return dtDepartureVisits;
	}
	
	/**
	 * Crea un DtTouristicDeparture con todos los datos del objeto
	 * @return
	 */
	public DtTouristicDeparture getDt() {
		List<DtTourist> listTourist = new ArrayList<DtTourist>();
		
		if(this.inscriptions != null) {
			
			for(Inscription ins : this.inscriptions) {
				listTourist.add(ins.getTouristShortDt());
			}
		}
		
		
		DtTouristicDeparture dtDeparture = new DtTouristicDeparture(
				id,
				this.name,
				this.maxTourist,
				this.uploadDate,
				this.departureDateTime,
				this.place,
				this.getImage(),
				this.touristicActivity.getShortDt(),
				this.visitsAmount,
				(ArrayList<DtTourist>) listTourist);
		return dtDeparture;
	}
	
	
}
