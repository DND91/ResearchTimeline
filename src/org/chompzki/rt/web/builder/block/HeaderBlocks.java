package org.chompzki.rt.web.builder.block;

import org.chompzki.rt.web.builder.WElement;
import org.chompzki.rt.web.builder.elements.WDiv;
import org.chompzki.rt.web.builder.elements.WImg;

public class HeaderBlocks {
	
	public static WElement getStandardHeader() {
		WDiv header = new WDiv();
		header.addClass("banner_header");
		
		header.add((new WDiv()).addClass("banner_header_div")
				.add(new WImg("placeholder-720x180.png", "Placeholder Banner").addClass("banner_header_img")));
		
		return header;
	}
	
}
