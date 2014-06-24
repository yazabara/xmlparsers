package zabara.parsers.impl;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import zabara.domain.Employee;
import zabara.parsers.EmployeeParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Yaroslav_Zabara on 4/29/2014.
 */
public class SaxEmployeeParser extends DefaultHandler implements EmployeeParser {

	private List<Employee> empList = new ArrayList<Employee>();
	private Employee emp = null;
	private String content = null;

	@Override
	public void startElement(String uri, String localName, final String qName, Attributes attributes) throws SAXException {
		switch (qName) {
			case "employee":
				emp = new Employee();
				emp.setId(attributes.getValue("id"));
				break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
			case "employee":
				empList.add(emp);
				break;
			case "firstName":
				emp.setFirstName(content);
				break;
			case "lastName":
				emp.setLastName(content);
				break;
			case "location":
				emp.setLocation(content);
				break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		content = String.copyValueOf(ch, start, length).trim();
	}

	@Override
	public void parse(String fileName) throws Exception{
		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		SAXParser parser = parserFactor.newSAXParser();
		parser.parse("employee.xml", this);
	}

	@Override
	public List<Employee> getEmployee() {
		return empList;
	}
}
