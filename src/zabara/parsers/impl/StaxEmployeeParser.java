package zabara.parsers.impl;

import zabara.domain.Employee;
import zabara.parsers.EmployeeParser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav_Zabara on 4/30/2014.
 */
public class StaxEmployeeParser implements EmployeeParser {

	private List<Employee> empList = new ArrayList<Employee>();

	@Override
	public void parse(String fileName) throws Exception {
		Employee currEmp = null;
		String tagContent = null;
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(fileName));
		while (reader.hasNext()) {
			int event = reader.next();

			switch (event) {
				case XMLStreamConstants.START_ELEMENT:
					if ("employee".equals(reader.getLocalName())) {
						currEmp = new Employee();
						currEmp.setId(reader.getAttributeValue(0));
					}
					if ("employees".equals(reader.getLocalName())) {
						empList = new ArrayList<Employee>();
					}
					break;
				case XMLStreamConstants.CHARACTERS:
					tagContent = reader.getText().trim();
					break;
				case XMLStreamConstants.END_ELEMENT:
					switch (reader.getLocalName()) {
						case "employee":
							empList.add(currEmp);
							break;
						case "firstName":
							currEmp.setFirstName(tagContent);
							break;
						case "lastName":
							currEmp.setLastName(tagContent);
							break;
						case "location":
							currEmp.setLocation(tagContent);
							break;
					}
					break;
				case XMLStreamConstants.START_DOCUMENT:
					empList = new ArrayList<>();
					break;
			}
		}
	}

	@Override
	public List<Employee> getEmployee() {
		return empList;
	}
}
