package org.chompzki.rt.web.servlet;

import java.util.UUID;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.chompzki.rt.securicty.EnumAccess;
import org.chompzki.rt.securicty.SecurityFacade;
import org.chompzki.rt.web.page.LoginPage;
import org.chompzki.rt.web.page.Page;

@WebServlet(name="Login", urlPatterns = {"/login", "/index.html"})
public class LoginServlet extends BaseServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3968688661041792956L;
	
	protected UUID securityID = null;
	
	@Override
	public void init() {
		Page.getLogin().init();
		securityID = SecurityFacade.getInstance().getIDFromType(LoginPage.class, EnumAccess.READ);
	}
	
	/** STANDARD CALLS **/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		if(this.verify(req.getSession())){
			Page.getLogin().success(req, resp);
		} else {
			Page.getLogin().normal(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		String token = null;
		if(username != null && password != null)
			token = SecurityFacade.getInstance().authentication(username, password);
		
		if(token == null) {
			Page.getLogin().failure(req, resp);
			return;
		}
		
		req.getSession().setAttribute("TOKEN", token);
		this.redirect(resp, "home");
	}
	
}







