package by.tc.home02.sax;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SaxEx {
	public static void main(String[] args) throws SAXException, IOException{
	    XMLReader reader = XMLReaderFactory.createXMLReader();//SAX parser
	    MenuSaxHandler handler = new MenuSaxHandler();
	    reader.setContentHandler(handler);
	    reader.parse(new InputSource("src/res/PearlMenu.xml"));
	    
	    List<SubPearl> subPearlList = handler.getDishList();
	    	    
	    for(SubPearl subPearl : subPearlList){
			for (Dish dish : subPearl.getList()) {
				System.out.println(dish.getTitle()+"   "
					+"Описание: "+dish.getSpecification()+"   "
						+"Цена: "+dish.getPrice());
			}
		}
	}
}

