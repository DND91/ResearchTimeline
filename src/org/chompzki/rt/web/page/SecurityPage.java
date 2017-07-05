package org.chompzki.rt.web.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.chompzki.rt.web.builder.WBody;
import org.chompzki.rt.web.builder.WHead;
import org.chompzki.rt.web.builder.WPage;
import org.chompzki.rt.web.builder.block.MenuBlocks;
import org.chompzki.rt.web.builder.elements.WDiv;
import org.chompzki.rt.web.builder.elements.WHeader;
import org.chompzki.rt.web.builder.elements.WLink;
import org.chompzki.rt.web.builder.elements.WText;

public class SecurityPage extends Page {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void normal(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html");
		WPage page = this.start("Welcome");
		WHead head = page.getHead();
		WBody body = page.getBody();
		
		body.addElement(MenuBlocks.getMainMenu());
		
		this.write(resp, page.build());
	}
	
	@Override
	public void success(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void failure(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}



}
