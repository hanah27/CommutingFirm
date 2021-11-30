/**
Name: Hanah Ahmed

Course/Section: IT 206.003


Description: 

The class tracks the names of employees, the number of hours worked by an employee, and the hourly 
billing rate of an employee. It also tracks the day(s) of the week an employee is scheduled to work.
*/

public abstract class CommutingService {

   private String employeeName;     // employee's name
   private double employeeBillingRate;    //employee's billing rate
   private String daysOfWeek;    // the day(s) of the week the employee is available to work
   private static int numServices;     // number of CommutingService objects created 
   
   
   // Specific constructor
   public CommutingService (String employeeName, double employeeBillingRate, String daysOfWeek) {
      if (employeeName == null || employeeName.equals("")) {
         throw new IllegalArgumentException("Employee name must be provided.");
      }
      if (employeeBillingRate < 0) {
         throw new IllegalArgumentException(employeeName + "s billing rate cannot be less than 0.");
      }
      if (daysOfWeek == null || daysOfWeek.equals("")) {
         throw new IllegalArgumentException("The day of the week " + employeeName + " provided service is required.");
      }
      
      this.employeeName = employeeName;
      this.employeeBillingRate = employeeBillingRate;
      this.daysOfWeek = daysOfWeek;
      ++this.numServices;
   }
   
   
   // Employee name accessor
   public String getEmployeeName() {
      return this.employeeName;
      }
   
   // Employee's billing rate accessor    
   public double getEmployeeBillingRate() {
      return this.employeeBillingRate;
      }

  // Employee's day(s) of the week accessor
  public String getDaysofWeek() {
      return this.daysOfWeek;
      }
  
  // Number of CommutingService objects created accessor
  public static int getNumServices() {
   return numServices;
  }
  
  // Employee name mutator
  public void setEmployeeName (String employeeName) {
      if (employeeName == null || employeeName.equals("")) {
         throw new IllegalArgumentException("Employee's name cannot be changed to not have a value.");
         }
         this.employeeName = employeeName;   
         }
  
  // Employee's billing rate mutator       
  public void setEmployeeBillingRate(double employeeBillingRate) {
   if (employeeBillingRate < 0) {
         throw new IllegalArgumentException("Employee's billing rate cannot be changed to not have a value.");
         }
         this.employeeBillingRate = employeeBillingRate;   
         }
  
  // Employee's day(s) of the week mutator
  public void setDaysOfWeek (String daysOfWeek) {
      if (daysOfWeek == null || daysOfWeek.equals("")) {
         throw new IllegalArgumentException("Employee's day availability cannot be changed to not have a value.");
         }
         this.daysOfWeek = daysOfWeek;   
         }

  // Abstact equals() 
  public abstract double equals();
  
  // Abstract carpoolEmployees() 
  public abstract String carpoolEmployees();
  
  // Abstract billableTotal
  public abstract double billableTotal();
  

  public String toString() {
     return "Name: " + this.getEmployeeName() + "\nBilling Rate: " + String.format("$%.2f",this.getEmployeeBillingRate()) + "\nDay: " + this.getDaysofWeek();
     }


}
