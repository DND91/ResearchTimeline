package org.chompzki.rt.domain;

import java.util.List;

import org.chompzki.rt.data.DataFacade;
import org.chompzki.rt.data.dto.UserDTO;
import org.chompzki.rt.domain.actors.User;
import org.chompzki.rt.domain.timeline.Timeline;

public class DomainFacade {
	
private static DomainFacade instance = null;
	
	public static DomainFacade getInstance() {
		if(instance == null)
			instance = new DomainFacade();
		return instance;
	}
	
	public User getUser(String username) {
		UserDTO dto = new UserDTO();
		dto.setUsername(username);
		List<UserDTO> list = DataFacade.getInstance().find(dto);
		dto = list.get(0);
		
		return new User(dto);
	}

	public List<Timeline> getOwnedTimelines(User user) {
		
		
		
		
		
		
		return null;
	}

	public List<Timeline> getAccessibleTimelines(User user) {
		
		
		
		
		
		return null;
	}
	
	
}



























