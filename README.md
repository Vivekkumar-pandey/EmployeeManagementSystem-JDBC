# Employee Management System (JDBC)

A console-based Employee Management System built using **Java, JDBC, MySQL, PreparedStatement, and DAO Pattern**, simulating a real-world HR module where employees belong to departments.

## 🚀 Tech Stack
- Java
- JDBC
- MySQL
- DAO Design Pattern
- Scanner (Console I/O)

## 📁 Project Structure

src
├── model
│   ├── Employee.java
│   └── Department.java
├── dao
│   └── EmployeeDAO.java
└── EmployeeManagementSystem.java

## 🗄️ Database Schema

**Database:** `employee_management`

**Table: department**
| Column | Type |
|---|---|
| dept_id | INT (Primary Key) |
| dept_name | VARCHAR(50) |

**Table: employee**
| Column | Type |
|---|---|
| emp_id | INT (Primary Key) |
| emp_name | VARCHAR(50) |
| email | VARCHAR(100) |
| salary | DOUBLE |
| dept_id | INT (Foreign Key → department.dept_id) |

**Relationship:** Department (1) → (Many) Employees

## ✨ Features
1. Add Employee
2. View All Employees
3. Search Employee By ID
4. Update Employee
5. Delete Employee
6. View Employee with Department (INNER JOIN)
7. View Employees By Department
8. Exit

## 🔗 Key Query (INNER JOIN)
```sql
SELECT e.emp_id, e.emp_name, e.salary, d.dept_name
FROM employee e
INNER JOIN department d ON e.dept_id = d.dept_id;
```

## ⚙️ Setup & Run

1. Clone the repository
```bash
   git clone https://github.com/Vivekkumar-pandey/EmployeeManagementSystem-JDBC.git
```
2. Create the database using the provided SQL script (`schema.sql`)
3. Update DB credentials (URL, username, password) in the connection class
4. Compile and run `MainApp.java`

## 📝 Sample Departments
| dept_id | dept_name |
|---|---|
| 1 | HR |
| 2 | IT |
| 3 | Finance |
| 4 | Sales |

## 🎯 Learning Objectives
- JDBC Connectivity
- CRUD Operations
- PreparedStatement
- DAO Pattern
- Foreign Keys & ON DELETE CASCADE
- JOIN Queries
- ResultSet Processing
- Menu-Driven Application Design

## 👤 Author
**Vivek Kumar**
