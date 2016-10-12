package by.tc.home02.myparser.main;

import by.tc.home02.myparser.service.factory.MyparserBody;
import by.tc.home02.myparser.service.factory.MyparserFactory;

public class Main {

	public static void main(String[] args) {
		
		MyparserFactory factory = MyparserFactory.getInstance();
		MyparserBody parser = (MyparserBody) factory.create();
	}
}
