package by.tc.home02.dom;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomEx {

    public static void main(String[] args) throws SAXException, IOException {
        DOMParser parser = new DOMParser();
        parser.parse("src/res/PearlMenu.xml");
        Document document = parser.getDocument();
        Element root = document.getDocumentElement();

        List<SubPearl> subPearlList = new ArrayList<>();
        List<Dish> dishList = null;
        NodeList subPearlNodes = root.getElementsByTagName("subpearl");
        SubPearl subPearl = null;
        for (int i = 0; i < subPearlNodes.getLength(); i++) {
            subPearl = new SubPearl();
            dishList = new ArrayList<>();
            Element subPearlItem = (Element) subPearlNodes.item(i);
            subPearl.setName(subPearlItem.getAttribute("name"));
            NodeList dishNodes = subPearlItem.getElementsByTagName("dish");

            dishIterator(dishList, dishNodes);

            subPearl.setList(dishList);
            subPearlList.add(subPearl);
        }

        printSubPearlList(subPearlList);
    }

    private static void dishIterator(List<Dish> dishList, NodeList dishNodes) {
        Dish dish;
        List<String> specification;
        List<Integer> price;
        for (int j = 0; j < dishNodes.getLength(); j++) {
            dish = new Dish();
            Element dishElement = (Element) dishNodes.item(j);

            dish.setPicture(getSingleChild(dishElement, "picture").getTextContent().trim());

            dish.setTitle(getSingleChild(dishElement, "title").getTextContent().trim());

            specification = new ArrayList<>();
            for (Element specif : getAllChild(dishElement, "specification")) {
            	specification.add(specif.getTextContent().trim());
            }
            dish.setSpecification(specification);

            dish.setWeight(getSingleChild(dishElement, "weight").getTextContent().trim());

            price = new ArrayList<>();
            for (Element pri : getAllChild(dishElement, "price")) {
                price.add(Integer.parseInt(pri.getTextContent().trim()));
            }
            dish.setPrice(price);

            dishList.add(dish);
        }
    }

    private static Element getSingleChild(Element element, String childName) {
        NodeList nlist = element.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;
    }

    private static List<Element> getAllChild(Element element, String childName) {
        NodeList nlist = element.getElementsByTagName(childName);
        List<Element> childList = new ArrayList<>();
        for (int i = 0; i < nlist.getLength(); i++) {
            childList.add((Element) nlist.item(i));
        }
        return childList;
    }

    private static void printSubPearlList(List<SubPearl> subPearlList) {
        for (SubPearl sss : subPearlList) {
            System.out.println(sss.getName());
            for (Dish dish : sss.getList()) {
                System.out.println(dish.getTitle() + " - " + dish.getSpecification() + " - " + dish.getPrice());
            }
        }
    }
}

