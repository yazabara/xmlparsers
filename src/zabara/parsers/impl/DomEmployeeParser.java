package zabara.parsers.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import zabara.domain.Employee;
import zabara.parsers.EmployeeParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav_Zabara on 4/30/2014.
 */
public class DomEmployeeParser implements EmployeeParser {

	private List<Employee> empList = new ArrayList<Employee>();

	@Override
	public void parse(String fileName) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(fileName);
		NodeList nodeList = document.getDocumentElement().getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			if (node instanceof Element) {

				Employee emp = new Employee();
				emp.setId(node.getAttributes().getNamedItem("id").getNodeValue());
				NodeList childNodes = node.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++) {
					Node cNode = childNodes.item(j);
					if (cNode instanceof Element) {
						String content = cNode.getLastChild().getTextContent().trim();
						switch (cNode.getNodeName()) {
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
				}
				empList.add(emp);
			}
		}
	}

	@Override
	public List<Employee> getEmployee() {
		return empList;
	}
}
