package by.tc.home02.myparser.service.factory;

import by.tc.home02.myparser.service.Myparser;

public class MyparserFactory {
	private static final MyparserFactory instance = new MyparserFactory();
	
	private MyparserFactory(){}
	
	public static MyparserFactory getInstance(){
		return instance;
	}
	
	public Myparser create(){
		return new MyparserBody();
	}

}
