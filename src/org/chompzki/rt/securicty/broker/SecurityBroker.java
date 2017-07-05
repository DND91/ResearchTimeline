package org.chompzki.rt.securicty.broker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

import org.chompzki.rt.data.broker.Broker;
import org.chompzki.rt.securicty.dto.SecurityDTO;

public class SecurityBroker extends Broker<SecurityDTO> {

	@Override
	protected void insertIntoStorage(Connection con, SecurityDTO dto) {
		if(dto.getId() != null || dto.getSecurityId() != null)
			throw new IllegalArgumentException("ID must be null"); 
		
		String query = "INSERT INTO `Securitys` (`type`,`access`) VALUES (?, ?);";
		
		PreparedStatement prepStmt = null;
		
		try {
			prepStmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			prepStmt.setString(1, dto.getType());
			prepStmt.setInt(2, dto.getStandardAccess().intValue());
			
			int affectedRows = prepStmt.executeUpdate();
			
			if (affectedRows == 0) {
	            throw new SQLException("Creating user failed, no rows affected.");
	        }
			
			
			
			 try (ResultSet generatedKeys = prepStmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	InputStream stream = generatedKeys.getBinaryStream(1);
	            	byte[] bytes = new byte[16];
	            	stream.read(bytes);
	                dto.setId(toUUID(bytes));
	                dto.setSecurityId(toUUID(bytes));
	            }
	            else {
	                throw new SQLException("Creating security failed, no ID obtained.");
	            }
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
	}
	
	protected UUID toUUID(byte[] bytes) {
	    if (bytes.length != 16) {
	        throw new IllegalArgumentException();
	    }
	    int i = 0;
	    long msl = 0;
	    for (; i < 8; i++) {
	        msl = (msl << 8) | (bytes[i] & 0xFF);
	    }
	    long lsl = 0;
	    for (; i < 16; i++) {
	        lsl = (lsl << 8) | (bytes[i] & 0xFF);
	    }
	    return new UUID(msl, lsl);
	}

	@Override
	protected void saveInStorage(Connection con, SecurityDTO dto) {
		if(dto.getId() == null || dto.getSecurityId() == null)
			throw new IllegalArgumentException("ID cannot be null"); 
		
		String query = "UPDATE `Securitys` SET `type` = ? AND `access` = ? WHERE `securityId` = UNHEX(REPLACE(?,'-','')";
		
		PreparedStatement prepStmt = null;
		
		try {
			prepStmt = con.prepareStatement(query);
			prepStmt.setString(1, dto.getType());
			prepStmt.setInt(2, dto.getStandardAccess().intValue());
			prepStmt.setString(3, dto.getSecurityId().toString());
			
			int affectedRows = prepStmt.executeUpdate();
			
			if (affectedRows == 0) {
	            throw new SQLException("Creating user failed, no rows affected.");
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
	}

	@Override
	protected void findInStorage(Connection con, SecurityDTO dto, List<SecurityDTO> list) {
		String query = "SELECT * FROM `Securitys` WHERE `securityId` LIKE ? AND `type` LIKE ? AND `access` LIKE ?;";
		
		PreparedStatement prepStmt = null;
		
		try {
			prepStmt = con.prepareStatement(query);
			prepStmt.setString(1,"%"+ (dto.getSecurityId() == null ? "" : "UNHEX(REPLACE(" + dto.getSecurityId().toString() + ",'-','')") + "%");
			prepStmt.setString(2,"%"+ (dto.getType() == null ? "" : dto.getType()) + "%");
			prepStmt.setString(3,"%"+ (dto.getStandardAccess() == null ? "" : "" + dto.getStandardAccess().intValue()) + "%");
			
			ResultSet rset = prepStmt.executeQuery(); 
			
			while (rset.next()) {
				SecurityDTO d = new SecurityDTO();
				d.setSecurityId(toUUID(rset.getBytes(1)));
				d.setType(rset.getString(2));
				d.setStandardAccess(rset.getInt(3));
				list.add(d);
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
		
	}

	@Override
	protected void deleteInStorage(Connection con, SecurityDTO dto) {
		// TODO Auto-generated method stub
		
	}
	
	
}






















