package Local_Wheels;

public class Vehicle {
	 private String id;
	    private String name;
	    private String type;
	    private double pricePerDay;
	    private boolean available;

	    public Vehicle(String id, String name, String type, double pricePerDay, boolean available) {
	        this.id = id;
	        this.name = name;
	        this.type = type;
	        this.pricePerDay = pricePerDay;
	        this.available = available;
	    }

	    public String getId() {
	        return id;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public void setPricePerDay(double pricePerDay) {
	        this.pricePerDay = pricePerDay;
	    }

	    public void setAvailable(boolean available) {
	        this.available = available;
	    }

	    public boolean isAvailable() {
	        return available;
	    }

	    @Override
	    public String toString() {
	        return "Vehicle ID: " + id + ", Name: " + name + ", Type: " + type +
	               ", Price Per Day: " + pricePerDay + ", Available: " + available;
	    }
}
