package by.tc.home02.myparser.parse.entity;

public class Dish {
	private String picture;
	private String title;
	private String specification;
	private String weight;
	private int price;
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName());
		sb.append(":");
		sb.append("picture = < ");
		sb.append(this.getPicture() + " >, ");
		sb.append("title = < ");
		sb.append(this.getTitle() + " >, ");
		sb.append("specification = < ");
		sb.append(this.getSpecification() + " >, ");
		sb.append("weight = < ");
		sb.append(this.getWeight() + " >, ");
		sb.append("price = < ");
		sb.append(this.getPrice() + " >.");
		return sb.toString();
	}
	@Override
	public int hashCode() {
		final int ti = 31;
		int res = 1;
		res = ti * res + ((specification == null) ? 0 : specification.hashCode());
		res = ti * res + ((title == null) ? 0 : title.hashCode());
		res = ti * res + ((picture == null) ? 0 : picture.hashCode());
		res = ti * res + ((weight == null) ? 0 : weight.hashCode());
		res = ti * res + price;
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
		Dish other = (Dish) obj;
		if (specification == null) {
			if (other.specification != null)
				return false;
		} else if (!specification.equals(other.specification))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
