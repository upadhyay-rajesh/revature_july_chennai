package com.demoboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "findallcustomer", 
      query = "from com.demoboot.entity.Customer c where c.email=:myemail and c.password=:pwd")
   /* @NamedQuery(name = "DeptEmployee_FindAllByDesgination", 
      query = "from DeptEmployee where designation = :designation"),
    @NamedQuery(name = "DeptEmployee_UpdateEmployeeDepartment", 
      query = "Update DeptEmployee set department = :newDepartment where employeeNumber = :employeeNo"),
*/
})

public class Customer {
	private String name;
	private String password;
	@Id
	private String email;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
