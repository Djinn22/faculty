package employee;


import java.util.List;

/*
 * class Employee
 * 
 * This class is a demonstration of how the Employee type could
 * have been implemented so as to fulfill the requirements set out
 * in stage 1 of the Assignment 3 specification.
 * 
 * You are expected to work off the implementation of this Employee
 * class for your program in Assignment 3.
 * 
 * Written by Craig Hamilton (April 2014)
 */
public class Employee
{
   // instance variables - requirement A)
   private String employeeNumber;
   private String name;
   private String role;
   private char level;

   // constants representing the salaries for different pay scale
   // levels - note that these were not a requirement in this assignment
   private static final double LEVEL_A_SALARY = 50000.0;
   private static final double LEVEL_B_SALARY = 60000.0;
   private static final double LEVEL_C_SALARY = 70000.0;
   private static final double LEVEL_D_SALARY = 80000.0;
   private static final double LEVEL_E_SALARY = 90000.0;

   // constructor - requirement B)
   public Employee(String employeeNumber, String name, 
         String role, char level)
   {
      this.employeeNumber = employeeNumber;
      this.name = name;
      this.role = role;
      this.level = level;
   }

   // accessors - requirement C)
   public String getEmployeeNumber()
   {
      return employeeNumber;
   }

   public String getName()
   {
      return name;
   }

   public String getRole()
   {
      return role;
   }

   public char getLevel()
   {
      return level;
   }


   // simple mutators - requirement D)

   public void setRole(String role)
   {
      this.role = role;
   }


   // updateLevel() - requirement E) (i)
   //
   // Updates the current pay scale level to the level passed
   // in as a parameter IFF the new level falls within the valid
   // range of pay scale levels (ie. 'A' to 'E').

   public boolean updateLevel(char level)
   {
      // check for invalid pay scale level
      if (level < 'A' || level > 'E')
      {
         return false;
      }
      else
      {
         this.level = level;
         return true;
      }
   }

   public void validLevelIsBetweenAandE(char level)
         throws Exception
   {
      if (level < 'A' || level > 'E')
      {
         Exception exception = new PayScaleException("The new level needs to be a single "
               + "letter between A and E inclusive. You entered " + level);
         throw exception;
      }
      this.level = level;
   } 

   // getEmployeeSalary() - requirement E) (ii)
   //
   // Returns the salary for the employee based on their
   // current pay scale level - note that we are assuming
   // the current pay scale level will be within the valid
   // range of pay scale levels (ie. A' to 'E')

   public double getSalary()
   {
      double salary;

      // check the Employee's current pay scale level and
      // note down corresponding salary for an employee at
      // the specified level
      if (level == 'A')
      {
         salary = LEVEL_A_SALARY;
      }
      else if (level == 'B')
      {
         salary = LEVEL_B_SALARY;
      }
      else if (level == 'C')
      {
         salary = LEVEL_C_SALARY;
      }
      else if (level == 'D')
      {
         salary = LEVEL_D_SALARY;
      }
      else
      {
         salary = LEVEL_E_SALARY;
      }

      // return the salary corresponding to the Employee's
      // current pay scale level
      return salary;
   }

   // printEmployeeDetails() - requirement F)
   //
   // Helper method which displays the details for the current
   // Employee to the screen.
   public void printDetails()
   {
      // print basic employee details
      System.out.printf("%-18s%s\n", "Employee Number:", employeeNumber);

      // use the accessor for name so that the overridden version can
      // be invoked polymorphically for an AcademicEmployee later on
      System.out.printf("%-18s%s\n", 
            "Employee Name:", getName());

      System.out.printf("%-18s%s\n", "Employee Role:", role);
      System.out.printf("%-18s%c\n", "Pay Scale Level:", level);

      // get the salary for the employee and print it to the screen
      System.out.printf("%-18s$%.2f\n", "Employee Salary:", getSalary());
   }

      
      public static String listToString(List<?> list) {
         String result = "+";
         for (int i = 0; i < list.size(); i++) {
             result += " " + list.get(i);
         }
         return result;
     }
      


  

}


