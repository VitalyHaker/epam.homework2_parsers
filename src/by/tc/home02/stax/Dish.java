package by.tc.home02.stax;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private String picture;
	private String title;
	private List<String> specification;
	private String weight;
    private List<Integer> price;
    private List<String> free = new ArrayList<>();

	public Dish(){}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Integer> getPrice() {
		return price;
	}

	public void setPrice(List<Integer> price) {
		this.price = price;
	}

	public List<String> getSpecification() {
		if (specification != null){
			return specification;
		}
		else return free;		
	}

	public void setSpecification(List<String> specification) {
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
