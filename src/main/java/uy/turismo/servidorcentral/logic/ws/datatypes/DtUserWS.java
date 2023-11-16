package uy.turismo.servidorcentral.logic.ws.datatypes;

import java.io.IOException;
import java.io.ObjectOutputStream;

import jakarta.xml.bind.annotation.XmlElement;

public abstract class DtUserWS extends DtBaseEntityWS{

	@XmlElement
	protected String nickname;
	@XmlElement
	protected String email;
	@XmlElement
	protected String lastName;
	@XmlElement
	protected String birthDate;
	@XmlElement
	protected byte[] image;
	@XmlElement
	protected String password;
	@XmlElement
	protected DtUserWS[] follows;
	@XmlElement
	protected DtUserWS[] followers;
	
	public DtUserWS() {
		
	}

	public DtUserWS(Long id, String nickname, String email, byte[] image) {

		super(id);
		this.nickname = nickname;
		this.email = email;
		this.image = image;
	}

	public DtUserWS(Long id, 
			String name, 
			String nickname, 
			String email, 
			String lastName, 
			String birthDate,
			byte[] image,
			String password,
			DtUserWS[] follows,
			DtUserWS[] followers) {
		super(id, name);
		this.nickname = nickname;
		this.email = email;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.image = image;
		this.password = password;
		this.follows = follows;
		this.followers = followers;
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

	
	public String getBirthDate() {
		return birthDate;
	}

	
	public byte[] getImage() {
		return image;
	} 
	
	
	public String getPassword() {
		return password;
	}

	
	public DtUserWS[] getFollows() {
		return follows;
	}

	
	public DtUserWS[] getFollowers() {
		return followers;
	}
}
