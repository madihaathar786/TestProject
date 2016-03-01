package ma.pk.testproject;

public class PersonDTO {
	String firstname;
	String lastname;

	public PersonDTO(String fname, String lname) {
		this.firstname = fname;
		this.lastname = lname;
	}

	public PersonDTO(String name) {
		this.firstname = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
