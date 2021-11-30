/**
Name: Hanah Ahmed

Course/Section: IT 206.003


Description: 

A subclass of Commuting Service class. The class tracks the price and the name of a service (Lyft, Uber, Yellow Cab, etc.).
*/

public class RideService extends CommutingService {

   private String serviceName;  // name of ride service
   private double serviceCost;  // cost of ride service
   private double cost;  // cost of ride service (total)

   // Specific constructor 
   public RideService (String employeeName, double employeeBillingRate, String daysOfWeek) {
   super(employeeName, employeeBillingRate, daysOfWeek);
   }
  
   // Service name accessor 
   public String getServiceName() {
      return this.serviceName;
   }
   
   // Service cost accessor 
   public double getServiceCost() {
      return this.serviceCost;
   }
   
   // Service name mutator 
   public void setServiceName(String serviceName) {
      if (serviceName == null || serviceName.equals("")) {
         throw new IllegalArgumentException("The name of the ride sharing service must be provided.");
      }
   this.serviceName = serviceName;
   }
   
   // Service cost mutator 
   public void setServiceCost(double serviceCost) {
      if (serviceCost < 0) {
         throw new IllegalArgumentException("The service cost cannot be less than zero.");
      }
   this.serviceCost = serviceCost;
   }
   
   // Abstract equals() method, returns the cost of the ride service 
   public double equals() {
      cost = getServiceCost();
      return cost;
   }
   
   // Abstract carpoolEmployees() method, returns none for this class (used in PersonalCar class)
   public String carpoolEmployees() {
      return "None";
   }

  // Abstract billableTotal() method, returns 0 for this class (used in ServiceHours class)
   public double billableTotal() {
      return 0;
   }

   public String toString() {
   return super.toString() + "\nService Name: " + getServiceName() + "\nService Cost: " + String.format("$%.2f", getServiceCost());
   }
}
