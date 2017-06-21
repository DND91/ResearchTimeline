package org.chompzki.rt.domain.actors;

import java.util.ArrayList;
import java.util.List;

import org.chompzki.rt.domain.contents.Content;
import org.chompzki.rt.domain.contents.Tag;

public abstract class Actor {
	
	protected String name = null;
	//protected Image img = null;
	protected List<Content> content = new ArrayList<Content>();
	protected List<Tag> tags = new ArrayList<Tag>();
	
	
}
