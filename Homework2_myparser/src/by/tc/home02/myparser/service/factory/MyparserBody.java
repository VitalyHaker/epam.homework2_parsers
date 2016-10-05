package by.tc.home02.myparser.service.factory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PushbackReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.tc.home02.myparser.entity.Attribute;
import by.tc.home02.myparser.entity.Document;
import by.tc.home02.myparser.entity.Element;
import by.tc.home02.myparser.entity.Text;
import by.tc.home02.myparser.service.Myparser;

public class MyparserBody implements Myparser {
	private static final String content = "(<((/?)([\\w:\\-]+)((([ \\s]+)([\\w:\\-]+)=(\"[\\.\\w\\-:/ ]+\"))*))>)|"
	+ "([/à-ÿÀ-ß\\., :\\w\\-&&[^<>]]+<)";
	private static final String beginTag = "<";
	private static final String charset = "UTF-8";
	private static final String slash = "/";

	public Document parse(String fileName) {
		PushbackReader pb = null;
		List<Element> arrElements = new ArrayList<>();
		Document document = new Document();

		try {
			Path path = Paths.get(fileName);
			BufferedReader br = Files.newBufferedReader(path, Charset.forName(charset));
			pb = new PushbackReader(br);
			Pattern startEnd = Pattern.compile(content);
			Matcher matcher;
			String s = "";

			while (pb.ready()) {

				char c = (char) pb.read();
				s = s + c;
				matcher = startEnd.matcher(s);

				if (matcher.find()) {
					if (matcher.group(1) != null) {
						startElement(arrElements, matcher);
					}

					s = "";
					if (matcher.group(5) != null) {
						addAttributes(arrElements, matcher);
					}
					if (matcher.group(10) != null) {
						s = beginTag;
						addText(arrElements, matcher);
					}
				}

			}
			createTree(arrElements, document);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return document;
	}

	private static void startElement(List<Element> arrElements, Matcher matcher) {
		Element element = new Element();
		if (matcher.group(1).contains(slash)) {
			element.setTagName(slash + matcher.group(4));
		} else {
			element.setTagName(matcher.group(4));
		}
		arrElements.add(element);
	}

	private static void addAttributes(List<Element> arrElements, Matcher matcher) {
		String name = matcher.group(8); 
		String value = matcher.group(9);
		Attribute attr = new Attribute();
		attr.setName(name);
		attr.setValue(value);
		arrElements.get(arrElements.size() - 1).getAttributes().add(attr);
	}

	private static void addText(List<Element> arrElements, Matcher matcher) {
		Text text = new Text();
		text.setTextContent(matcher.group(10).substring(0, matcher.group(10).indexOf(beginTag)));
		arrElements.get(arrElements.size() - 1).setText(text);

	}

	private static void createTree(List<Element> arrElements, Document document) {
		List<Element> stack2 = new ArrayList<>();
		arrElements.get(0).setTagName(arrElements.get(0).getTagName().substring(1));
		stack2.add(arrElements.get(0));
		document.setTree((stack2.get(0)));
		int i2 = 0;
		for (int i = 0; i < arrElements.size() - 1; i++) {
			if (!(arrElements.get(i + 1).getTagName().equals(slash + stack2.get(i2).getTagName()))) {
				stack2.add(arrElements.get(i + 1));
				stack2.get(i2).getChilds().add(arrElements.get(i + 1));
				i2 = i2 + 1;
			} else {
				stack2.remove(i2);
				i2--;
			}
		}
	}
}
