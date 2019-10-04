package com.tavisca.gce.trainings;

import java.util.List;
import java.util.Scanner;

import com.app.FileUtilites.FileWriterHandler;
import com.app.dao.EmployeeDao;
import com.app.entities.Employee;
import com.app.utilities.ObjectToJsonConverter;
import com.app.utilities.ObjectToXMLConverter;

public class EmployeeMain {

	final static private String DIRECTORY_PATH = "C:\\Users\\vlsharma\\eclipse-workspace\\GCE_Trainings\\resources";
	final static private String XML_FILE = "Employee.xml";
	final static private String JSON_FILE = "Employee.txt";
	final static private String CSV_FILE = "Employee.csv";

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> employees = employeeDao.getAllEmployees();

		System.out.println("\n\n ============ MENU ============");
		System.out.println("1. JSON File");
		System.out.println("2. XML File");
		System.out.println("3. CSV File");
		System.out.print("\n Choose the File Type  : ");
		int ch = sc.nextInt();

		switch (ch) {
		case 1:
			writeToJsonFile(employees);
			System.out.println("Json File Written Succesfully.");
			break;

		case 2:
			writeToXMLFile(employees);
			System.out.println("XML File Written Succesfully.");
			break;

		case 3:
			writeToCsvFile(employees);
			System.out.println("CSV File Written Succesfully.");
			break;

		default:
			System.out.println("Invalid Choice. Aborting...");
			break;
		}
		sc.close();
	}

	private static void writeToCsvFile(List<Employee> employees) {

		String csvDataToWrite = "";

		for (Employee employee : employees) {
			csvDataToWrite += employee.toString();
		}

		FileWriterHandler fileWriterHandler = new FileWriterHandler();
		fileWriterHandler.writeDataToFile(csvDataToWrite, DIRECTORY_PATH + "\\" + CSV_FILE);

	}

	static void writeToXMLFile(List<Employee> employees) {

		String xmlDataToWrite = "";

		for (Employee employee : employees) {
			ObjectToXMLConverter objectToXMLConverter = new ObjectToXMLConverter();
			xmlDataToWrite += objectToXMLConverter.toXML(employee);
		}

		FileWriterHandler fileWriterHandler = new FileWriterHandler();
		fileWriterHandler.writeDataToFile(xmlDataToWrite, DIRECTORY_PATH + "\\" + XML_FILE);
	}

	static void writeToJsonFile(List<Employee> employees) {

		String jsonDataToWrite = "";

		for (Employee employee : employees) {
			ObjectToJsonConverter objectToJsonConverter = new ObjectToJsonConverter();
			jsonDataToWrite += objectToJsonConverter.toJson(employee);
		}

		FileWriterHandler fileWriterHandler = new FileWriterHandler();
		fileWriterHandler.writeDataToFile(jsonDataToWrite, DIRECTORY_PATH + "\\" + JSON_FILE);
	}

}
