package org.chompzki.rt.data.broker;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.chompzki.rt.data.dto.DTO;

public abstract class Broker <T extends DTO> {
	
	public void save(T dto) {
		Connection con = ConnectionPool.getInstance().get();
		try {
			this.insertIntoStorage(con, dto);
		} catch (Exception ex) {
			this.saveInStorage(con, dto);
		}
		ConnectionPool.getInstance().put(con);
	}
	
	public List<T> find(T dto) {
		Connection con = ConnectionPool.getInstance().get();
		List<T> list = new ArrayList<T>();
		this.findInStorage(con, dto, list);
		ConnectionPool.getInstance().put(con);
		return list;
	}
	
	public void delete(T dto) {
		Connection con = ConnectionPool.getInstance().get();
		this.deleteInStorage(con, dto);
		ConnectionPool.getInstance().put(con);
	}
	
	protected abstract void insertIntoStorage(Connection con, T dto);
	protected abstract void saveInStorage(Connection con, T dto);
	protected abstract void findInStorage(Connection con, T dto, List<T> list);
	protected abstract void deleteInStorage(Connection con, T dto);
	
}
