package org.chompzki.rt.web.page;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.chompzki.rt.data.securicty.SecurityFacade;

public abstract class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9120388797556577337L;
	
	protected boolean verify(HttpSession session) {
		Object obj = session.getAttribute("TOKEN");
		if(obj == null || !(obj instanceof String)){
			return false;
		}
		String token = (String)obj;
		if(!SecurityFacade.getInstance().verifyToken(token)){
			return false;
		}
		return true;
	}
	
	protected boolean handleSecurity(HttpSession session, HttpServletResponse resp) {
		try {
			if(!this.verify(session)){
				resp.sendRedirect("/login");
				return false;
			}
			Object obj = session.getAttribute("TOKEN");
			String token = (String)obj;
			token = SecurityFacade.getInstance().refreshToken(token);
			session.setAttribute("TOKEN", token);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
}
