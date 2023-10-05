package uy.turismo.servidorcentral.logic.entities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicBundle;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;

@Entity(name = "Touristic_Bundle")
public class TouristicBundle implements Serializable  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, unique = true)
	private String name;

	@Column(length = 150)
	private String description;
	
	private Integer validityPeriod;
	
	private Double discount;
	
	@Column(name = "upload_date")
	private LocalDate uploadDate;
	
	@Column(length = 104)
	private String image;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "Activities_In_Bundles",
			joinColumns = @JoinColumn(name = "bundle"),
			inverseJoinColumns = @JoinColumn(name = "activity"))
	private List<TouristicActivity> touristicActivities;
	
	@OneToMany(mappedBy = "touristicBundle", fetch =  FetchType.EAGER)
	private List<Purchase> purchases;
	
	//Constructors
	public TouristicBundle() {
		// TODO Auto-generated constructor stub
	}

	public TouristicBundle(Long id, String name, String description, Integer validityPeriod, Double discount, LocalDate uploadDate) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.validityPeriod = validityPeriod;
		this.discount = discount;
		this.uploadDate = uploadDate;
		this.image = null;
	}
	
	
	
	//Iniciadores	
	private void InitLists() {
		this.touristicActivities = new ArrayList<TouristicActivity>();
	}
	

	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Integer validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	

	public LocalDate getUploadDate() {
		return uploadDate;
	}
	
	public void setUploadDate(LocalDate uploadDate) {
		this.uploadDate = uploadDate;
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
			String imagesDirPath = properties.getProperty("imagesDirPath").concat("Bundle/");
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
			String imagesDirPath = properties.getProperty("imagesDirPath").concat("Bundle/");
			File saveFile = new File(imagesDirPath + imageName);
			ImageIO.write(image, "png", saveFile);
			
		} catch (Exception e) {
			System.err.println("Error al guardar la imagen: " + e.getMessage());
		}finally {
			this.image = imageName;
		}
		
	}

	public List<TouristicActivity> getTouristicActivities() {
		return touristicActivities;
	}
	
	/**
	 * Crea un DtTouristicBundle con id y nombre del objeto
	 * @return
	 */
	public DtTouristicBundle getShortDt() {
		DtTouristicBundle shortDt = new  DtTouristicBundle(this.id, this.name);
		return shortDt;
	}
	
	/**
	 * Devuelve un DtTouristicBundle con todos los datos del paquete
	 * @return
	 */
	public DtTouristicBundle getBundleDt() {
		
		//List<DtTouristicActivity> listActivities = new ArrayList<DtTouristicActivity>();
		
		List<DtTouristicActivity> activities = new ArrayList<DtTouristicActivity>();
		
		if(this.touristicActivities != null) {
			for (int i = 0; i < this.touristicActivities.size(); i++) {
				activities.add(touristicActivities.get(i).getShortDt());
			}
			
		}
		
		
		DtTouristicBundle dt = new DtTouristicBundle(this.id, this.name, this.description, this.validityPeriod, 
				this.discount, this.uploadDate, this.getImage(), activities);
		return dt;
	}
	
	/**
	 * Agrega una actividad turistica al paquete
	 * @param activity
	 */
	public void addActivity(TouristicActivity activity) {
		this.touristicActivities.add(activity);
	}

}
