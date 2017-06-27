package org.chompzki.rt.web.builder;

import java.util.ArrayList;
import java.util.List;

public abstract class WElement {

	protected List<WElement> elements = new ArrayList<WElement>();
	
	public WElement add(WElement element) {
		elements.add(element);
		return element;
	}
	
	public String build() {
		String string = this.internalBuild() + "\n";
		
		if(0 < elements.size())
			for(WElement elm : elements)
				string += elm.build();
		
		return string;
	}
	
	protected abstract String internalBuild();

}
