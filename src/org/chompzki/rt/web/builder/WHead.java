package org.chompzki.rt.web.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WHead {
	
	protected String title = null;
	protected String charset = null;
	protected String base = null;
	
	protected Map<String, String> meta = new HashMap<String, String>();
	protected List<String> stylesheets = new ArrayList<String>();
	protected List<String> styles = new ArrayList<String>();
	protected List<WScript> scripts = new ArrayList<WScript>();
	
	public WHead(String title) {
		this.title = title;
	}
	
	/**
	 * EXAMPLES:
	 * h1 {color:read;}
	 * p {color:blue; }
	 * 
	 * @param style
	 */
	public void addStyle(String style) { 
		styles.add(style);
	}
	
	/**
	 * EXAMPLES: 
	 *\MY\SHEETS\sheet
	 * sheet
	 * 
	 * NO .CSS NEEDED. Just path and filename
	 * 
	 * @param sheet
	 */
	public void addStylesheet(String sheet) {
		sheet = sheet.replace(".css", "");
		stylesheets.add(sheet);
	}
	
	/**
	 * 
	 * Specify a default URL and a default target for all links on a page.
	 * 
	 * @param base
	 */
	public void setBase(String base) {
		this.base = base;
	}
	
	public void setCharset(String charset) {
		this.charset = charset;
	}
	
	public void putMeta(String name, String content) {
		meta.put(name, content);
	}
	
	public void addScript(WScript script) {
		scripts.add(script);
	}
	
	public String build() {
		String head = "<HEAD>\n";
		head += "<TITLE>" + title + "</TITLE>\n";
		if(charset != null)
			head += "<META charset=\"" + charset + "\">\n";
		
		for(Entry<String, String> entry : meta.entrySet())
			head += "<META name=\"" + entry.getKey() + "\" content=\"" + entry.getValue() + "\">\n";
		
		if(base != null)
			head += "<BASE href=\"" + base + "\" target=\"_blank\">\n";
		if(0 < stylesheets.size())
			for(String sheet : stylesheets)
				head += "<LINK rel=\"stylesheet\" type=\"text/css\" href=\"" + sheet + ".css\">\n";
		
		if(0 < styles.size()) {
			head += "<STYLE>";
			for(String style : styles)
				head += style;
			head+= "</STYLE>\n";
		}
		
		if(0 < scripts.size()){
			head += "<SCRIPT>";
			for(WScript script : scripts)
				head += script.build();
			head += "</SCRIPT>\n";
		}
		
		head += "</HEAD>";
		return head;
	}
	
}
