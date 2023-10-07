package uy.turismo.servidorcentral.logic.entities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import uy.turismo.servidorcentral.logic.datatypes.DtCategory;
import uy.turismo.servidorcentral.logic.datatypes.DtProvider;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicBundle;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicDeparture;
import uy.turismos.servidorcentral.logic.enums.ActivityState;


@Entity(name = "Touristic_Activity")
public class TouristicActivity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, unique = true)
	protected String name;
	
	@Column(length = 150)
	private String description;
	
	private Double duration;
	
	@Column(name = "cost_per_tourist")
	private Double costPerTourist;
	
	@Column(name = "upload_date")
	private LocalDate uploadDate;
	
	@Column(length = 50)
	private String city;
	
	@Column(length = 104)
	private String image;
	
	private ActivityState state;
	
	@ManyToOne
	@JoinColumn(name = "provider")
	private Provider provider;	
	
	@ManyToOne
	@JoinColumn(name = "department")
	private Department department;
	
	@ManyToMany(mappedBy = "touristicActivities", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<TouristicBundle> touristicBundle;
	
	@OneToMany(mappedBy = "touristicActivity", fetch = FetchType.EAGER)
	private List<TouristicDeparture> touristicDepartures;
	
	
	
	
	//codigo agregado:LT
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Activity_Categories", joinColumns = @JoinColumn(name = "activity"), inverseJoinColumns = @JoinColumn(name = "category"))	
	private List<Category> categories;
	
	
	//Constructor
	public TouristicActivity() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	//meter categorias en este bicho
	public TouristicActivity(
			Long id,
			String name,
			String description,
			Double duration,
			Double costPerTourist,
			String city,
			ActivityState state,
			LocalDate uploadDate,
			Provider provider, 
			Department department) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.costPerTourist = costPerTourist;
		this.uploadDate = uploadDate;
		this.city = city;
		this.image = null;
		this.state = state;
		this.provider = provider;
		this.department = department;
		this.InitLists();
	}
	
	//Iniciadores 
	private void InitLists() {
		this.touristicBundle = new ArrayList<TouristicBundle>();
		this.touristicDepartures = new ArrayList<TouristicDeparture>();
		this.categories = new ArrayList<Category>();
	}

	//Getters y Setters
	public Long getId() {
		return id;
	}
	
	public void SetName(Long id) {
		this.id = id;
	}
	
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

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public Double getCostPerTourist() {
		return costPerTourist;
	}
	
	public void setCostPerTourist(Double costPerTourist) {
		this.costPerTourist = costPerTourist;
	}
	
	public LocalDate getUploadDate() {
		return uploadDate;
	}
	
	public void setUploadDate(LocalDate uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
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
			String imagesDirPath = properties.getProperty("imagesDirPath").concat("Activity/");
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
			String imagesDirPath = properties.getProperty("imagesDirPath").concat("Activity/");
			File saveFile = new File(imagesDirPath + imageName);
			ImageIO.write(image, "png", saveFile);
			
		} catch (Exception e) {
			System.err.println("Error al guardar la imagen: " + e.getMessage());
		}finally {
			this.image = imageName;
		}
		
	}
	

	public Provider getProvider() {
		return provider;
	}
	
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public List<TouristicBundle> getTouristicBundle() {
		return touristicBundle;
	}
	
	public void setTouristicBundle(List<TouristicBundle> touristicBundle) {
		this.touristicBundle = touristicBundle;
	}
	
	public List<TouristicDeparture> getTouristicDepartures() {
		return touristicDepartures;
	}
	
	public void setTouristicDepartures(List<TouristicDeparture> touristicDepartures) {
		this.touristicDepartures = touristicDepartures;
	}
	
	public void setActivityState(ActivityState state) {
		this.state = state;
	}
	//codigo agregado : LT.
	public List<Category> getCategories(){
		return categories;
	}
	
	public void setCategory(List<Category> category) {
		this.categories = category;
	}
	
	
	/**
	 * Devuelve un DtTouristicActivity con id y nombre del objeto 
	 * @return
	 */
	public DtTouristicActivity getShortDt() {
		DtTouristicActivity dtOutput = new DtTouristicActivity(
				this.id, 
				this.name);
		return dtOutput;
	}
	
	/**
	 * Devuelve un DtTouristicActivity con todos los datos del objeto 
	 * @return
	 */
	public DtTouristicActivity getDt() {
		List<DtTouristicDeparture> listDtDepartures = new ArrayList<DtTouristicDeparture>();
		List<DtTouristicBundle> listDtBundles = new ArrayList<DtTouristicBundle>();
		List<DtCategory> listDtCategories= new ArrayList<DtCategory>();
		
		
		if(this.touristicDepartures != null) {
			
			for(TouristicDeparture td : this.touristicDepartures) {
				listDtDepartures.add(td.getShortDt());
			}
		}
		
		if(this.touristicBundle != null) {
			for(TouristicBundle tb : this.touristicBundle) {
				listDtBundles.add(tb.getShortDt());
			}
			
		}
		
		//codigo agregado:LT
		if(this.categories != null) {
			for(Category cat: this.categories) {
				listDtCategories.add(cat.getShortDt());
			}
		}
		
		
		DtTouristicActivity dtOutput;
		dtOutput = new DtTouristicActivity(
				this.id,
				this.name,
				this.description,
				this.duration,
				this.costPerTourist,
				this.city,
				this.getImage(),
				this.state,
				this.uploadDate,
				(DtProvider) this.provider.getShortDt(),
				this.department.getShortDt(),
				listDtDepartures,
				listDtBundles,
				listDtCategories);
		
		return dtOutput;	
	}
	
}
