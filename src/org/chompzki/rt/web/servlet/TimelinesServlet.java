package org.chompzki.rt.web.servlet;

import java.util.UUID;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.chompzki.rt.securicty.EnumAccess;
import org.chompzki.rt.securicty.SecurityFacade;
import org.chompzki.rt.web.page.HomePage;
import org.chompzki.rt.web.page.Page;
import org.chompzki.rt.web.page.TimelinesPage;

@WebServlet(name="Timelines", urlPatterns = {"/timelines"})
public class TimelinesServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2568818403168159107L;
	
	protected Page page = new TimelinesPage();
	protected UUID securityID = null;
	
	@Override
	public void init() {
		page.init();
		securityID = SecurityFacade.getInstance().getIDFromType(TimelinesPage.class, EnumAccess.READ);
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
