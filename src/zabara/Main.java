package zabara;

import zabara.domain.Employee;
import zabara.parsers.EmployeeParser;
import zabara.parsers.EmployeeParserFactory;

import java.util.List;

/**
 * Created by Yaroslav_Zabara on 4/30/2014.
 */
public class Main {

	public static void main(String[] args) throws Exception {
		EmployeeParser employeeParser = EmployeeParserFactory.getInstance().getEmployeeParser(EmployeeParserFactory.EmployeeParserType.SAX);
		employeeParser.parse("employee.xml");
		printEmployee(employeeParser.getEmployee());
	}

	public static void printEmployee(List<Employee> empList) {
		for (Employee emp : empList) {
			System.out.println(emp);
		}
	}

}
