package uy.turismo.servidorcentral.logic.entities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.time.LocalDate;
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
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import uy.turismo.servidorcentral.logic.datatypes.DtCategory;
import uy.turismo.servidorcentral.logic.datatypes.DtTouristicActivity;
//import uy.turismo.servidorcentral.logic.datatypes.DtDepartment; to clean later
import uy.turismo.servidorcentral.logic.datatypes.DtUser;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User implements Serializable  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Column(length = 30)
	protected String name;

	@Column(unique = true, length = 30)
	protected String nickname;
		
	@Column(unique = true, length = 50)
	protected String email;

	@Column(length = 50, name = "last_name")
	protected String lastName;

	@Column(name = "birth_date")
	protected LocalDate birthDate;
	
	@Column(length = 34)
	protected String image;

	@Column(length = 100)
	protected String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Follows", joinColumns = @JoinColumn(name = "follower"), inverseJoinColumns = @JoinColumn(name = "followed"))
	protected List<User> follows; //seguidos
	
	
	// Constructor

	public User() {
	}
    
	public User(
			Long id,
			String nickname,
			String email) {
		this.id = id;
		this.nickname = nickname;
		this.email = email;
	}

	public User(
			Long id,
			String name,
			String nickname,
			String email,
			String lastName,
			LocalDate birthDate,
			String password) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.image = null;
		this.password = password;
		this.initLists();
	}
	
	
	//Iniciadores
	private void initLists() {
		
		this.follows = new ArrayList<User>();
	}
	
	
	public Boolean follow(User user) {
		follows.add(user);		
		return follows.contains(user);
	}
	
	public Boolean unFollow(User user) {
		follows.remove(user);		
		return !follows.contains(user);
	}
	
	public List<User> getFollows() {
		return follows;
	}
		
	public void setFollows(List<User> followers) {
		this.follows = followers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	// Getters and Setter
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
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
			String imagesDirPath = properties.getProperty("imagesDirPath").concat("User/");
			File readFile = new File(imagesDirPath + this.image);
			image = ImageIO.read(readFile);
			
		} catch (Exception e) {
			System.out.println("Error al cargar la imagen: " + e.getMessage());
		}
		
		return image;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//Methods
	
	
	
	/**
	 * Guarda una nueva imagen de usuario o modifica la existente
	 * @param image
	 */
	public void setImage(BufferedImage image) {

		String imageName = this.nickname + ".png";
		
		InputStream inputStram = getClass().getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		
		try {
			properties.load(inputStram);
			String imagesDirPath = properties.getProperty("imagesDirPath").concat("User/");
			File saveFile = new File(imagesDirPath + imageName);
			ImageIO.write(image, "png", saveFile);
		} catch (Exception e) {
			System.err.println("Error al guardar la imagen: " + e.getMessage());
			
		}finally {
			this.image = imageName;
		}
		
	}
	
	
	
	//Methods

	/**
	 * Crea un DtUser con id, nickname y email del objeto y lo devuelve
	 * @return 
	 * @throws Exception 
	 */
	public abstract DtUser getShortDt();
	
	
	/**
	 * Operacion abstracta que implementaran Provider y Tourist
	 * @return
	 * @throws Exception 
	 */
	public abstract DtUser getDt();
	
	 @Override
	public boolean equals(Object obj) {
		 
		 if(!(obj instanceof User)) {
			 return false;
		 }
		 
		 if(this.id == ((User) obj).getId()) {
			 return true;
		 }
		 
		 return false;
	 }
}
