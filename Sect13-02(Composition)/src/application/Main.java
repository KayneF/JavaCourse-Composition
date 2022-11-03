package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {

		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = scan.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = scan.nextLine();
		System.out.print("Level: ");
		String workerLevel = scan.nextLine();
		System.out.print("Base Salary: ");
		double baseSalary = scan.nextDouble();
		Worker worker = new Worker(
				workerName, 
				WorkerLevel.valueOf(workerLevel), 
				baseSalary, 
				new Department(departmentName));
		
		System.out.println("Number of worker's contracts: ");
		int n = scan.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.printf("Enter contract #%d data: %n", i);
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(scan.next());
			System.out.print("Value per hour: ");
			double valuePerHour = scan.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = scan.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.println("Enter the month and year to calculate the income (MM/YYYY): ");
		String monthYear = scan.next();
		int month = Integer.parseInt(monthYear.substring(0, 2));
		int year = Integer.parseInt(monthYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthYear 
				+ ": " + String.format("%.2f", worker.income(year, month)));
		
		
		scan.close();
	}

}
