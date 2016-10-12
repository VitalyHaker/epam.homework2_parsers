package by.tc.home02.myparser.entity;

public class Attribute {
	private String name;
	private String value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName());
		sb.append(":");
		sb.append("name = [ ");
		sb.append(this.getName() + " ], ");
		sb.append("value = [ ");
		sb.append(this.getValue() + " ]. ");
		return sb.toString();
	}
	@Override
	public int hashCode() {
		final int ti = 12;
		int res = 1;
		res = ti * res + ((name == null) ? 0 : name.hashCode());
		res = ti * res + ((value == null) ? 0 : value.hashCode());
		return res;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		Attribute other = (Attribute) obj;
		if (name == null) {
			if (other.name != null){
				return false;
			}
		} else if (!name.equals(other.name)){
			return false;
		}
		if (value == null) {
			if (other.value != null){
				return false;
			}
		} else if (!value.equals(other.value)){
			return false;
		}
		return true;
	}
}

