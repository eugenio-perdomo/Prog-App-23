package uy.turismo.servidorcentral.logic.datatypes;

public class DtBaseEntity {
	
	private Long id; 
	private String name;
	
	
	public DtBaseEntity() {
	}
	
	public DtBaseEntity(Long id) {
		this.id = id;
	}
	
	public DtBaseEntity(Long id, String name) {
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
