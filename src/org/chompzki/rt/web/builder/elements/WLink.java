package org.chompzki.rt.web.builder.elements;

import org.chompzki.rt.web.builder.WElement;

public class WLink extends WElement {
	
	protected String url = null;
	protected String title = null;
	
	public WLink(String title, String url) {
		this.url = url;
		this.title = title;
	}
	
	@Override
	protected String internalBuild() {
		return "<a "+getClasses()+" href=\"" + url + "\">" + title + "</a>";
	}

}
