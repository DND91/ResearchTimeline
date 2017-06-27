package org.chompzki.rt.web.builder.elements;

import org.chompzki.rt.web.builder.WElement;

public class WHeader extends WElement {
	
	protected int size = 1;
	protected String text = "";
	
	public WHeader(int size, String text) {
		this.size = size;
		this.text = text;
	}
	
	@Override
	public String internalBuild() {
		return "<h" + size + ">" + text + "</h" + size + ">";
	}
	
	
	
}
