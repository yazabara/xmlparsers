package zabara.parsers;

import zabara.domain.Employee;

import java.util.List;

/**
 * Created by Yaroslav_Zabara on 4/30/2014.
 */
public interface EmployeeParser {

	public void parse(String fileName) throws Exception;

	public List<Employee> getEmployee();
}
