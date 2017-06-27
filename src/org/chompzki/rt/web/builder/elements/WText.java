package org.chompzki.rt.web.builder.elements;

import org.chompzki.rt.web.builder.WElement;

public class WText extends WElement {
	
	protected String text = null;
	
	public WText(String text) {
		this.text = text;
	}
	
	@Override
	protected String internalBuild() {
		return "<p>" + text + "</p>";
	}

}
