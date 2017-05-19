import java.util.Scanner;
import java.util.ArrayList;
import e_data.Employee;


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
   private static final Employee[] employees = new Employee[50];
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
	  sc.nextLine();
	  
      System.out.println("Full Name: ");
      String employeeName = sc.nextLine();
      
      System.out.println("Employee Number: ");
      String employeeNumber = sc.nextLine();
      
      System.out.println("Employee Role: ");
      String employeeRole = sc.nextLine();
      
      System.out.println("Employee Scale Level: ");
      char employeePayScale = sc.findInLine(".").charAt(0);
      
      //int emp = employees.length + 1;
      
      ArrayList<Employee>employees = new ArrayList<Employee>();
      employees.add(new Employee(employeeNumber, employeeName, employeeRole, employeePayScale));
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
      // delete this code when you start implementing this feature
      System.out.println();
      System.out.println("Display Employee Summary Feature Selected");
      System.out.println();
   }
   
   // updateEmployeeTitleAndRole()
   //
   // Implement the functionality required for Stage 2 
   // requirement C in this method if you wish, otherwise you
   // can implement the feature in the relevant case within
   // the switch statement in the main() method above.
   
   public static void updateEmployeePayScaleAndRole()
   {
      // delete this code when you start implementing this feature
      System.out.println();
      System.out.println(
                   "Update Employee Pay Scale Level / Role Feature Selected");
      System.out.println();
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
