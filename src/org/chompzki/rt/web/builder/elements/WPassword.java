package org.chompzki.rt.web.builder.elements;

import org.chompzki.rt.web.builder.WElement;

public class WPassword extends WElement {
	//<input type="text" name="lastname" value="Mouse"><br><br>
	
	protected String title = null;
	protected String name = null;
	protected String value = null;
	
	public WPassword(String title, String name, String value) {
		this.title = title;
		this.name = name;
		this.value = value;
	}
	
	@Override
	protected String internalBuild() {
		String elm = "<div class=\"field_box\">" + title;
		elm += "<input type=\"password\" name=\""+name+"\" value=\""+value+"\">";
		elm += "</div>";
		return elm;
	}

}
