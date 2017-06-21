package org.chompzki.rt.domain.timeline;

import java.util.ArrayList;
import java.util.List;

import org.chompzki.rt.domain.contents.Content;
import org.chompzki.rt.domain.contents.Tag;

public class Timeline {
	
	protected String title = null;
	//protected Image img = null;
	protected List<Content> content = new ArrayList<Content>();
	protected List<Tag> tags = new ArrayList<Tag>();
	
	protected List<Event> events = new ArrayList<Event>();
	
	
}
