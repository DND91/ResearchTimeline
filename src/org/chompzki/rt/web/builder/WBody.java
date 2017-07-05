package org.chompzki.rt.web.builder;

import java.util.ArrayList;
import java.util.List;

public class WBody {
	
	//HEADER
	//MENU
	//CONTENT
	//FOOTER
	
	protected List<WElement> elements = new ArrayList<WElement>();
	protected List<WScript> scripts = new ArrayList<WScript>();
	
	public void addScript(WScript script) {
		scripts.add(script);
	}
	
	public WElement addElement(WElement element) {
		elements.add(element);
		return element;
	}
	
	public String build() {
		String body = "<BODY>\n";
		
		if(0 < elements.size())
			for(WElement element : elements)
				body += element.build();
		
		if(0 < scripts.size()){
			body += "<SCRIPT>";
			for(WScript script : scripts)
				body += script.build();
			body += "</SCRIPT>\n";
		}
		body += "</BODY>";
		return body;
	}

}
