package by.tc.home02.myparser.entity;

public class Text {
	private String textContent = new String();

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	@Override
	public int hashCode() {
		final int ti = 12;
		int res = 1;
		res = ti * res + ((textContent == null) ? 0 : textContent.hashCode());
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
		Text other = (Text) obj;
		if (textContent == null) {
			if (other.textContent != null)
				return false;
		} else if (!textContent.equals(other.textContent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName());
		sb.append(":");
		sb.append("textContent = [ ");
		sb.append(this.getTextContent() + " ]. ");
		return sb.toString();
	}
	

}