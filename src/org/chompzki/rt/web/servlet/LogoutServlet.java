package org.chompzki.rt.web.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Logout", urlPatterns = {"/logout", "/exit"})
public class LogoutServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5797977480683016388L;
	
	@Override
	public void init() {
		
	}
	
	/** STANDARD CALLS **/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().removeAttribute("TOKEN");
		try {
			resp.sendRedirect("/ResearchTimeline/login");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		doGet(req, resp);
	}
	
}
