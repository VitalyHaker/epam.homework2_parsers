package by.tc.home02.stax;

public class Dish {
    private String picture;
	private String title;
	private String specification;
	private String weight;
    private Integer price;
    private String free = "";

	public Dish(){}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getSpecification() {
		if (specification != null){
			return specification;
		}
		else return free;		
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}
