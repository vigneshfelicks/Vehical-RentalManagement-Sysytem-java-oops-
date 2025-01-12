package Local_Wheels;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
	        VehicleRentalSystem rentalSystem = new VehicleRentalSystem();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nVehicle Rental System");
	            System.out.println("1. Admin Login");
	            System.out.println("2. View Vehicles");
	            System.out.println("3. Request to Rent a Vehicle");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Admin Username: ");
	                    String username = scanner.nextLine();
	                    System.out.print("Enter Admin Password: ");
	                    String password = scanner.nextLine();

	                    if (rentalSystem.authenticateAdmin(username, password)) {
	                        System.out.println("Admin Login Successful!");
	                        adminMenu(rentalSystem, scanner);
	                    } else {
	                        System.out.println("Invalid Admin Credentials.");
	                    }
	                    break;

	                case 2:
	                    rentalSystem.viewVehicles();
	                    break;

	                case 3:
	                    System.out.println("Available Vehicles:");
	                    rentalSystem.viewVehicles();

	                    System.out.print("Enter Vehicle ID to Rent: ");
	                    String vehicleId = scanner.nextLine();
	                    System.out.print("Enter Your Name: ");
	                    String customerName = scanner.nextLine();

	                    boolean requestSuccess = rentalSystem.requestToRent(vehicleId, customerName);
	                    if (requestSuccess) {
	                        System.out.println("Rental request submitted. Awaiting admin approval.");
	                    } else {
	                        System.out.println("Vehicle not available or invalid ID.");
	                    }
	                    break;

	                case 4:
	                    System.out.println("Exiting system. Goodbye!");
	                    scanner.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    private static void adminMenu(VehicleRentalSystem rentalSystem, Scanner scanner) {
	        while (true) {
	            System.out.println("\nAdmin Menu");
	            System.out.println("1. Add Vehicle");
	            System.out.println("2. Update Vehicle");
	            System.out.println("3. View Rental Requests");
	            System.out.println("4. Approve or Reject Requests");
	            System.out.println("5. Logout");
	            System.out.println("6.view vehicles");
	            System.out.println("7.revoke vehicles");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Vehicle ID: ");
	                    String vehicleId = scanner.nextLine();
	                    System.out.print("Enter Vehicle Name: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Enter Vehicle Type: ");
	                    String type = scanner.nextLine();
	                    System.out.print("Enter Price Per Day: ");
	                    double pricePerDay = scanner.nextDouble();
	                    scanner.nextLine(); // Consume newline
	                    rentalSystem.addVehicle(vehicleId, name, type, pricePerDay);
	                    break;

	                case 2:
	                    System.out.print("Enter Vehicle ID to Update: ");
	                    String updateVehicleId = scanner.nextLine();
	                    System.out.print("Enter New Vehicle Name: ");
	                    String updateName = scanner.nextLine();
	                    System.out.print("Enter New Vehicle Type: ");
	                    String updateType = scanner.nextLine();
	                    System.out.print("Enter New Price Per Day: ");
	                    double updatePricePerDay = scanner.nextDouble();
	                    scanner.nextLine(); // Consume newline
	                    rentalSystem.updateVehicle(updateVehicleId, updateName, updateType, updatePricePerDay);
	                    break;

	                case 3:
	                    rentalSystem.viewRentalRequests();
	                    break;

	                case 4:
	                    System.out.print("Enter Request ID to Approve/Reject: ");
	                    int requestId = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline
	                    System.out.print("Approve (yes/no): ");
	                    String decision = scanner.nextLine();
	                    if (decision.equalsIgnoreCase("yes")) {
	                        rentalSystem.approveRequest(requestId);
	                        System.out.println("Request approved.");
	                    } else {
	                        rentalSystem.rejectRequest(requestId);
	                        System.out.println("Request rejected.");
	                    }
	                    break;

	                case 5:
	                    System.out.println("Logging out...");
	                    return;
	                case 6:
	                    rentalSystem.viewVehicles();
	                    break;
	                    
	                case 7:
	                    System.out.print("Enter Request ID to revoke/extend: ");
	                    int hirerId = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline
	                    System.out.print("revoke (yes/no): ");
	                    String decision2 = scanner.nextLine();
	                    if (decision2.equalsIgnoreCase("yes")) {
	                        rentalSystem.returnvehicle(hirerId);
	                    } else {
	                        rentalSystem.rejectRequest(hirerId);
	                        System.out.println("Rental Time Extended.");
	                    }
	                    break;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
}
