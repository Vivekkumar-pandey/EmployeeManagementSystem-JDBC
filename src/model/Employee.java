package model;

public class Employee {

	private int empId;
	private String empName;
	private String email;
	private double salary;
	private int deptId;

	public Employee(int empId, String empName, String email, double salary, int deptId) {

		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.salary = salary;
		this.deptId = deptId;
	}

	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmail() {
		return email;
	}

	public double getSalary() {
		return salary;
	}

	public int getDeptId() {
		return deptId;
	}
}
