/**
Name: Hanah Ahmed
Date: 11/16/2019 
Course/Section: IT 206.003


Description: 

A subclass of Commuting Service class. This class tracks the expense in terms of distance, with the rate being $1.00 
per mile. The class also tracks the list of names of any other employees who rode in a same vehicle. 
*/

public class PersonalCar extends CommutingService {

   public final int MAX_additionalEmployees = 3;  // maximum number of additional employees allowed in vehicle
   public final double ratePerMile = 1.00;  // rate per mile
   private int miles;  // number of miles 
   private String additionalEmployeesNames;  // names of additional employees
   private int numAdditionalEmployees;     // number of additional employees
   private double cost;    // cost (total)
   
   // Specific constructor 
   public PersonalCar (String employeeName, double employeeBillingRate, String daysOfWeek) {
   super(employeeName, employeeBillingRate, daysOfWeek);
   }
   
   // Miles accessor    
   public int getMiles() {
      return this.miles;
   } 
   
   // Number of additional employees accessor 
   public int getnNumAdditionalEmployees() {
      return this.numAdditionalEmployees;
   }
   
   // Names of additional employees accessor
   public String getAdditionalEmployeesNames() {
      return this.additionalEmployeesNames;
   }
   
   // Miles mutator
   public void setMiles(int miles) {
      if (miles < 0) {
         throw new IllegalArgumentException("Number of miles cannot be less than zero.");
      }
      this.miles = miles;
   }
   
   // Number of additional employees mutator 
   public void setNumAdditionalEmployees (int numAdditionalEmployees) {
      if (numAdditionalEmployees > MAX_additionalEmployees || numAdditionalEmployees < 0) {
         throw new IllegalArgumentException("Number of additional employees cannot be less than zero or more than 3.");
      }
      this.numAdditionalEmployees = numAdditionalEmployees;
   }
   
   // Names of additonal employees mutator 
   public void setAdditionalEmployees (String additionalEmployeesNames) {
      if (additionalEmployeesNames == null || additionalEmployeesNames.equals("")) {
         throw new IllegalArgumentException("Invalid entry. If there are no additional employees, enter 'None', otherwise enter their names.");
      }
      this.additionalEmployeesNames = additionalEmployeesNames;
   }
   
   // Abstract equals() method, calculates the cost of personal car mileage
   public double equals() {
      cost = getMiles() * ratePerMile;
      return cost;
   }
   
   // Abstract carpoolEmployees() method, returns the names of employees who carpooled
   public String carpoolEmployees() {
      return getAdditionalEmployeesNames();
   }
   
   // Abstract billableTotal() method, returns 0 for this class (used in ServiceHours class)
   public double billableTotal() {
      return 0;
   }
    
   public String toString() {
   return super.toString() + "\nMiles driven: " + getMiles() + "\nAdditional Employees: " + getAdditionalEmployeesNames();
   }
}
