
import java.util.Scanner;

/**
 * Main class for the Petrol Station Pump System.
 * Demonstrates object creation, selection, loops,
 * and attribute manipulation through getters and setters.
 */
public class PetrolStationMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create an object using the default constructor.
        PetrolPump pump = new PetrolPump();

        // Demonstrate the parameterized constructor.
        PetrolPump pump2 = new PetrolPump(
            102, "RON97", 3.10, 500.0,
            0.0, 0.0, true
        );

        System.out.println("================================");
        System.out.println(" PETROL STATION PUMP SYSTEM");
        System.out.println("================================");

        // Demonstrate setters to modify attributes.
        pump.setPumpID(101);
        pump.setFuelType("RON95");
        pump.setFuelPrice(2.05);

        // Demonstrate getters to retrieve attributes.
        System.out.println("Pump ID: " + pump.getPumpID());
        System.out.println("Test Pump Fuel: " + pump2.getFuelType());

        // Demonstrate a for loop to display fuel options.
        String[] fuelOptions = {"RON95", "RON97", "Diesel"};

        System.out.println("\nAvailable Fuel Types:");

        for (int i = 0; i < fuelOptions.length; i++) {
            System.out.println((i + 1) + ". " + fuelOptions[i]);
        }

        // Demonstrate switch selection for fuel type.
        System.out.print("\nSelect fuel type (1-3): ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                pump.setFuelType("RON95");
                pump.setFuelPrice(2.05);
                break;

            case 2:
                pump.setFuelType("RON97");
                pump.setFuelPrice(3.10);
                break;

            case 3:
                pump.setFuelType("Diesel");
                pump.setFuelPrice(2.15);
                break;

            default:
                System.out.println(
                    "Invalid selection. Defaulting to RON95.");
                pump.setFuelType("RON95");
                pump.setFuelPrice(2.05);
        }

        System.out.println("\nSelected Fuel: " + pump.getFuelType());
        System.out.printf("Price per litre: RM %.2f%n",
            pump.getFuelPrice());

        // Demonstrate a while loop for repeated transactions.
        String continueTransaction = "yes";

        while (continueTransaction.equalsIgnoreCase("yes")) {

            // Use if-else to check the pump's operational status.
            if (pump.isOperational()) {

                System.out.printf(
                    "\nAvailable fuel: %.2f litres%n",
                    pump.getFuelAvailable());

                System.out.print("Enter litres to purchase: ");
                double litres = input.nextDouble();

                // Call the fuel dispensing method.
                boolean success = pump.dispenseFuel(litres);

                if (success) {
                    System.out.println("\nTransaction Successful!");

                    // Get updated attributes using getter methods.
                    System.out.printf("Litres purchased: %.2f%n",
                        pump.getLitresDispensed());

                    System.out.printf("Total payment: RM %.2f%n",
                        pump.getTotalAmount());

                    System.out.printf("Remaining fuel: %.2f litres%n",
                        pump.getFuelAvailable());
                }

            } else {
                System.out.println("Pump is unavailable.");
                break;
            }

            System.out.print(
                "\nDo you want another transaction? (yes/no): ");
            continueTransaction = input.next();
        }

        // Display final pump information using getters.
        System.out.println("\n===== FINAL PUMP DETAILS =====");
        System.out.println("Pump ID: " + pump.getPumpID());
        System.out.println("Fuel Type: " + pump.getFuelType());

        System.out.printf("Fuel Price: RM %.2f%n",
            pump.getFuelPrice());

        System.out.printf("Fuel Remaining: %.2f litres%n",
            pump.getFuelAvailable());

        System.out.printf("Last Dispensed: %.2f litres%n",
            pump.getLitresDispensed());

        System.out.printf("Total Amount: RM %.2f%n",
            pump.getTotalAmount());

        System.out.println("Operational: " + pump.isOperational());

        System.out.println("\nThank you for using our system!");

        input.close();
    }
}
