package org.chompzki.rt.securicty;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.chompzki.rt.data.DataFacade;
import org.chompzki.rt.data.dto.UserDTO;
import org.chompzki.rt.securicty.broker.SecurityBroker;
import org.chompzki.rt.securicty.dto.SecurityDTO;

public class SecurityFacade {
	
	public final static Key key = MacProvider.generateKey();
	public final static String ISSUER = "101 HOMER SIMPSON 101";
	
	private static SecurityFacade instance = null;
	
	public static SecurityFacade getInstance() {
		if(instance == null)
			instance = new SecurityFacade();
		return instance;
	}
	
	public SecurityFacade() {
		DataFacade.getInstance().register(SecurityDTO.class, new SecurityBroker());
	}
	
	/**
	 * 
	 * @param name
	 * @param password
	 * @return COMPACT JWS
	 */
	public String authentication(String name, String password) {
		UserDTO dto = new UserDTO();
		dto.setUsername(name);
		dto.setPassword(password);
		List<UserDTO> users = DataFacade.getInstance().find(dto);
		if(users == null || users.size() == 0)
			return null;
		dto = users.get(0);
		
		Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.add(Calendar.HOUR_OF_DAY, 1);
		
		
		return generateJWS(cal.getTime(), dto.getUsername());
	}
	
	protected String generateJWS(Date exparation, String username){
		return Jwts.builder()
				  .setIssuedAt(new Date())
				  .setExpiration(exparation)
				  .setIssuer(ISSUER)
				  .setSubject("Timeline_User")
				  .claim("U", username)
				  .signWith(SignatureAlgorithm.HS512, key)
				  .compact();
	}
	
	protected Jws<Claims> getClaims(String compactJWS) {
		Jws<Claims> claims = Jwts.parser()
		        .requireSubject("Timeline_User")
		        .requireIssuer(ISSUER)
		        .setSigningKey(key)
		        .parseClaimsJws(compactJWS);
		    claims.getBody().getSubject();
	    return claims;
	}
	
	public boolean verifyToken(String compactJWS) {
		try {
			getClaims(compactJWS);
		    return true;
		} catch (Exception e ){
			e.printStackTrace();
		}
		return false;
	}
	
	public String refreshToken(String compactJWS) {
		Jws<Claims> claims = getClaims(compactJWS);
		
		String username = claims.getBody().get("U", String.class);
		Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.add(Calendar.HOUR_OF_DAY, 1);
		
		return generateJWS(cal.getTime(), username);
	}
	
	public void filter(ISecurityMaster master, List<ISecurityObject> objects) {
		
		
		
	}
	
	/**
	 * Group User Membership Object Action
	 * Actions; View,
	 * User can have permissions
	 * Groups can have permissions 
	 * Users can belong to groups
	 * Objects have "standard" permissions for everyone
	 * 
	 * 
	 * 
	 */
	
	public boolean hasAccess(ISecurityMaster master, ISecurityObject object, String action) {
		/*SecurityDTO dto = new SecurityDTO();
		List<AccessDTO> list = DataFacade.getInstance().find(dto);
		if(list.size() != 1)
			return false;
		
		Access access = access(list.get(0));
		*/
		
		return false; //access.authenticate(action);
	}
	
	/** FACTORY PATTERN: NEEDS TO CONVERT ANY ACCESDTO INTO IT'S CORRECT ACCESS**/
	protected Access access(SecurityDTO dto) {
		//TODO: ???
		return null;
	}

	public UUID getIDFromType(Class<?> type, EnumAccess access) {
		SecurityDTO dto = new SecurityDTO();
		dto.setType(type.getName());
		dto.setStandardAccess(access.getID());
		
		List<SecurityDTO> list = DataFacade.getInstance().find(dto);
		if(list.size() == 0) {
			DataFacade.getInstance().save(dto);
			return dto.getSecurityId();
		} else if (1 < list.size()) {
			return null;
		}
		
		return list.get(0).getSecurityId();
	}

	public String extractUsername(String compactJWS) {
		Jws<Claims> claims = getClaims(compactJWS);
		
		return (String) claims.getBody().get("U");
	}
	
}


















