package uy.turismo.servidorcentral.logic.ws.datatypes;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public abstract class DtBaseEntityWS {
	
	@XmlElement
	protected Long id; 
	@XmlElement
	protected String name;
	
	
	public DtBaseEntityWS() {
	}
	
	public DtBaseEntityWS(Long id) {
		this.id = id;
	}
	
	public DtBaseEntityWS(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
