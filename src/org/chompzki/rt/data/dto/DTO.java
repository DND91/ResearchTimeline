package org.chompzki.rt.data.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DTO {
	
	/** Core Attributes **/
	private UUID id = null;
	
	/** Security Attributes **/
	private UUID securityId = null;
	
	private Integer standardAccess = null;
	//User ID -> Integer
	private Map<UUID, Integer> users = new HashMap<UUID, Integer>();
	//Group ID -> Integer
	private Map<UUID, Integer> groups = new HashMap<UUID, Integer>();
	
	/** METHOD **/
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	public Integer getStandardAccess() {
		return standardAccess;
	}
	public void setStandardAccess(Integer standardAccess) {
		this.standardAccess = standardAccess;
	}
	public Integer getUserAccess(UUID id) {
		return users.get(id);
	}
	public void setUserAccess(UUID id, Integer access) {
		this.users.put(id, access);
	}
	public Integer getGroupAccess(UUID id) {
		return groups.get(id);
	}
	public void setGroupAccess(UUID id, Integer access) {
		this.groups.put(id, access);
	}

	public UUID getSecurityId() {
		return securityId;
	}

	public void setSecurityId(UUID securityId) {
		this.securityId = securityId;
	}
	
	
	
}






















