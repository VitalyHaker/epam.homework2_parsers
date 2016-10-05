package by.tc.home02.myparser.parse.service;

import java.util.ArrayList;
import java.util.List;

import by.tc.home02.myparser.entity.Document;
import by.tc.home02.myparser.entity.Element;
import by.tc.home02.myparser.parse.entity.Dish;
import by.tc.home02.myparser.parse.entity.Pearl;
import by.tc.home02.myparser.parse.entity.Constants;


public class MyparserService {
	
	private MyparserService(){}
	
	public static Pearl domParse(Document document){
		Pearl pearl = new Pearl();
		Element root = document.getTree();
		Element coldDishElement = (Element) root.getElementsByName(Constants.nameColdDishes).get(0);
		Element hotDishElement = (Element) root.getElementsByName(Constants.nameHotDishes).get(0);
		Element breakfastElement = (Element) root.getElementsByName(Constants.nameBreakfasts).get(0);
		List<Element> coldDishList = coldDishElement.getElementsByName(Constants.nameDish);
		List<Element> hotDishList = hotDishElement.getElementsByName(Constants.nameDish);
		List<Element> breakfastList = breakfastElement.getElementsByName(Constants.nameDish);
		
		pearl.setColdDishList(listParse(coldDishList));
		pearl.setHotDishList(listParse(hotDishList));
		pearl.setBreakfastList(listParse(breakfastList));
		
		return pearl;
	}
	
	public static List<Dish> listParse(List<Element> currentList){
		List<Dish> list = new ArrayList<>();
		for(int i = 0; i < currentList.size();i++){
			Dish dish = new Dish();
			Element dishElement = (Element) currentList.get(i);
			dish.setTitle(getSingleChild(dishElement,Constants.nameTitle).getText().getTextContent());
			dish.setSpecification(getSingleChild(dishElement,Constants.nameSpecification).getText().getTextContent());
			dish.setWeight(getSingleChild(dishElement,Constants.nameWeight).getText().getTextContent());
			dish.setPrice(Integer.parseInt(getSingleChild(dishElement,Constants.namePrice).getText().getTextContent()));
			dish.setPicture(getSingleChild(dishElement,Constants.namePicture).getText().getTextContent());
			list.add(dish);
		}
		return list;
	}
	
	private static Element getSingleChild(Element element, String childName){
	    List<Element> nlist = element.getElementsByName(childName);
	    Element child = (Element) nlist.get(0);
	    return child;
	}
}