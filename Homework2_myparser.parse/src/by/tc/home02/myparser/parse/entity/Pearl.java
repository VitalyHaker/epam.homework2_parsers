package by.tc.home02.myparser.parse.entity;

import java.util.ArrayList;
import java.util.List;

public class Pearl {
	private List<Dish> coldDishes = new ArrayList<Dish>();
	private List<Dish> hotDishes = new ArrayList<Dish>();
	private List<Dish> breakfasts = new ArrayList<Dish>();
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName());
		sb.append(":");
		sb.append("coldDishes = < ");
		sb.append(this.getColdDishList() + " >, ");
		sb.append("hotDishes = < ");
		sb.append(this.getHotDishList() + " >, ");
		sb.append("breakfasts = < ");
		sb.append(this.getBreakfastList() + " >. ");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int ti = 31;
		int res = 1;
		res = ti * res + ((breakfasts == null) ? 0 : breakfasts.hashCode());
		res = ti * res + ((coldDishes == null) ? 0 : coldDishes.hashCode());
		res = ti * res + ((hotDishes == null) ? 0 : hotDishes.hashCode());
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
		Pearl other = (Pearl) obj;
		if (breakfasts == null) {
			if (other.breakfasts != null)
				return false;
		} else if (!breakfasts.equals(other.breakfasts))
			return false;
		if (coldDishes == null) {
			if (other.coldDishes != null)
				return false;
		} else if (!coldDishes.equals(other.coldDishes))
			return false;
		if (hotDishes == null) {
			if (other.hotDishes != null)
				return false;
		} else if (!hotDishes.equals(other.hotDishes))
			return false;
		return true;
	}

	public List<Dish> getColdDishList() {
		return coldDishes;
	}

	public void setColdDishList(List<Dish> coldDishes) {
		this.coldDishes = coldDishes;
	}

	public List<Dish> getHotDishList() {
		return hotDishes;
	}

	public void setHotDishList(List<Dish> hotDishes) {
		this.hotDishes = hotDishes;
	}

	public List<Dish> getBreakfastList() {
		return breakfasts;
	}

	public void setBreakfastList(List<Dish> breakfasts) {
		this.breakfasts = breakfasts;
	}
	
}