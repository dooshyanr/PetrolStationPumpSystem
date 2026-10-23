
public class PetrolPump {

    // Seven private attributes
    private int pumpID;
    private String fuelType;
    private double fuelPrice;
    private double fuelAvailable;
    private double litresDispensed;
    private double totalAmount;
    private boolean isOperational;

    // Default constructor
    public PetrolPump() {
        pumpID = 101;
        fuelType = "RON95";
        fuelPrice = 2.05;
        fuelAvailable = 1000.0;
        litresDispensed = 0.0;
        totalAmount = 0.0;
        isOperational = true;
    }

    // Parameterized constructor
    public PetrolPump(int pumpID, String fuelType,
            double fuelPrice, double fuelAvailable,
            double litresDispensed, double totalAmount,
            boolean isOperational) {

        setPumpID(pumpID);
        setFuelType(fuelType);
        setFuelPrice(fuelPrice);
        setFuelAvailable(fuelAvailable);
        setLitresDispensed(litresDispensed);
        setTotalAmount(totalAmount);
        setOperational(isOperational);
    }

    // Seven getter methods
    public int getPumpID() {
        return pumpID;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getFuelPrice() {
        return fuelPrice;
    }

    public double getFuelAvailable() {
        return fuelAvailable;
    }

    public double getLitresDispensed() {
        return litresDispensed;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isOperational() {
        return isOperational;
    }

    // Seven setter methods with basic validation
    public void setPumpID(int pumpID) {
        if (pumpID > 0) {
            this.pumpID = pumpID;
        }
    }

    public void setFuelType(String fuelType) {
        if (fuelType != null && !fuelType.trim().isEmpty()) {
            this.fuelType = fuelType;
        }
    }

    public void setFuelPrice(double fuelPrice) {
        if (fuelPrice >= 0) {
            this.fuelPrice = fuelPrice;
        }
    }

    public void setFuelAvailable(double fuelAvailable) {
        if (fuelAvailable >= 0) {
            this.fuelAvailable = fuelAvailable;
        }
    }

    public void setLitresDispensed(double litresDispensed) {
        if (litresDispensed >= 0) {
            this.litresDispensed = litresDispensed;
        }
    }

    public void setTotalAmount(double totalAmount) {
        if (totalAmount >= 0) {
            this.totalAmount = totalAmount;
        }
    }

    public void setOperational(boolean isOperational) {
        this.isOperational = isOperational;
    }

    /**
     * Additional Method 1:
     * Calculates the total cost of the fuel dispensed.
     */
    public double calculateFuelCost() {
        return litresDispensed * fuelPrice;
    }

    /**
     * Additional Method 2:
     * Dispenses fuel if the pump is operational
     * and sufficient fuel is available.
     */
    public boolean dispenseFuel(double litres) {

        if (!isOperational) {
            System.out.println("Pump is not operational.");
            return false;
        }

        if (litres <= 0 || litres > fuelAvailable) {
            System.out.println(
                "Invalid litres or insufficient fuel.");
            return false;
        }

        litresDispensed = litres;
        totalAmount = calculateFuelCost();
        fuelAvailable -= litres;

        return true;
    }
}

