import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project_Eric_Blanchard {
    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>();
        File file = new File("PolicyInformation.txt");

        int smokerCount = 0;
        int nonSmokerCount = 0;

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                // Read and skip any blank lines
                String policyNum = fileScanner.nextLine().trim();
                if (policyNum.isEmpty()) continue;

                String providerName = fileScanner.nextLine().trim();
                String firstName = fileScanner.nextLine().trim();
                String lastName = fileScanner.nextLine().trim();
                int age = Integer.parseInt(fileScanner.nextLine().trim());
                String smokingStatus = fileScanner.nextLine().trim();
                double height = Double.parseDouble(fileScanner.nextLine().trim());
                double weight = Double.parseDouble(fileScanner.nextLine().trim());

                // Create a Policy object and add it to the list
                Policy policy = new Policy(policyNum, providerName, firstName, lastName, age, smokingStatus, height, weight);
                policies.add(policy);

                // Count smokers and non-smokers
                if (smokingStatus.equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else if (smokingStatus.equalsIgnoreCase("non-smoker")) {
                    nonSmokerCount++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: PolicyInformation.txt file not found.");
            return;
        } catch (Exception e) {
            System.out.println("Error reading from file: " + e.getMessage());
            return;
        }

        // Display the information for each policy
        for (Policy policy : policies) {
            System.out.println("\nPolicy Information:");
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getPolicyholderFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getPolicyholderLastName());
            System.out.println("Policyholder's Age: " + policy.getPolicyholderAge());
            System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
            System.out.println("Policyholder's Height: " + policy.getPolicyholderHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policy.getPolicyholderWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f\n", policy.calcBMI());
            System.out.printf("Policy Price: $%.2f\n", policy.policyPrice());
        }

        // Display the count of smokers and non-smokers
        System.out.println("\nSummary:");
        System.out.println("Number of policyholders that are smokers: " + smokerCount);
        System.out.println("Number of policyholders that are non-smokers: " + nonSmokerCount);
    }
}
