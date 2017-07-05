package org.chompzki.rt.web.servlet;

import java.util.UUID;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.chompzki.rt.securicty.EnumAccess;
import org.chompzki.rt.securicty.SecurityFacade;
import org.chompzki.rt.web.page.HomePage;
import org.chompzki.rt.web.page.Page;

@WebServlet(name="Home", urlPatterns = {"/home"})
public class HomeServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9041685418068613011L;
	
	protected Page page = new HomePage();
	protected UUID securityID = null;
	
	@Override
	public void init() {
		page.init();
		securityID = SecurityFacade.getInstance().getIDFromType(HomePage.class, EnumAccess.READ);
	}
	
	/** STANDARD CALLS **/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		if(this.verify(req.getSession())){
			page.normal(req, resp);
		} else {
			super.redirectLogin(resp);
		}
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	
}
