import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
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
   private static final ArrayList<Employee> employees = new ArrayList<Employee>();
   private static int employeeCount = 0;
  

   // also declaring a Scanner here for shared use
   private static final Scanner sc = new Scanner(System.in);

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
                  break;
                  
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
	   System.out.println("Enter the Employee number you wish to change: ");
	   String employeeNumber = sc.nextLine();

	   for(int i = 0; i < employees.size(); i++){
	       Employee obj = employees.get(i);
	       if(employeeNumber.equals(obj.getEmployeeNumber())) {
	    	   System.out.println("Enter the new Pay Scale Level for this employee");
	    	   char level = sc.findInLine(".").charAt(0);
	    	   sc.nextLine();
	    	     boolean valid = obj.updateLevel(level);
	    	     if(valid)
	    	     {
	    	    	 System.out.println("This employee's level has been updated successfully. "
	    	    	 		+ "Please enter a new role for this employee, or press enter to "
	    	    	 		+ "levae the employee's role unchanged.");
	    	    	 String role = sc.nextLine();
	    	    	 if(role != "") {
	    	    		 obj.setRole(role);
	    	    	 }
	    	     } else {
	    	    	 System.out.println("This employee's level update has failed!");
	    	     }
	       }    
	   }
	   
	   System.out.println("This employee could not be found!");
   }
   
   // addNewAcademicEmployee()
   //
   // Implement the functionality required for Stage 4 
   // requirement B in this method if you wish, otherwise you
   // can implement the feature in the relevant case within
   // the switch statement in the main() method above.
   
   public static void addNewAcademicEmployee()
   {
      // delete this code when you start implementing this feature
      System.out.println();
      System.out.println("Add New Academic Employee Feature Selected");
      System.out.println();
   }
   
   // recordPHDForAcademicEmployee()
   //
   // Implement the functionality required for Stage 4 
   // requirement C in this method if you wish, otherwise you
   // can implement the feature in the relevant case within
   // the switch statement in the main() method above.
   
   private static void recordPHDforAcademicEmployee()
   {
      // delete this code when you start implementing this feature
      System.out.println();
      System.out.println("Record PhD for Academic Employee Feature Selected");
      System.out.println();
      
   }
   
}
