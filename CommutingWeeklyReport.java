/**
Name: Hanah Ahmed

Course/Section: IT 206.003


Description: 

This program supports a consulting firm that offers commuting service around the metro area. The firm charges clients by 
the hour, and employees occasionally need to visit a client’s location. To do so, they have the choice of driving 
their own car, taking a taxi or another ride sharing service. 

A primary client wants a weekly report of each consultant’s billable hours, and any travel payments earnt each week 
(such as Personal Car Mileage or Ride Services). Each billable item tracks the employee to whom it associates with, 
and the day of the week on which the charge was earned. Billable hours are the number of hours worked by the employee, 
plus their hourly rate. 

The user is prompted to select from a menu. After fully completing the selected action from the menu item, the user 
is prompted to select another menu item. This continues until the user has selected to exit the program. The program 
displays a menu to the user with the following options:

   1.	Add a Billable Item
   2.	Display all Billable Items
   3.	Display the Total for Billable Service (no travel)
   4.	Display Employees who have carpooled (drivers included)
   5.	Quit
   
Based on the user’s selection, the program proceeds to perform accordingly. 

‘Add a Billable Item’ prompts the user to select from three services: Personal Car Mileage, Ride Service, or 
Service Hours. Then, the user enters the information correspondingly. 

‘Display all Billable Items’ displays all the billable items entered by the user as a well-formatted report.

‘Display the Total for Billable Service (no travel)’ displays the total of all the employees’ billable hours (not 
including travel expenses).

‘Display Employees who have carpooled (drivers included)’ displays all the names of the drivers and the employees who 
have carpooled. 

The inputs will be: 
   -	Employee’s general information: 
      o	Employee’s name
      o	Employee’s billing rate
      o	The day of the week the employee worked
      
   -	Personal Car information: 
      o	# of miles the employee drove
      o	Number of additional employees
      o	Names of additional employees 
      
   -	Ride Service information:
      o	Ride service name
      o	Ride service cost 
      
   -	Service Hours information: 
      o	# of employee’s worked hours 
      
The output will be displayed according to the selection from the menu; either a report of all billable items, 
the total cost of billable service, or names of drivers and employees who carpooled.

*/

import javax.swing.JOptionPane;
public class CommutingWeeklyReport {
   public static void main (String[] args) {

   final int MAX_services = 7;   // Max services that can be made in a week
   CommutingService[] services = new CommutingService[MAX_services];   // creates a new CommutingService object
   CommutingService oneService;
   
   // Prompts the user to make a selection from the menu, until they indicate they are done.
   int menuSelection = getMenuSelection();       
     while (menuSelection != 5) {
      switch (menuSelection) {
         case 1:
           try {
            oneService = addItem();
            populateService(oneService);
            services[CommutingService.getNumServices() - 1] = oneService;
            }
            catch (IllegalArgumentException e) {
               JOptionPane.showMessageDialog(null, "Service could not be added\n" + e.getMessage());
               }
            break;
         case 2:
           displayItems(services, CommutingService.getNumServices());
            break;  
         case 3:
            displayTotal(services, CommutingService.getNumServices());
            break;
         case 4:
            carpool(services, CommutingService.getNumServices());
            break;
         
         }
         menuSelection = getMenuSelection();
         }
         
      if (menuSelection == 5) {
         quit();
         }

}
   // Add billable item (CommutingService object)
   // Parameters: none
   // Return: service 
   public static CommutingService addItem() {
      CommutingService service;
      
      Object[] options = {"Personal Car Mileage", "Ride Service", "Service Hours"};
      int serviceType = JOptionPane.showOptionDialog(null, "What type of service are you entering?", "Create Service", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
      
      
      String employeeName = JOptionPane.showInputDialog("Enter employee's name:");
      double employeeBillingRate = Double.parseDouble(JOptionPane.showInputDialog("Enter " + employeeName + "'s billing rate (per hour):"));
      String daysOfWeek = JOptionPane.showInputDialog("Enter the day " + employeeName + " provided service:");
      
      switch (serviceType) {
         case 0: 
            service = new PersonalCar(employeeName, employeeBillingRate, daysOfWeek);
            break;
            
         case 1:
            service = new RideService(employeeName, employeeBillingRate, daysOfWeek);
            break;
            
         case 2:
            service = new ServiceHours(employeeName, employeeBillingRate, daysOfWeek);
            break;
            
         default: 
            service = null;
            break;
      }
      
      return service;
   }
   
   
   // Populate billable items (services)
   // Parameter: CommutingService service
   // Return: void
   public static void populateService(CommutingService service) {
      if (service instanceof PersonalCar) {
         boolean milesSet = false;
         do {
            try {
               ((PersonalCar)service).setMiles(Integer.parseInt(JOptionPane.showInputDialog("Enter the number of miles:")));
               milesSet = true;
            } 
            catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(null, "You must enter a number.");
            }
            catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
         } while (!milesSet);
         
         boolean numAdditionalSet = false;
         do {
            try {
               ((PersonalCar)service).setNumAdditionalEmployees(Integer.parseInt(JOptionPane.showInputDialog("Enter the number of additional employees. If there are none, enter 0.")));
               numAdditionalSet = true;
            }
            catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(null, "You must enter a number.");
            }
            catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
         } while (!numAdditionalSet);
         
         boolean additionalEmployees = false;
         do {
            try {
               ((PersonalCar)service).setAdditionalEmployees(JOptionPane.showInputDialog("Enter the names of the additional employees (If there are no employees, enter 'None'):"));
               additionalEmployees = true;
            }
            catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
         } while (!additionalEmployees);

      }
      
      if (service instanceof RideService) {
         boolean serviceNameSet = false;
         do {
            try {
               ((RideService)service).setServiceName(JOptionPane.showInputDialog("Enter the ride service name."));
               serviceNameSet = true;
            }
            catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
         } while (!serviceNameSet);
         
         boolean serviceCostSet = false;
         do {
            try {
               ((RideService)service).setServiceCost(Double.parseDouble(JOptionPane.showInputDialog("Enter the ride service cost.")));
               serviceCostSet = true;
            }
            catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
         } while (!serviceCostSet);
      }
      
      if (service instanceof ServiceHours) {
         boolean employeeHoursSet = false;
         do {
            try {
               ((ServiceHours)service).setEmployeeHours(Integer.parseInt(JOptionPane.showInputDialog("Enter the employee's hours.")));
               employeeHoursSet = true;
            }
            catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(null, "You must enter a number.");
            }
            catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
         } while (!employeeHoursSet);

      }
   } 
    
    
   // Display all billable items (services)
   // Parameter: CommutingService[] service, int numServices
   // Return: void
   public static void displayItems (CommutingService[] service, int numServices) {
      if (numServices > 0) {
         String report = "";
         
         double total = 0;
         for (int x = 0; x < numServices; x++) {
            total += service[x].equals();
            report += service[x].getClass().getName() + "\n" + service[x].toString() + "\n\n"; 
         }
         
         report += "Total: " + String.format("$%.2f", total);
            
         JOptionPane.showMessageDialog(null, report);
          
         }
         else {
            JOptionPane.showMessageDialog(null, "There are no services!");
            }
         
   }
    
   // Display total of all billable items (services), not including travel
   // Parameter: CommutingService[] service, int numServices
   // Return: void
   public static void displayTotal (CommutingService[] service, int numServices) {
      if (numServices > 0) {
         String output = "";
         
         double total = 0;
         for (int x = 0; x < numServices; x++) {
            total += service[x].billableTotal();
         }
         
         output += "Total for Billable Service: " + String.format("$%.2f", total);
         
         JOptionPane.showMessageDialog(null, output);
         }
         else {
            JOptionPane.showMessageDialog(null, "There are no services!");
            }    
   } 
    
    
   // Display names of drivers and employees who carpooled
   // Parameter: CommutingService[] service, int numServices
   // Return: void 
   public static void carpool (CommutingService[] service, int numServices) {
   
      if (numServices > 0) {
         String displayCarpool = "";
         
         for (int i = 0; i < numServices; i++) {
            displayCarpool += "Driver: " + service[i].getEmployeeName() + "\nEmployees who carpooled: " + service[i].carpoolEmployees() + "\n";
         }
         
         JOptionPane.showMessageDialog(null, displayCarpool);
         }
         else {
            JOptionPane.showMessageDialog(null, "There are no services!");
            }
   } 
   
   public static void quit () {
      JOptionPane.showMessageDialog(null, "Thank you for your time. Have a nice day!");
   }


   // Menu selection
   // Parameter: none
   // Return: int menuSelection
   public static int getMenuSelection() {
     int menuSelection;
      do {
         try {
            menuSelection = Integer.parseInt(JOptionPane.showInputDialog(
            "Enter a number according to your selection:"
            + "\n(1) Add a Billable Item"
               + "\n(2) Display All Billable Items"
               + "\n(3) Display the Total for Billable Serivce (no travel)"
               + "\n(4) Display employees who have carpooled (drivers included)"
               + "\n(5) Quit"
            ));
         }
         catch (NumberFormatException e) {
            menuSelection = 0;
         }
         
         if (menuSelection < 1 || menuSelection > 5) {
            JOptionPane.showMessageDialog(null, "Invalid menu selection. Please try again.");
            }
         } while (menuSelection < 1 || menuSelection > 5);
              
     return menuSelection;
     }

}
