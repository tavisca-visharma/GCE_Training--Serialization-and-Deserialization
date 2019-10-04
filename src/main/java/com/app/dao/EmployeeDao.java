package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.entities.Employee;

public class EmployeeDao {

	final private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final private String DB_URL = "jdbc:mysql://127.0.0.1/vishaldb";
	final private String USERNAME = "root";
	final private String PASSWORD = "";

	private Connection connection = null;
	private Statement statement = null;
	private List<Employee> employees = null;

	public List<Employee> getAllEmployees() {

		employees = new ArrayList<Employee>();

		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			statement = connection.createStatement();
			String sqlQuery = "select * from employee";
			ResultSet resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {
				Employee employee = new Employee(resultSet.getInt("Emp_ID"));
				employee.setFirstName(resultSet.getString("First Name"));
				employee.setLastName(resultSet.getString("Last Name"));
				employee.setSalary(resultSet.getInt("Salary"));

				employees.add(employee);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return employees;
	}

}
