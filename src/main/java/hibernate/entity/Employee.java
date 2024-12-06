package hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;




@NamedQueries(
		{
			@NamedQuery(
				name="getEmployeeByName",
				query="from Emp e where e.name=:name"
				),
	
		
			@NamedQuery(
				name="findEmployeeById",
				query="from Emp e where e.id=:id"
				)
		}
)





@Entity(name="Emp")
public class Employee {

	@Id
	private int id;
	private String name,gender;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}

	
	
}
