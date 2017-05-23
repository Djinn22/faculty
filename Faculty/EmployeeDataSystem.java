import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import employee.AcademicEmployee;
import employee.Employee;



/*
 * class EmployeeDataSystem
 * 
 * This class represents the portion of the Employee Data System 
 * program that has been completed by the previous programmer.
 * 
 * You are expected to complete the implementation of this class
 * progressively as you work through the various stages in the
 * assignment specification.
 * 
 * Note that it is ok to add additional helper methods to handle
 * common tasks (eg. searching for an object) at your discretion.
 * 
 * Also note that some helper methods have already been declared
 * in which you can implement the corresponding features in the
 * program if you wish.
 * 
 * Written by Craig Hamilton (April 2014)
 */

public class EmployeeDataSystem
{

	// declaring the array of Employee references and the employee
	// count here at the class level so that our helper methods can
	// access the array
	//private static final Employee[] employees = new Employee[50];
	private static final List<Employee> employees = new ArrayList<Employee>();
	//private static final List<AcademicEmployee> academicEmployees = new ArrayList<AcademicEmployee>();
	private static int employeeCount = 0;


	// also declaring a Scanner here for shared use
	private static final Scanner sc = new Scanner(System.in);

	public static void save(String fileName) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
		for (Employee empl : employees)
			pw.println(empl.getName() + ", " + empl.getEmployeeNumber() + ", " + empl.getRole() + 
					", " + empl.getLevel());
		// 	      for (AcademicEmployee acad : academicEmployees)
		// 	    	 pw.println(acad.getName() + ", " + acad.getEmployeeNumber() + ", " + acad.getRole() + 
		// 	    			 ", " + acad.getLevel());
		pw.close();
	}


	public static void main(String[] args)
	{
		char selection = '\0';
		String userInput;


		// program menu - implements requirement B for stage 2

		// repeat until the user selects the "Exit" option
		do
		{
			// display menu options to the screen
			printMenu();

			// prompt the user to enter their selection
			userInput = sc.nextLine();
			System.out.println();

			if (userInput.length() != 1)
			{
				System.out.println("Error - invalid selection!");
			}
			else
			{
				// extract user's selection from the input String
				selection = userInput.charAt(0);

				// convert selection to upper case to make menu case-insensitive
				selection = Character.toUpperCase(selection);

				// process selection
				switch (selection)
				{
				case 'A':
					addNewEmployee();
					break;

				case 'B':
					displayEmployeeSummary();
					break;

				case 'C':
					updateEmployeePayScaleAndRole();
					break;

				case 'D':
					addNewAcademicEmployee();
					break;

				case 'E':
					recordPHDforAcademicEmployee();
					break;                

				case 'X':
					System.out.println("Exiting the program...");
					String fileName = "employeeData";

					try {
						save(fileName);
					} catch (FileNotFoundException e) {
						System.out.println("A FileNotFoundException occurred: " + e.getMessage());
						e.printStackTrace();
					}








				default:
					System.out.println("Error - invalid selection!");
				}
			}

			System.out.println();

		} while (selection != 'X');

	}



	// printMenu()
	//
	// Helper method which prints the required menu options to the
	// screen.

	public static void printMenu()
	{
		System.out.println("***** Employee Management System Menu *****");
		System.out.println();

		System.out.println("A. Add New Employee");
		System.out.println("B. Display Employee Summary");
		System.out.println("C. Update Employee Pay Scale Level / Role");
		System.out.println("D. Add New Academic Employee");
		System.out.println("E. Record PhD for Academic Employee"); 
		System.out.println("X. Exit");

		System.out.println();
		System.out.print("Enter your selection: ");
	}

	// addNewEmployee()
	//
	// Implement the functionality required for Stage 2 
	// requirement A in this method if you wish, otherwise you
	// can implement the feature in the relevant case within
	// the switch statement in the main() method above.

	public static void addNewEmployee()
	{   
		// delete this code when you start implementing this feature
		System.out.println("Please enter all of the requested information below.");

		System.out.println("Full Name: ");
		String name = sc.nextLine();

		System.out.println("Employee Number: ");
		String employeeNumber = sc.nextLine();

		System.out.println("Employee Role: ");
		String role = sc.nextLine();

		System.out.println("Employee Scale Level: ");
		char level = sc.findInLine(".").charAt(0);
		sc.nextLine();

		//List<Employee>employees = new ArrayList<Employee>();
		employees.add(new Employee(employeeNumber, name, role, level));
		/*Set<Employee> employeeSet = new HashSet<Employee>();
      if(!employeeSet.contains(name)) {
    	  employeeSet.add(new Employee(employeeNumber, name, role, level));
      }*/
		employeeCount = employeeCount + 1;

		System.out.println(employeeCount);

	}

	// displayEmployeeSummary()
	//
	// Implement the functionality required for Stage 2 
	// requirement B in this method if you wish, otherwise you
	// can implement the feature in the relevant case within
	// the switch statement in the main() method above.

	public static void displayEmployeeSummary()
	{
		for(int i = 0; i < employees.size(); i++){
			Employee obj = employees.get(i);

			// print basic employee details
			System.out.printf("%-18s%s\n", "Employee Number:", obj.getEmployeeNumber());

			// use the accessor for name so that the overridden version can
			// be invoked polymorphically for an AcademicEmployee later on
			System.out.printf("%-18s%s\n", "Employee Name:", obj.getName());

			System.out.printf("%-18s%s\n", "Employee Role:", obj.getRole());
			System.out.printf("%-18s%c\n", "Pay Scale Level:", obj.getLevel());

			// get the salary for the employee and print it to the screen
			System.out.printf("%-18s$%.2f\n", "Employee Salary:", obj.getSalary());
			System.out.printf("\n");
			System.out.printf("-------------------------------------------");
			System.out.printf("\n");  
		}
	}

	// updateEmployeeTitleAndRole()
	//
	// Implement the functionality required for Stage 2 
	// requirement C in this method if you wish, otherwise you
	// can implement the feature in the relevant case within
	// the switch statement in the main() method above.

	public static void updateEmployeePayScaleAndRole()
	{
		try
		{
			System.out.println("\n\nEnter the Employee number you wish to change: ");
			String employeeNumber = sc.nextLine();
			//reset variable for employeeNumber found test
			boolean found = false;
			//iterate through employees ArrayList and check for employeeNumber
			for(int i = 0; i < employees.size(); i++){
				Employee obj = employees.get(i);
				//If employeeNumber found in ArrayList, Get user to input new Pay Scale Level
				if(employeeNumber.equals(obj.getEmployeeNumber())) {
					if(obj instanceof Employee){
						found = true;
						System.out.println("\nEnter the new Pay Scale Level for this employee");
						char level = sc.findInLine(".").charAt(0);
						sc.nextLine();

						obj.validLevelIsBetweenAandE(level);
                        String valid ="true";
						if(valid == "true")
						{
							//notify successful completion and either get new role name or leave it unchanged 
							System.out.println("\nThis employee's level has been updated successfully. "
									+ "Please enter a new role for this employee, or press enter to "
									+ "leave the employee's role unchanged.");
							String role = sc.nextLine();
							if(!role.equals("")) {
								obj.setRole(role);
								System.out.println("\nThank you. This employee's role has been updated.");

							} else {
								System.out.println("\nThis employee's role has not been changed.");
							}
						} else {
							//notify level update failure
							System.out.println("\nThis employee's level update has failed!");
						}
					}
				} else { //End of IF statement.......Put AcademicEmployee code here
				
				AcademicEmployee acad = (AcademicEmployee)employees.get(i);
			    found = true;
				System.out.println("\nEnter the new Pay Scale Level for this employee");
				char level = sc.findInLine(".").charAt(0);
				sc.nextLine();
                
				try{
			
				acad.levelMustBeNotBeEorMoreThan2LevelsHigher(level);
				String valid = "true";
				if(valid == "true")
				{
					//notify successful completion and either get new role name or leave it unchanged 
					System.out.println("\nThis employee's level has been updated successfully. "
							+ "this also means that the role of this Academic Employee has been"
							+ "Updated automatically ");

				} else {
					//notify level update failure
					System.out.println("\nThis employee's level update has failed!");
				}
			   
		

			//If employee number not found, error
			if(found) {
				System.out.println("\nThis employee could not be found!");
			}
		
		}
		catch (Exception e)
		{
			System.out.println("A PayScaleException occurred: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	// addNewAcademicEmployee()
	//
	// Implement the functionality required for Stage 4 
	// requirement B in this method if you wish, otherwise you
	// can implement the feature in the relevant case within
	// the switch statement in the main() method above.

	public static void addNewAcademicEmployee()
	{
		String role = "Associate Lecturer";
		char level = 'A';

		// delete this code when you start implementing this feature
		System.out.println("Please enter all of the requested information below.");

		System.out.println("Full Name: ");
		String name = sc.nextLine();

		System.out.println("Employee Number: ");
		String employeeNumber = sc.nextLine();
		sc.nextLine();

		//List<Employee>employees = new ArrayList<Employee>();
		employees.add(new AcademicEmployee(employeeNumber, name, role, level));
		employeeCount = employeeCount + 1;

		System.out.println(employeeCount);



		//System.out.println();
		//System.out.println("Add New Academic Employee Feature Selected");
		//System.out.println();
	}

	// recordPHDForAcademicEmployee()
	//
	// Implement the functionality required for Stage 4 
	// requirement C in this method if you wish, otherwise you
	// can implement the feature in the relevant case within
	// the switch statement in the main() method above.

	private static void recordPHDforAcademicEmployee()
	{
		System.out.println("\n\nEnter the Employee number of the Academic Record you wish to change: ");
		String employeeNumber = sc.nextLine();
		//reset variable for employeeNumber found test
		boolean found = false;
		//iterate through employees ArrayList and check for employeeNumber
		for(int i = 0; i < employees.size(); i++){
			Employee obj = employees.get(i);
			//If employeeNumber found in ArrayList, Get user to input new Pay Scale Level
			if(employeeNumber.equals(obj.getEmployeeNumber())) {
				if(obj instanceof Employee) {
					found = true;
					System.out.println("\nThe PhD status can only be updated on an Academic employee.");
				} else {
					found = true;
					boolean phdrec = ((AcademicEmployee) obj).recordPhD();
					if(phdrec == true) {
						System.out.println("\nThe PhD has been recorded for this Academic Employee.");
					}
					//If employee number not found, error
					if(found == false) {
						System.out.println("\nThis employee could not be found!");
					}
				}
			}
		}
	}
}

