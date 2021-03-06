package org.chompzki.rt.web.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.chompzki.rt.web.builder.WBody;
import org.chompzki.rt.web.builder.WElement;
import org.chompzki.rt.web.builder.WHead;
import org.chompzki.rt.web.builder.WPage;
import org.chompzki.rt.web.builder.block.ContentBlocks;
import org.chompzki.rt.web.builder.block.HeaderBlocks;
import org.chompzki.rt.web.builder.block.MenuBlocks;
import org.chompzki.rt.web.builder.elements.WDiv;
import org.chompzki.rt.web.builder.elements.WHeader;
import org.chompzki.rt.web.builder.elements.WLink;
import org.chompzki.rt.web.builder.elements.WText;


public class LoginPage extends Page {

	@Override
	public void init() {
		
		
	}
	
	@Override
	public void normal(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html");
		WPage page = this.start("Login");
		WHead head = page.getHead();
		WBody body = page.getBody();
		
		body.addElement(HeaderBlocks.getStandardHeader());
		//body.addElement(MenuBlocks.getToolbarMenu());
		
		WElement content = ContentBlocks.addContent(body);
		content.add(ContentBlocks.getLoginForm());
		this.write(resp, page.build());
	}
	
	@Override
	public void success(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html");
		WPage page = this.start("Welcome");
		WHead head = page.getHead();
		WBody body = page.getBody();
		
		body.addElement(HeaderBlocks.getStandardHeader());
		body.addElement(MenuBlocks.getToolbarMenu());
		
		body.addElement(new WDiv())
			.add(new WHeader(1, "SUCCESS"))
			.add(new WText("Some random text..."));
		
		WDiv menu = new WDiv();
		menu.add(new WHeader(2, "Menu"));
		menu.add(new WLink("Security", "/ResearchTimeline/security"));
		menu.add(new WLink("Logout", "/ResearchTimeline/logout"));
		
		body.addElement(menu);
		this.write(resp, page.build());
	}

	@Override
	public void failure(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html");
		WPage page = this.start("Login - Failure");
		WHead head = page.getHead();
		WBody body = page.getBody();
		
		body.addElement(HeaderBlocks.getStandardHeader());
		body.addElement(MenuBlocks.getToolbarMenu());
		
		body.addElement(new WDiv())
			.add(new WHeader(1, "FAILURE"))
			.add(new WText("Some random text..."));
		
		this.write(resp, page.build());
	}


}
