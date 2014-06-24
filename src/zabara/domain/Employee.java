package zabara.domain;

/**
 * Created by Yaroslav_Zabara on 4/29/2014.
 */
public class Employee {

	private String id;
	private String firstName;
	private String lastName;
	private String location;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Employee employee = (Employee) o;

		if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
		if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
		if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
		if (location != null ? !location.equals(employee.location) : employee.location != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (location != null ? location.hashCode() : 0);
		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id='" + id + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", location='" + location + '\'' +
				'}';
	}
}
