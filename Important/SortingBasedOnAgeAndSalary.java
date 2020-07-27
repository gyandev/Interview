package com.gyan.Important;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingBasedOnAgeAndSalary 
{
	
	public static void main(String[] args) 
	{
		List<Employee> emp=new ArrayList<Employee>();
		emp.add(new Employee(24,"Gyan"));
		emp.add(new Employee(25,"Ram"));
		emp.add(new Employee(30,"Nalini"));
		emp.add(new Employee(27,"Gyan"));
		emp.add(new Employee(32,"Amit"));
		emp.add(new Employee(22,"Dhruv"));

		Collections.sort(emp, new Comparator<Employee>() 
		{

			@Override
			public int compare(Employee o1, Employee o2) {
				int com= o1.getName().compareTo(o2.getName());
				if(com!=0)
				{
					return com;
				}
				return o1.getAge() - o2.getAge();
			}
			
		});
		
		System.out.println(emp);
	}

}

class Employee 
{
	int age;
	String name;
	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + "]";
	}
	@Override
	
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	public Employee(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}



