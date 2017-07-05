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
import org.chompzki.rt.web.builder.elements.WForm;
import org.chompzki.rt.web.builder.elements.WHeader;
import org.chompzki.rt.web.builder.elements.WLink;
import org.chompzki.rt.web.builder.elements.WPassword;
import org.chompzki.rt.web.builder.elements.WSubmit;
import org.chompzki.rt.web.builder.elements.WText;
import org.chompzki.rt.web.builder.elements.WTextfield;

public class HomePage extends Page {

	@Override
	public void init() { }

	@Override
	public void normal(HttpServletRequest req, HttpServletResponse resp) {
		String username = this.getUsername(req);
		
		resp.setContentType("text/html");
		WPage page = this.start("Home for " + username);
		WHead head = page.getHead();
		WBody body = page.getBody();
		
		body.addElement(HeaderBlocks.getStandardHeader());
		body.addElement(MenuBlocks.getToolbarMenu());
		
		WElement content = ContentBlocks.addContent(body);
		//content.add(ContentBlocks.getLoginForm());
		this.write(resp, page.build());
		
		
		this.write(resp, page.build());
	}

	@Override
	public void success(HttpServletRequest req, HttpServletResponse resp) {	}

	@Override
	public void failure(HttpServletRequest req, HttpServletResponse resp) {	}

}
