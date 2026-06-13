package dao;

import java.sql.*;
import model.Employee;

public class EmployeeDao {

	String url = "jdbc:mysql://localhost:3306/employee_management";

	String username = "root";
	String password = "Enter_Your_Password";

//	Insert ******

	public void addEmployee(Employee emp) {

		String query = "insert into employee values(?,?,?,?,?)";

		try {

			Connection con = DriverManager.getConnection(url, username, password);

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, emp.getEmpId());
			ps.setString(2, emp.getEmpName());
			ps.setString(3, emp.getEmail());
			ps.setDouble(4, emp.getSalary());
			ps.setInt(5, emp.getDeptId());

			int row = ps.executeUpdate();

			System.out.println(row + " Employee Added");

			ps.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

//	View All Employees

	public void viewEmployees() {

		String query = "select * from employee";

		try {

			Connection con = DriverManager.getConnection(url, username, password);

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getInt("emp_id") + " " + rs.getString("emp_name") + " " + rs.getString("email")
						+ " " + rs.getDouble("salary") + " " + rs.getInt("dept_id"));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

// Search Employee By ID *****

	public void searchEmployee(int id) {

		String query = "select * from employee where emp_id=?";

		try {

			Connection con = DriverManager.getConnection(url, username, password);

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				System.out.println("ID : " + rs.getInt("emp_id"));

				System.out.println("Name : " + rs.getString("emp_name"));

				System.out.println("Email : " + rs.getString("email"));

				System.out.println("Salary : " + rs.getDouble("salary"));
			} else {

				System.out.println("Employee Not Found");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

// Update Employee *****

	public void updateEmployee(int id, double salary, int deptId) {

		String query = "update employee set salary=?, dept_id=? where emp_id=?";

		try {

			Connection con = DriverManager.getConnection(url, username, password);

			PreparedStatement ps = con.prepareStatement(query);

			ps.setDouble(1, salary);
			ps.setInt(2, deptId);
			ps.setInt(3, id);

			int row = ps.executeUpdate();

			System.out.println(row + " Employee Updated");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

// Delete Employee *****

	public void deleteEmployee(int id) {

		String query = "delete from employee where emp_id=?";

		try {

			Connection con = DriverManager.getConnection(url, username, password);

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);

			int row = ps.executeUpdate();

			System.out.println(row + " Employee Deleted");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

//	View Employee with Department

	public void employeeWithDepartment() {

		String query = """
				SELECT e.emp_id,
				       e.emp_name,
				       e.salary,
				       d.dept_name
				FROM employee e
				INNER JOIN department d
				ON e.dept_id = d.dept_id
				""";

		try {

			Connection con = DriverManager.getConnection(url, username, password);

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getInt("emp_id") + " | " + rs.getString("emp_name") + " | "
						+ rs.getDouble("salary") + " | " + rs.getString("dept_name"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

// View Employees By Department *****

	public void viewEmployeesByDepartment(int deptId) {

		String query = """
				SELECT
				e.emp_id,
				e.emp_name,
				e.email,
				e.salary,
				d.dept_name
				FROM employee e
				INNER JOIN department d
				ON e.dept_id = d.dept_id
				WHERE d.dept_id = ?
				""";

		try {

			Connection con = DriverManager.getConnection(url, username, password);

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, deptId);

			ResultSet rs = ps.executeQuery();

			System.out.println("\n===== EMPLOYEES IN DEPARTMENT =====");

			boolean found = false;

			while (rs.next()) {

				found = true;

				System.out.println(rs.getInt("emp_id") + " | " + rs.getString("emp_name") + " | "
						+ rs.getString("email") + " | " + rs.getDouble("salary") + " | " + rs.getString("dept_name"));
			}

			if (!found) {

				System.out.println("No Employees Found");
			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
