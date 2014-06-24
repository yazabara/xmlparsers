package zabara.parsers;

import zabara.parsers.impl.DomEmployeeParser;
import zabara.parsers.impl.SaxEmployeeParser;
import zabara.parsers.impl.StaxEmployeeParser;

/**
 * Created by Yaroslav_Zabara on 4/30/2014.
 */
public class EmployeeParserFactory {

	private static EmployeeParserFactory instance = null;

	public enum EmployeeParserType {
		DOM,
		SAX,
		STAX
	}

	static {
		instance = new EmployeeParserFactory();
	}

	public static synchronized EmployeeParserFactory getInstance() {
		if (instance != null) {
			instance = new EmployeeParserFactory();
		}
		return instance;
	}

	public EmployeeParser getEmployeeParser(String className) throws Exception {
		return (EmployeeParser) Class.forName(className).newInstance();
	}

	public EmployeeParser getEmployeeParser(EmployeeParserType type) throws Exception {
		switch (type) {
			case DOM:
				return new DomEmployeeParser();
			case SAX:
				return new SaxEmployeeParser();
			case STAX:
				return new StaxEmployeeParser();
			default:
				return new SaxEmployeeParser();
		}
	}
}
