package by.tc.home02.myparser.entity;

public class Document {
	
	private Element tree = new Element();
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName());
		sb.append(":");
		sb.append("tree = [ ");
		sb.append(this.getTree() + " ]. ");
		return sb.toString();
	}

	public Element getTree() {
		return tree;
	}

	public void setTree(Element tree) {
		this.tree = tree;
	}

	@Override
	public int hashCode() {
		final int ti = 12;
		int res = 1;
		res = ti * res + ((tree == null) ? 0 : tree.hashCode());
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
		Document other = (Document) obj;
		if (tree == null) {
			if (other.tree != null)
				return false;
		} else if (!tree.equals(other.tree))
			return false;
		return true;
	}

	
}
