package org.chompzki.rt.web.page;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.chompzki.rt.securicty.SecurityFacade;
import org.chompzki.rt.web.builder.WBody;
import org.chompzki.rt.web.builder.WElement;
import org.chompzki.rt.web.builder.WHead;
import org.chompzki.rt.web.builder.WPage;
import org.chompzki.rt.web.builder.block.ContentBlocks;
import org.chompzki.rt.web.builder.elements.WDiv;

public abstract class Page {
	
	private static Page login = new LoginPage();
	
	public static Page getLogin() {
		return login;
	}
	
	
	public abstract void init();
	
	public abstract void normal(HttpServletRequest req, HttpServletResponse resp);
	
	public abstract void success(HttpServletRequest req, HttpServletResponse resp);
	
	public abstract void failure(HttpServletRequest req, HttpServletResponse resp);
	
	protected WPage start(String title) {
		WPage page = new WPage();
		WHead head = new WHead(title);
		head.addStylesheet("/ResearchTimeline/styles/defaultLayout");
		head.addStylesheet("/ResearchTimeline/styles/default");
		WBody body = new WBody();
		page.setHead(head);
		page.setBody(body);
		return page;
	}
	
	protected void write(HttpServletResponse resp, String msg){
		try {
			PrintWriter out = resp.getWriter();
			out.println(msg);
		} catch (IOException e) {
			resp.reset();
			try {
				resp.sendError(resp.SC_EXPECTATION_FAILED, "Something failed...");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	protected String getUsername(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String token = (String) session.getAttribute("TOKEN");
		return SecurityFacade.getInstance().extractUsername(token);
	}
	
}
