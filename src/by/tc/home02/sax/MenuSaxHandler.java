package by.tc.home02.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MenuSaxHandler extends DefaultHandler {
    private List<SubPearl> SubPearlList = new ArrayList<>();
    private SubPearl SubPearl;
    private List<Dish> dishList = new ArrayList<>();
    private Dish dish;
    private List<String> specification = new ArrayList<>();
    private List<Integer> price = new ArrayList<>();
    private StringBuilder text;
    private static int count;

    public List<SubPearl> getDishList() {
        return SubPearlList;
    }

    public void startDocument() throws SAXException {
        System.out.println("Parsing started...");
    }

    public void endDocument() throws SAXException {
        System.out.println("Parsing ended!");
    }

    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text = new StringBuilder();
        if (qName.equals("dish")) {
            dish = new Dish();            
        } else if (qName.equals("specification")) {
            if (attributes.getValue("id") == null || attributes.getValue("id").equals("0")) {
                specification = new ArrayList<>();
            }
        } else if (qName.equals("price")) {
            if (attributes.getValue("id") == null || attributes.getValue("id").equals("1")) {
                price = new ArrayList<>();
            }
        } else if (qName.equals("subpearl")) {
            SubPearl = new SubPearl();
            dishList = new ArrayList<>();
            SubPearl.setName(attributes.getValue("name"));
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        PearlMenuTagName tagName = PearlMenuTagName.valueOf(qName.toUpperCase().replace("-", "_"));

        switch (tagName) {
            case PICTURE:
                dish.setPicture(text.toString());
                break;
            case TITLE:
                dish.setTitle(text.toString());
                break;
            case SPECIFICATION:
                dish.setSpecification(specification);
                specification.add(text.toString());
                break;
            case WEIGHT:
                dish.setWeight(text.toString());
                break;
            case PRICE:
                dish.setPrice(price);
                price.add(Integer.parseInt(text.toString()));
                break;
            case DISH:
                dishList.add(dish);
                dish = null;
                break;
            case SUBPEARL:
                SubPearl.setList(dishList);
                SubPearlList.add(SubPearl);
                dishList = null;
                SubPearl = null;
                break;
        }
    }

}
