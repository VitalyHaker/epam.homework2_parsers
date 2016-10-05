package by.tc.home02.myparser.parse.main;

import by.tc.home02.myparser.entity.Document;
import by.tc.home02.myparser.service.factory.MyparserBody;
import by.tc.home02.myparser.service.factory.MyparserFactory;
import by.tc.home02.myparser.parse.entity.Pearl;
import by.tc.home02.myparser.parse.entity.Constants;
import by.tc.home02.myparser.parse.service.MyparserService;
import by.tc.home02.myparser.parse.out.Output;

public class MyparserMain {

	public static void main(String[] args) {
		
			Pearl pearl = new Pearl();
			MyparserFactory factory = MyparserFactory.getInstance();
			MyparserBody parser = (MyparserBody) factory.create();
			Document document =  (Document) parser.parse(Constants.resource);
			pearl = MyparserService.domParse(document);
			Output.displayMenu(pearl);
	}
	
}
