package org.chompzki.rt.data.securicty;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MissingClaimException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.chompzki.rt.data.DataFacade;
import org.chompzki.rt.data.dto.UserDTO;

public class SecurityFacade {
	
	public final static Key key = MacProvider.generateKey();
	public final static String ISSUER = "101 HOMER SIMPSON 101";
	
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
	
	
	
}
