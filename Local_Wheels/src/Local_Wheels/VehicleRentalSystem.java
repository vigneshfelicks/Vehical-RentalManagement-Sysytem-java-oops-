package Local_Wheels;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class VehicleRentalSystem {
	  private Vehicle[] vehicles;
	    private RentalRequest[] rentalRequests;
	    private int vehicleCount;
	    private int requestCount;

	    // Constructor
	    public VehicleRentalSystem() {
	        vehicles = new Vehicle[100]; // Maximum 100 vehicles
	        rentalRequests = new RentalRequest[100]; // Maximum 100 rental requests
	        vehicleCount = 0;
	        requestCount = 0;
	    }

	    // Authenticate Admin using Properties file
	    public boolean authenticateAdmin(String username, String password) {
	        Properties properties = new Properties();
	        try (FileInputStream fis = new FileInputStream("C:/Vicky/admin.properties")) {
	            properties.load(fis);
	            String storedUsername = properties.getProperty("admin.username");
	            String storedPassword = properties.getProperty("admin.password");
	            properties.setProperty("email"," 123@gmail.com");

	            return username.equals(storedUsername) && password.equals(storedPassword);
	        } catch (IOException e) {
	            System.out.println("Error loading admin credentials: " + e.getMessage());
	            return false;
	        }
	    }

	    // Add a vehicle
	    public void addVehicle(String id, String name, String type, double pricePerDay) {
	        if (vehicleCount < vehicles.length) {
	            vehicles[vehicleCount++] = new Vehicle(id, name, type, pricePerDay, true);
	            System.out.println("Vehicle added successfully.");
	        } else {
	            System.out.println("Vehicle storage is full. Cannot add more vehicles.");
	        }
	    }

	    // Update an existing vehicle
	    public void updateVehicle(String id, String name, String type, double pricePerDay) {
	        for (int i = 0; i < vehicleCount; i++) {
	            if (vehicles[i].getId().equals(id)) {
	                vehicles[i].setName(name);
	                vehicles[i].setType(type);
	                vehicles[i].setPricePerDay(pricePerDay);
	                System.out.println("Vehicle updated successfully.");
	                return;
	            }
	        }
	        System.out.println("Vehicle with ID " + id + " not found.");
	    }

	    // View all vehicles
	    public void viewVehicles() {
	        if (vehicleCount == 0) {
	            System.out.println("No vehicles available.");
	            return;
	        }
	        for (int i = 0; i < vehicleCount; i++) {
	            System.out.println(vehicles[i]);
	        }
	    }

	    // Request to rent a vehicle
	    public boolean requestToRent(String vehicleId, String customerName) {
	        for (int i = 0; i < vehicleCount; i++) {
	            if (vehicles[i].getId().equals(vehicleId) && vehicles[i].isAvailable()) {
	                if (requestCount < rentalRequests.length) {
	                    rentalRequests[requestCount++] = new RentalRequest(requestCount, vehicleId, customerName);
	                    vehicles[i].setAvailable(false); // Mark vehicle as unavailable
	                    return true;
	                } else {
	                    System.out.println("Rental request storage is full. Cannot process more requests.");
	                    return false;
	                }
	            }
	        }
	        return false;
	    }

	    // View all rental requests
	    public void viewRentalRequests() {
	        if (requestCount == 0) {
	            System.out.println("No rental requests.");
	            return;
	        }
	        for (int i = 0; i < requestCount; i++) {
	            System.out.println(rentalRequests[i]);
	        }
	    }

	    // Approve a rental request
	    public void approveRequest(int requestId) {
	        for (int i = 0; i < requestCount; i++) {
	            if (rentalRequests[i].getId() == requestId && !rentalRequests[i].isProcessed()) {
	                rentalRequests[i].setProcessed(true);
	                rentalRequests[i].setApproved(true);
	                System.out.println("Rental request approved.");
	                return;
	            }
	        }
	        System.out.println("Request with ID " + requestId + " not found or already processed.");
	    }
	    // revoke a rental vehicle
	    public void returnvehicle(int requestId) {
	        for (int i = 0; i < requestCount; i++) {
	            if (rentalRequests[i].getId() == requestId && !rentalRequests[i].isCompleted()) {
	                rentalRequests[i].setProcessed(true);
	                rentalRequests[i].setApproved(false);
	                vehicles[i].setAvailable(true); // Mark vehicle as available
	                System.out.println("Vehicle Returned.");
	                return;
	            }
	        }
	        System.out.println("Request with ID " + requestId + "revoked.");
	    }

	    // Reject a rental request
	    public void rejectRequest(int requestId) {
	        for (int i = 0; i < requestCount; i++) {
	            if (rentalRequests[i].getId() == requestId && !rentalRequests[i].isProcessed()) {
	                rentalRequests[i].setProcessed(true);
	                rentalRequests[i].setApproved(false);

	                // Mark vehicle as available again
	                for (int j = 0; j < vehicleCount; j++) {
	                    if (vehicles[j].getId().equals(rentalRequests[i].getVehicleId())) {
	                        vehicles[j].setAvailable(true);
	                        break;
	                    }
	                }

	                System.out.println("Rental request rejected.");
	                return;
	            }
	        }
	        System.out.println("Request with ID " + requestId + " not found or already processed.");
	    }
}
