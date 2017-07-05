package org.chompzki.rt.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.chompzki.rt.data.broker.Broker;
import org.chompzki.rt.data.broker.UserBroker;
import org.chompzki.rt.data.dto.DTO;
import org.chompzki.rt.data.dto.UserDTO;
import org.chompzki.rt.securicty.dto.SecurityDTO;

public class DataFacade {
	
	protected static DataFacade instance = null;
	
	public static DataFacade getInstance() {
		if(instance == null)
			instance = new DataFacade();
		return instance;
	}
	
	public DataFacade() {
		this.register(UserDTO.class, new UserBroker());
		
		
	}
	
	protected Map<Class<? extends DTO>, Broker> brokers = new HashMap<Class<? extends DTO>, Broker>();
	
	public <T extends DTO> List<T> find(T dto) {
		return brokers.get(dto.getClass()).find(dto);
	}
	
	public void register(Class<? extends DTO> clz, Broker broker) {
		brokers.put(clz, broker);
	}
	
	public <T extends DTO> void save(T dto) {
		brokers.get(dto.getClass()).save(dto);
	}
	
	
	
}
