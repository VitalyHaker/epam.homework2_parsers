package by.tc.home02.stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StaxEx {
    public static void main(String[] args) throws FileNotFoundException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            InputStream input = new FileInputStream("src/res/PearlMenu.xml");

            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);

            List<SubPearl> menu = process(reader);

            for (SubPearl subPearl : menu) {
                System.out.println(subPearl.getName());
                for (Dish dish : subPearl.getList()) {
                    System.out.println(dish.getTitle()+"   "
        					+ "|   Описание: "+dish.getSpecification()+"   |   Цена: "+dish.getPrice());
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static List<SubPearl> process(XMLStreamReader reader) throws XMLStreamException {
        List<SubPearl> menu = new ArrayList<SubPearl>();
        List<Dish> dishList = new ArrayList<>();
        SubPearl subPearl = null;
        Dish dish = null;
        PearlTagName elementName = null;

        while (reader.hasNext()) {

            int type = reader.next();

            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = PearlTagName.getElementTagName(reader.getLocalName());
                    switch (elementName) {
                        case DISH:
                            dish = new Dish();
                            break;
                        case SUBPEARL:
                        	subPearl = new SubPearl();
                        	subPearl.setName(reader.getAttributeValue(null, "name"));
                            dishList = new ArrayList<>();
                            break;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    switch (elementName) {
                        case PICTURE:
                            dish.setPicture(text);
                            break;
                        case TITLE:
                            dish.setTitle(text);
                            break;
                        case SPECIFICATION:
                            dish.setSpecification(text);
                            break;
                        case WEIGHT:
                            dish.setWeight(text);
                            break;
                        case PRICE:
                        	Integer price = Integer.parseInt(text);
                            dish.setPrice(price);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = PearlTagName.getElementTagName(reader.getLocalName());
                    switch (elementName) {
                        case DISH:
                            dishList.add(dish);
                            dish = null;
                            break;
                        case SUBPEARL:
                            subPearl.setList(dishList);
                            menu.add(subPearl);
                            dishList = null;
                            subPearl = null;
                            break;
                    }
            }
        }
        return menu;
    }
}
