package org.chompzki.rt.web.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.chompzki.rt.web.builder.WBody;
import org.chompzki.rt.web.builder.WHead;
import org.chompzki.rt.web.builder.WPage;
import org.chompzki.rt.web.builder.elements.WDiv;
import org.chompzki.rt.web.builder.elements.WForm;
import org.chompzki.rt.web.builder.elements.WHeader;
import org.chompzki.rt.web.builder.elements.WPassword;
import org.chompzki.rt.web.builder.elements.WText;
import org.chompzki.rt.web.builder.elements.WTextfield;


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
		
		body.addElement(new WDiv())
			.add(new WHeader(1, "TEST"))
			.add(new WText("Some random text..."));
		
		WForm form = new WForm("/login", "post");
		form.add(new WTextfield("Username   ", "username", ""));
		form.add(new WPassword("Password    ", "password", ""));
		
		body.addElement(form);
		this.write(resp, page.build());
	}
	
	@Override
	public void success(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void failure() {
		// TODO Auto-generated method stub
		
	}

}
