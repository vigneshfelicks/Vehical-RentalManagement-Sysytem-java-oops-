package Local_Wheels;

public class RentalRequest {
	 private int id;
	    private String vehicleId;
	    private String customerName;
	    private boolean processed;
	    private boolean Completed;
	    private boolean approved;

	    public RentalRequest(int id, String vehicleId, String customerName) {
	        this.id = id;
	        this.vehicleId = vehicleId;
	        this.customerName = customerName;
	        this.processed = false;
	        this.Completed = false;
	        this.approved = false;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getVehicleId() {
	        return vehicleId;
	    }

	    public boolean isProcessed() {
	        return processed;
	    }

	    public void setProcessed(boolean processed) {
	        this.processed = processed;
	    }
	    public boolean isCompleted() {
	        return Completed;
	    }

	    public void setCompleted(boolean Completed) {
	        this.Completed = Completed;
	    }

	    public void setApproved(boolean approved) {
	        this.approved = approved;
	    }

	    @Override
	    public String toString() {
	        return "Request ID: " + id + ", Vehicle ID: " + vehicleId +
	               ", Customer Name: " + customerName + ", Processed: " + processed +
	               ", Approved: " + approved;
	    }
}
