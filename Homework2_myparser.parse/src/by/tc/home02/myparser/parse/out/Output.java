package by.tc.home02.myparser.parse.out;

import by.tc.home02.myparser.parse.entity.Dish;
import by.tc.home02.myparser.parse.entity.Pearl;

public class Output {
	public static void displayMenu(Pearl pearl){
		System.out.println("Холодные закуски");
		System.out.println();
		for(Dish dish: pearl.getColdDishList()){
			System.out.println(dish.toString());
		}
		System.out.println();
		System.out.println("Горячие закуски");
		System.out.println();
		for(Dish dish: pearl.getHotDishList()){
			System.out.println(dish.toString());
		}
		System.out.println();
		System.out.println("Завтраки");
		System.out.println();
		for(Dish dish: pearl.getBreakfastList()){
			System.out.println(dish.toString());
		}
	}
}
