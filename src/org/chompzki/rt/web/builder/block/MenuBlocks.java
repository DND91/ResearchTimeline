package org.chompzki.rt.web.builder.block;

import org.chompzki.rt.web.builder.WElement;
import org.chompzki.rt.web.builder.elements.WDiv;
import org.chompzki.rt.web.builder.elements.WHeader;
import org.chompzki.rt.web.builder.elements.WLink;

public class MenuBlocks {
	
	public static WElement getMainMenu() {
		WDiv menu = new WDiv();
		menu.add(new WHeader(2, "Menu"));
		menu.add(new WLink("Home", "/ResearchTimeline/home"));
		menu.add(new WLink("Security", "/ResearchTimeline/security"));
		menu.add(new WLink("Logout", "/ResearchTimeline/logout"));
		
		return menu;
	}
	
	public static WElement getToolbarMenu() {
		WDiv holder = new WDiv();
		holder.addClass("toolbar_holder");
		WDiv menu = (WDiv) holder.add(new WDiv());
		menu.addClass("toolbar_menu");
		menu.add(new WLink("Home", "/ResearchTimeline/home").addClass("toolbar_item"));
		menu.add(new WLink("Timeline", "/ResearchTimeline/timelines").addClass("toolbar_item"));
		menu.add(new WLink("Actors", "/ResearchTimeline/actors").addClass("toolbar_item"));
		menu.add(new WLink("Security", "/ResearchTimeline/security").addClass("toolbar_item"));
		menu.add(new WLink("Profile", "/ResearchTimeline/profile").addClass("toolbar_item"));
		menu.add(new WLink("Logout", "/ResearchTimeline/logout").addClass("toolbar_item"));
		
		return holder;
	}
	
	public static WElement getLoginMenu() {
		WDiv holder = new WDiv();
		holder.addClass("login_menu_holder");
		WDiv menu = (WDiv) holder.add(new WDiv());
		menu.addClass("login_menu");
		menu.add(new WLink("New User", "/ResearchTimeline/home").addClass("login_item"));
		menu.add(new WLink("Forgott password", "/ResearchTimeline/security").addClass("login_item"));
		
		return holder;
	}
	
}
