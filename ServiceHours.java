/**
Name: Hanah Ahmed

Course/Section: IT 206.003


Description: 

A subclass of Commuting System class. The class tracks the service hours of each employee’s service.
*/

public class ServiceHours extends CommutingService {
   
   private int employeeHours;  // employee's hours 
   private double cost;  // cost (total)
   
   // Specific constructor 
   public ServiceHours (String employeeName, double employeeBillingRate, String daysOfWeek) {
   super(employeeName, employeeBillingRate, daysOfWeek);
   }
   
   // Employee hours accessor    
   public int getEmployeeHours() {
      return this.employeeHours;
   }
   
   // Employee hours mutator 
   public void setEmployeeHours(int employeeHours) {
      if (employeeHours < 0) {
         throw new IllegalArgumentException("Employee hours cannot be less than 0.");
      }
   this.employeeHours = employeeHours;
   }

   // Abstract method equals(), calculates the cost of employee hours multiplied by their billing rate 
   public double equals() {
      cost = getEmployeeHours() * super.getEmployeeBillingRate();
      return cost;
   }
   
   // Abstract carpoolEmployees() method, returns none for this class (used in PersonalCar class)
   public String carpoolEmployees() {
   return "None";
   }
   
   // Abstract method billableTotal(), calculates the total billable cost of all employees multiplied by their billing rate
   public double billableTotal() {
     double billableCost = cost + cost;
     return billableCost;
   }

   public String toString() {
   return super.toString() + "\nService Hours: " + getEmployeeHours() + " hours at " + String.format("$%.2f", super.getEmployeeBillingRate()) + " per hour (" + String.format("$%.2f", cost) + ")";
   }
}
