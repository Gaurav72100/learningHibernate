package hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="CompanyEmp")
public class Employee {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

private String FirstName;
private String LastName;

@OneToOne
Address address;


void Employee(){}
 
 
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFirstName() {
	return FirstName;
}

public void setFirstName(String firstName) {
	FirstName = firstName;
}

public String getLastName() {
	return LastName;
}

public void setLastName(String lastName) {
	LastName = lastName;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

	
	
@Override
public String toString() {
	return "Employee [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", address=" + address + "]";
}

	
	
}
