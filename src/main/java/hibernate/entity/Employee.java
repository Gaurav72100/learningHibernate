package hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity (name="Employees")
public class Employee {

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)//if used generator as identity it will automatically creates id no need to manually give id
	private int id;
	private int salary;
	private String name,gender;
	
	public Employee( String name, String gender,int salary) {
		super();
		//this.id = id;
		this.salary = salary;
		this.name = name;
		this.gender = gender;
	}
	
	
	public Employee() {
		super();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", name=" + name + ", gender=" + gender + "]";
	}

	
	
}
