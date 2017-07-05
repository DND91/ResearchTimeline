package org.chompzki.rt.web.builder.elements;

import org.chompzki.rt.web.builder.WElement;

public class WImg extends WElement {
	
	protected String url = null;
	protected String alt = null;
	
	public WImg(String url, String alt) {
		this.url = url;
		this.alt = alt;
	}
	
	@Override
	protected String internalBuild() {
		return "<img " + getClasses() + " src=\"/ResearchTimeline/img/"+url+"\" alt=\""+alt+"\">";
	}

}
