package org.chompzki.rt.web.builder.elements;

public class WForm extends WDiv {

	protected String action = null;
	protected String method = null;
	
	public WForm(String action, String method) {
		this.action = action;
		this.method = method;
	}
	
	@Override
	protected String internalBuild() {
		return "<form " + getClasses() + " action=\"" + action + "\" method=\"" + method + "\">";
	}
	
	@Override
	protected String getEnd() {
		return "</form>";
	}
	
}
