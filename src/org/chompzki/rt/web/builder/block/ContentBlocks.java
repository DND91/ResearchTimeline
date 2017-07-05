package org.chompzki.rt.web.builder.block;

import org.chompzki.rt.web.builder.WBody;
import org.chompzki.rt.web.builder.WElement;
import org.chompzki.rt.web.builder.elements.WDiv;
import org.chompzki.rt.web.builder.elements.WForm;
import org.chompzki.rt.web.builder.elements.WPassword;
import org.chompzki.rt.web.builder.elements.WSubmit;
import org.chompzki.rt.web.builder.elements.WTextfield;

public class ContentBlocks {
	
	public static WElement content() {
		WDiv content = new WDiv();
		content.addClass("content");
		return content;
	}
	
	public static WElement addContent(WBody body) {
		WDiv content_holder = new WDiv();
		content_holder.addClass("content_holder");
		WElement content = null;
		content_holder.add(content = ContentBlocks.content());
		body.addElement(content_holder);
		return content;
	}
	
	public static WElement getLoginForm() {
		WDiv loginForm = new WDiv();
		loginForm.addClass("login_div");
		WForm form = (WForm) loginForm.add(new WForm("/ResearchTimeline/login", "post"));
		form.addClass("login_form");
		form.add(new WTextfield("Username   ", "username", ""));
		form.add(new WPassword("Password    ", "password", ""));
		form.add(new WSubmit());
		
		WDiv band = (WDiv) loginForm.add(new WDiv());
		band.addClass("login_band_div");
		band.add(MenuBlocks.getLoginMenu());
		
		return loginForm;
	}
}
