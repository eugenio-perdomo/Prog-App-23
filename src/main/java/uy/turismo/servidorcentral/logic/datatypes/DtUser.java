package uy.turismo.servidorcentral.logic.datatypes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;

public abstract class DtUser extends DtBaseEntity {
	
	private String nickname;
	private String email;
	private String lastName;
	private LocalDate birthDate;
	private BufferedImage image;
	private String password;
	
	public DtUser() {
		
	}
	
	
	public DtUser(Long id, String nickname, String email) {
		super(id);
		this.nickname = nickname;
		this.email = email;
	}

	public DtUser(Long id, 
			String name, 
			String nickname, 
			String email, 
			String lastName, 
			LocalDate birthDate,
			BufferedImage image,
			String password) {
		super(id, name);
		this.nickname = nickname;
		this.email = email;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.image = image;
		this.password = password;
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
