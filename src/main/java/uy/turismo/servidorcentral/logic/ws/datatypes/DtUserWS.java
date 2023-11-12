package uy.turismo.servidorcentral.logic.ws.datatypes;

import jakarta.xml.bind.annotation.XmlElement;

public abstract class DtUserWS extends DtBaseEntityWS{
	
	protected String nickname;
	protected String email;
	protected String lastName;
	protected String birthDate;
	protected byte[] image;
	protected String password;
	protected DtUserWS[] follows;
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

	@XmlElement
	public String getNickname() {
		return nickname;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	@XmlElement
	public String getLastName() {
		return lastName;
	}

	@XmlElement
	public String getBirthDate() {
		return birthDate;
	}

	@XmlElement
	public byte[] getImage() {
		return image;
	} 
	
	@XmlElement
	public String getPassword() {
		return password;
	}

	@XmlElement
	public DtUserWS[] getFollows() {
		return follows;
	}

	@XmlElement
	public DtUserWS[] getFollowers() {
		return followers;
	}
	
	
	
}
