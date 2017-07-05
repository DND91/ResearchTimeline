package org.chompzki.rt.web.builder;

import java.util.ArrayList;
import java.util.List;

import org.chompzki.rt.web.builder.elements.WDiv;

public abstract class WElement {

	protected List<WElement> elements = new ArrayList<WElement>();
	protected List<String> clazzes = new ArrayList<String>();
	
	public WElement add(WElement element) {
		elements.add(element);
		return element;
	}
	
	public WElement addClass(String clz) {
		clazzes.add(clz);
		return this;
	}
	
	public String getClasses() {
		if(clazzes.size() == 0)
			return "";
		String clz = "class=\"";
		for(String c : clazzes)
			clz += c + " ";
		return clz + "\"";
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
