package org.chompzki.rt.data.broker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.chompzki.rt.data.dto.DTO;
import org.chompzki.rt.securicty.dto.SecurityDTO;

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
	
	/** HELPER METHODS **/
	
	protected byte[] generateUUID(Connection con) {
		String query = "SELECT UNHEX(REPLACE(UUID(),'-',''));";
		
		PreparedStatement prepStmt = null;
		
		try {
			prepStmt = con.prepareStatement(query);
			ResultSet rset = prepStmt.executeQuery(); 
			
			if (rset.next()) {
				byte[] bytes = rset.getBytes(1);
				if(bytes.length != 16)
					throw new SQLException("Error in generate new UUID size. (SIZE = " + bytes.length + ")");
				
				return bytes;
			} else {
				throw new SQLException("Failed to generate new UUID.");
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (prepStmt != null) {
				try {
					prepStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	
	
}














