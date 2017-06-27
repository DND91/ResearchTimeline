package org.chompzki.rt.web.builder.elements;

import org.chompzki.rt.web.builder.WElement;

public class WDiv extends WElement {
	
	@Override
	public String build() {
		String string = this.internalBuild() + "\n";
		
		if(0 < elements.size())
			for(WElement elm : elements)
				string += elm.build();
		
		string += getEnd();
		return string;
	}
	
	@Override
	protected String internalBuild() {
		return "<div>";
	}
	
	protected String getEnd() {
		return "</div>";
	}

}
