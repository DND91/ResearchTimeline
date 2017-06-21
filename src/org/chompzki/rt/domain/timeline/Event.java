package org.chompzki.rt.domain.timeline;

import java.util.ArrayList;
import java.util.List;

import org.chompzki.rt.domain.contents.Content;
import org.chompzki.rt.domain.contents.Tag;

public abstract class Event {
	
	protected String title = null;
	//protected Image img = null;
	protected List<Content> content = new ArrayList<Content>();
	protected List<Tag> tags = new ArrayList<Tag>();
	
	protected List<EventRelation> related = new ArrayList<EventRelation>();
	
}
