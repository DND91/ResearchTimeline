package org.chompzki.rt.web.builder.elements;

import org.chompzki.rt.web.builder.WElement;

public class WSubmit extends WElement {

	@Override
	protected String internalBuild() {
		return "<input type=\"submit\" value=\"Submit\">";
	}

}
