package by.tc.home02.myparser.entity;

import java.util.ArrayList;
import java.util.List;

public class Element {
	
	private String tagName;
	private List<Attribute> attributes = new ArrayList<>();
	private List<Element> childs = new ArrayList<>();
	private Text text = new Text();
	
	public List<Element> getElementsByName(String name){
		List<Element> list = new ArrayList<>();
		for(Element elem : childs){
			if(elem.getTagName().equals(name)){
				list.add(elem);
			}
		}
		return list;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public List<Element> getChilds() {
		return childs;
	}

	public void setChilds(List<Element> childs) {
		this.childs = childs;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName());
		sb.append(":");
		sb.append("tagName = [ ");
		sb.append(this.getTagName() + " ], ");
		sb.append("attributes = [ ");
		sb.append(this.getAttributes() + " ], ");
		sb.append("childs = [ ");
		sb.append(this.getChilds() + " ], ");
		sb.append("text = [ ");
		sb.append(this.getText() + " ]. ");
		return sb.toString();
	}


	@Override
	public int hashCode() {
		final int ti = 12;
		int res = 1;
		res = ti * res + ((attributes == null) ? 0 : attributes.hashCode());
		res = ti * res + ((childs == null) ? 0 : childs.hashCode());
		res = ti * res + ((tagName == null) ? 0 : tagName.hashCode());
		res = ti * res + ((text == null) ? 0 : text.hashCode());
		return res;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		if (childs == null) {
			if (other.childs != null)
				return false;
		} else if (!childs.equals(other.childs))
			return false;
		if (tagName == null) {
			if (other.tagName != null)
				return false;
		} else if (!tagName.equals(other.tagName))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	
	
	
	
	
}
