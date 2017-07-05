package org.chompzki.rt.securicty.dto;

import java.util.UUID;

import org.chompzki.rt.data.dto.DTO;

public class SecurityDTO extends DTO {
	
	protected String type = null;
	
	@Override
	public UUID getId() {
		return this.getSecurityId();
	}
	
	@Override
	public void setId(UUID id) {
		this.setSecurityId(id);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
