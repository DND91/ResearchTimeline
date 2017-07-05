package org.chompzki.rt.domain.actors;

import org.chompzki.rt.data.dto.UserDTO;

public class User {
	
	protected String username = null;
	protected String password = null;
	protected String email = null;
	protected String phone = null;
	
	public User(UserDTO dto) {
		this.username = dto.getUsername();
		this.password = dto.getPassword();
		this.email = dto.getEmail();
		this.phone = dto.getPhone();
	}
	
}
