import java.util.Scanner;
public class Project_Eric_Blanchard 
   {
      public static void main(String[] args)
      {
      Scanner scnr = new Scanner(System.in);
      
      System.out.print("Enter the Policy Number: ");
         String policyNum = scnr.nextLine();
         
      
      System.out.print("Enter the Provider Name: ");
         String providerName = scnr.nextLine();

      System.out.print("Enter the Policyholder's First Name: ");
         String firstName = scnr.nextLine();

      System.out.print("Enter the Policyholder's Last Name: ");
         String lastName = scnr.nextLine();

      System.out.print("Enter the Policyholder's Age: ");
         int age = scnr.nextInt();
         scnr.nextLine();

      System.out.print("Enter the Policyholder's Smoking Status (smoker/non-smoker): ");          
         String smokingStatus = scnr.nextLine();

      System.out.print("Enter the Policyholder's Height (in inches): ");
         double height = scnr.nextDouble();

      System.out.print("Enter the Policyholder's Weight (in pounds): ");
         double weight = scnr.nextDouble();
      
      Policy policy = new Policy(policyNum, providerName, firstName, lastName, age, smokingStatus, height, weight);
      
      System.out.println();
      
      System.out.println("Policy Number: " + policy.getPolicyNumber());
      System.out.println("Provider Name: " + policy.getProviderName());
      System.out.println("Policyholder's First Name: " + policy.getPolicyholderFirstName());
      System.out.println("Policyholder's Last Name: " + policy.getPolicyholderLastName());
      System.out.println("Policyholder's Age: " + policy.getPolicyholderAge());
      System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
      System.out.println("Policyholder's Height: " + policy.getPolicyholderHeight() + " inches");
      System.out.println("Policyholder's Weight: " + policy.getPolicyholderWeight() + " pounds");
      System.out.printf("Policyholder's BMI: %.2f\n", policy.calcBMI());
      System.out.printf("Policy Price: $%.2f", policy.policyPrice());
      
      }

      
   }