package org.chompzki.rt.web.page;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.chompzki.rt.domain.DomainFacade;
import org.chompzki.rt.domain.actors.User;
import org.chompzki.rt.domain.timeline.Timeline;
import org.chompzki.rt.web.builder.WBody;
import org.chompzki.rt.web.builder.WElement;
import org.chompzki.rt.web.builder.WHead;
import org.chompzki.rt.web.builder.WPage;
import org.chompzki.rt.web.builder.block.ContentBlocks;
import org.chompzki.rt.web.builder.block.DomainBlocks;
import org.chompzki.rt.web.builder.block.HeaderBlocks;
import org.chompzki.rt.web.builder.block.MenuBlocks;
import org.chompzki.rt.web.builder.elements.WDiv;
import org.chompzki.rt.web.builder.elements.WHeader;
import org.chompzki.rt.web.builder.elements.WLink;
import org.chompzki.rt.web.builder.elements.WText;

public class TimelinesPage extends Page {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void normal(HttpServletRequest req, HttpServletResponse resp) {
		String username = this.getUsername(req);
		User user = DomainFacade.getInstance().getUser(username);
		List<Timeline> ownedTL = DomainFacade.getInstance().getOwnedTimelines(user);
		List<Timeline> accessibleTL = DomainFacade.getInstance().getAccessibleTimelines(user);
		
		resp.setContentType("text/html");
		WPage page = this.start("Timelines for " + username);
		WHead head = page.getHead();
		WBody body = page.getBody();
		
		body.addElement(HeaderBlocks.getStandardHeader());
		body.addElement(MenuBlocks.getToolbarMenu());
		
		WElement content = ContentBlocks.addContent(body);
		content.add(new WHeader(2, "Owned"));
		WDiv owned = (WDiv) content.add(new WDiv());
		content.add(new WHeader(2, "Shared"));
		WDiv accessible = (WDiv) content.add(new WDiv());
		
		for(Timeline tl : ownedTL)
			DomainBlocks.addCard(tl, owned);
		
		for(Timeline tl : accessibleTL)
			DomainBlocks.addCard(tl, accessible);
		
		this.write(resp, page.build());
	}
	
	@Override
	public void success(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void failure(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}



}
