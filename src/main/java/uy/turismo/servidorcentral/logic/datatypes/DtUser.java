package uy.turismo.servidorcentral.logic.datatypes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import uy.turismo.servidorcentral.logic.entities.TouristicActivity;

public abstract class DtUser extends DtBaseEntity {
	
	private String nickname;
	private String email;
	private String lastName;
	private LocalDate birthDate;
	private BufferedImage image;
	private String password;
	private List<DtTouristicActivity> favorites;
	private List<DtUser> followed;
	
	public DtUser() {
		
	}

	
	
	public DtUser(Long id, String nickname, String email, BufferedImage image) {

		super(id);
		this.nickname = nickname;
		this.email = email;
		this.image = image;
	}

	public DtUser(Long id, 
			String name, 
			String nickname, 
			String email, 
			String lastName, 
			LocalDate birthDate,
			BufferedImage image,
			String password,
			List<DtUser> users
			) {
		super(id, name);
		this.nickname = nickname;
		this.email = email;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.image = image;
		this.password = password;
		this.followed = users;
	}
	


	public List<DtTouristicActivity> getFavoritesActivities() {
		return favorites;
	}
	
	public List<DtUser> getFollowed() {
		return followed;
	}
	
	
	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public BufferedImage getImage() {
		return image;
	} 
	public String getPassword() {
		return password;
	}
	
	
	
	
	
}
