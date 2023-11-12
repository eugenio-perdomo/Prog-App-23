package uy.turismo.servidorcentral.logic.ws.datatypes;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public abstract class DtBaseEntityWS {
	
	protected Long id; 
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

	@XmlElement
	public Long getId() {
		return id;
	}

	@XmlElement
	public String getName() {
		return name;
	}
	
}
