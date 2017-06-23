package org.chompzki.rt.data;

import java.util.ArrayList;
import java.util.List;

public class DataFacade {
	
	protected static DataFacade instance = null;
	
	public static DataFacade getInstance() {
		if(instance == null)
			instance = new DataFacade();
		return instance;
	}
	
	public <T> List<T> find(T dto) {
		List<T> list = new ArrayList<T>();
		
		return list;
	}
	
	
	
}
