package controller;

import java.util.Scanner;

import dao.EmployeeDao;
import model.Employee;

public class EmployeeManagementSystem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		EmployeeDao dao = new EmployeeDao();

		while (true) {

			System.out.println("\n=================================");
			System.out.println(" EMPLOYEE MANAGEMENT SYSTEM ");
			System.out.println("=================================");
			System.out.println("1. Add Employee");
			System.out.println("2. View All Employees");
			System.out.println("3. Search Employee By ID");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. View Employee With Department");
			System.out.println("7. View Employees By Department");
			System.out.println("8. Exit");

			System.out.print("\nEnter Choice : ");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:

				System.out.println("\n===== ADD EMPLOYEE =====");

				System.out.print("Enter Employee ID : ");
				int empId = sc.nextInt();

				sc.nextLine();

				System.out.print("Enter Employee Name : ");
				String empName = sc.nextLine();

				System.out.print("Enter Email : ");
				String email = sc.nextLine();

				System.out.print("Enter Salary : ");
				double salary = sc.nextDouble();

				System.out.print("Enter Department ID : ");
				int deptId = sc.nextInt();

				Employee emp = new Employee(empId, empName, email, salary, deptId);

				dao.addEmployee(emp);

				break;

			case 2:

				System.out.println("\n===== ALL EMPLOYEES =====");

				dao.viewEmployees();

				break;

			case 3:

				System.out.println("\n===== SEARCH EMPLOYEE =====");

				System.out.print("Enter Employee ID : ");

				int searchId = sc.nextInt();

				dao.searchEmployee(searchId);

				break;

			case 4:

				System.out.println("\n===== UPDATE EMPLOYEE =====");

				System.out.print("Enter Employee ID : ");

				int updateId = sc.nextInt();

				System.out.print("Enter New Salary : ");

				double newSalary = sc.nextDouble();

				System.out.print("Enter New Department ID : ");

				int newDeptId = sc.nextInt();

				dao.updateEmployee(updateId, newSalary, newDeptId);

				break;

			case 5:

				System.out.println("\n===== DELETE EMPLOYEE =====");

				System.out.print("Enter Employee ID : ");

				int deleteId = sc.nextInt();

				dao.deleteEmployee(deleteId);

				break;

			case 6:

				System.out.println("\n===== EMPLOYEE WITH DEPARTMENT =====");

				dao.employeeWithDepartment();

				break;

			case 7:

				System.out.println("\n===== EMPLOYEES BY DEPARTMENT =====");

				System.out.print("Enter Department ID : ");

				int departmentId = sc.nextInt();

				dao.viewEmployeesByDepartment(departmentId);

				break;

			case 8:

				System.out.println("\nThank You...");

				System.out.println("Application Closed Successfully.");
				System.out.println("Thanks For Visit Employee Management System App.");

				sc.close();

				System.exit(0);

				break;

			default:

				System.out.println("\nInvalid Choice!");
			}
		}
	}
}
