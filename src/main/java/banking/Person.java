package banking;

public class Person extends AccountHolder{
	private String firstName;
	private String lastName;
	

	public Person(String firstName, String lastName, int idNumber) {
		
		super(idNumber);
		this.firstName=firstName;
		this.lastName=lastName;
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}


	public String getFirstName() {
		
        return this.firstName;
	}

	public String getLastName() {
		// complete the function
        return this.lastName;
	}
}
