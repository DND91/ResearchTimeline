package org.chompzki.rt.web.servlet;

import java.util.UUID;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.chompzki.rt.securicty.EnumAccess;
import org.chompzki.rt.securicty.SecurityFacade;
import org.chompzki.rt.web.page.Page;
import org.chompzki.rt.web.page.SecurityPage;

@WebServlet(name="Security", urlPatterns = {"/security", "/access"})
public class SecurityServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1251974054188830285L;
	
	protected Page spage = new SecurityPage();
	protected UUID securityID = null;
	
	
	@Override
	public void init() {
		spage.init();
		securityID = SecurityFacade.getInstance().getIDFromType(SecurityPage.class, EnumAccess.NONE);
		
	}
	
	/** STANDARD CALLS **/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		if(!this.handleSecurity(req.getSession(), resp))
			return;
		
		spage.normal(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		if(!this.handleSecurity(req.getSession(), resp))
			return;
		
		
		
	}
	
	
}
