package org.chompzki.rt.data.broker;

import java.util.ArrayList;
import java.util.List;

import org.chompzki.rt.data.dto.DTO;

public abstract class Broker {

	public <T extends DTO> List<T> find(T dto) {
		List<T> list = new ArrayList<T>();
		
		return list;
	}

}
