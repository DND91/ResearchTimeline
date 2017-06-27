package org.chompzki.rt.web.builder;

public class WPage {
	
	protected WHead head = null;
	protected WBody body = null;
	
	public String build() {
		String page = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; 
		page += "<HTML>\n";
		page += head.build() + "\n";
		page += body.build() + "\n";
		page += "</HTML>";
		return page;
	}
	
	public WHead getHead() {
		return head;
	}

	public void setHead(WHead head) {
		this.head = head;
	}

	public WBody getBody() {
		return body;
	}

	public void setBody(WBody body) {
		this.body = body;
	}
	
}
