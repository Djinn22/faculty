package employee;

public class AcademicEmployee extends Employee
{
   private boolean hasPhD = false;
   
	public AcademicEmployee(String employeeNumber, String name, String role, char level) 
   {
		super(employeeNumber, name, role, level);
		
		role = "Associate Lecturer";
		level = 'A';
		
	}
	
	@Override
	public String getName()
   {
	   if(hasPhD == true) {
	      return "Dr. " + super.getName();
	   } else {
	      return super.getName();
	   }
   }
	
	@Override
	public boolean updateLevel(char level)
	{
	   if(level == 'E') {
	         return false;
	      } else {
	         if(level >= getLevel()+2) {
	         return false;
	      }  
	   }
	   boolean valid = super.updateLevel(level);
      if(valid == true) {
         if(level == 'A') {
            setRole("Associate Lecturer");
         } else {
            if(level == 'B') {
               setRole("Lecturer");
            } else {
               if(level == 'C') {
                  setRole("Senior Lecturer");
               } else {
                  if(level == 'D') {
                     setRole("Associate Professor");
                  } else {
                     if(level == 'E') {
                        setRole("Professor");
                     }
                  }
               }
            }
         }
      }
      return true;
	}
	
	@Override
	public double getSalary()
	{
	   double salary = 0;

	   if (super.getLevel() == 'A')
      {
         salary = 50000.0;
      } else {
         if (super.getLevel() == 'B')
         {
            salary = 60000.0;
         } else {
            if (super.getLevel() == 'C')
            {
               salary = 70000.0;
            } else {
               if (super.getLevel() == 'D')
               {
                  salary = 80000.0;
               } else {
                  if (super.getLevel() == 'E')
                  {
                     salary = 90000.0;
                  } else {
                     
                  }
               }
            }  
         }
      }
      // check the Employee's current pay scale level and
      // note down corresponding salary for an employee at
      // the specified level
      return salary;
	}
	
	public boolean recordPhD()
	{
	   if(hasPhD == false) {
	      hasPhD = true;
	      return true;
	   }
	   return false;
	}
	
	public void printDetails()
	{
	   //super(getEmployeeNumber(), name, role, level);
	   
	// print basic employee details
      System.out.printf("%-18s%s\n", "Employee Number:", getEmployeeNumber());

      // use the accessor for name so that the overridden version can
      // be invoked polymorphically for an AcademicEmployee later on
      System.out.printf("%-18s%s\n", 
                        "Employee Name:", getName());

      System.out.printf("%-18s%s\n", "Employee Role:", getRole());
      System.out.printf("%-18s%c\n", "Pay Scale Level:", getLevel());

      // get the salary for the employee and print it to the screen
      System.out.printf("%-18s$%.2f\n", "Employee Salary:", getSalary());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
