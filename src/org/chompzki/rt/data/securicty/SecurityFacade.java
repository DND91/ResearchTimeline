package org.chompzki.rt.data.securicty;

import java.util.List;

public class SecurityFacade {
	
	//public User getUser(String name, String password) {
		
	//	return null;
	//}
	
	/**
	 * 
	 * @param name
	 * @param password
	 * @return COMPACT JWS
	 */
	public String authentication(String name, String password) {
		return null;
	}
	
	public boolean verifyToken(String compactJWS) {
		return false;
	}
	
	public String refreshToken(String compactJWS) {
		return null;
	}
	
	public void filter(ISecurityMaster master, List<ISecurityObject> objects) {
		
		
		
	}
	
	
	
}
