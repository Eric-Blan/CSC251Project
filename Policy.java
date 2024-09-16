import java.util.Scanner;
public class Policy
   {
   // Attributes
      private String policyNumber;
      private String providerName;
      private String policyholderFirstName;
      private String policyholderLastName;
      private int policyholderAge;
      private String smokingStatus; //"Smoker"/"Non-smoker"
      private double policyholderHeight; //Inches
      private double policyholderWeight; //Pounds
   
   // No-arg Constructor
      public Policy() {
         this.policyNumber = "???";
         this.providerName = "???";
         this.policyholderFirstName = "???";
         this.policyholderLastName = "???";
         this.policyholderAge = 0;
         this.smokingStatus = "???";
         this.policyholderHeight = 0.0;
         this.policyholderWeight = 0.0;
      }
      
   // Constructor for initialization
      public Policy(String policyNum, String providerName, String firstName, String lastName, int age, String smokingStatus, double height, double weight) {
         this.policyNumber = policyNum;
         this.providerName = providerName;
         this.policyholderFirstName = firstName;
         this.policyholderLastName = lastName;
         this.policyholderAge = age;
         this.smokingStatus = smokingStatus;
         this.policyholderHeight = height;
         this.policyholderWeight = weight;
      }
      
   
   // Setters
      public void setPolicyNumber(String policyNumber) {
         this.policyNumber = policyNumber;
      }
   
      public void setProviderName(String providerName) {
         this.providerName = providerName;
      }
      
      public void setPolicyholderFirstName(String firstName) {
         this.policyholderFirstName = firstName;
      }
      
      public void setPolicyholderLastName(String lastName) {
         this.policyholderLastName = lastName;
      }
   
      public void setPolicyholderAge(int age) {
         this.policyholderAge = age;
      }
      
      public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
      }

    public void setPolicyholderHeight(double height) {
        this.policyholderHeight = height;
      }

    public void setPolicyholderWeight(double weight) {
        this.policyholderWeight = weight;
      }  
   
   // Getters
      public String getPolicyNumber() {
         return policyNumber;
      }

      public String getProviderName() {
         return providerName;
       }

      public String getPolicyholderFirstName() {
         return policyholderFirstName;
      }

      public String getPolicyholderLastName() {
         return policyholderLastName;
      }

      public int getPolicyholderAge() {
         return policyholderAge;
      }

      public String getSmokingStatus() {
         return smokingStatus;
      }

      public double getPolicyholderHeight() {
         return policyholderHeight;
      }

      public double getPolicyholderWeight() {
         return policyholderWeight;
      }
      
   // BMI Calculator method
      public double calcBMI() {
         return (policyholderWeight *703)/(policyholderHeight*policyholderHeight);
      }
      
   // Insurance Policy price
      public double policyPrice() {
      
      double insuranceBase = 600;
      double fees = 0;
      double BMI = calcBMI();
      
      if (policyholderAge > 50){
         fees += 75;
      }
      
      if (smokingStatus.equalsIgnoreCase("smoker")) {
         fees += 100;
      }
      
      if (BMI > 35) {
         fees += (BMI - 35) *20;
      }
      
         return insuranceBase + fees;    
      }   
      
   
   // Main method for user input
      public static void main(String[]args)
      {
      Scanner scnr = new Scanner(System.in);
      
      Policy policy = new Policy();
      
         System.out.println("Please enter the Policy Number: ");
            String policyNum = scnr.nextLine();
            policy.setPolicyNumber(policyNum);
         
         System.out.println("Please enter the Provider Name: ");
            String providerName = scnr.nextLine();
            policy.setProviderName(providerName);
            
         System.out.println("Please enter the Policyholder’s First Name: ");
            String firstName = scnr.nextLine();
            policy.setPolicyholderFirstName(firstName);
            
         System.out.println("Please enter the Policyholder’s Last Name: ");
            String lastName = scnr.nextLine();
            policy.setPolicyholderLastName(lastName);
         
         System.out.println("Please enter the Policyholder’s Age: ");
            int age = scnr.nextInt();
            policy.setPolicyholderAge(age);
            
            scnr.nextLine();
            
         System.out.println("Please enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
            String smokingStatus = scnr.nextLine();
            policy.setSmokingStatus(smokingStatus);
            
         
         System.out.println("Please enter the Policyholder’s Height (in inches): ");
            double height = scnr.nextDouble();
            policy.setPolicyholderHeight(height);
            
         System.out.println("Please enter the Policyholder’s Weight (in pounds): ");
            double weight = scnr.nextDouble();
            policy.setPolicyholderWeight(weight);
            
            policy.displayResults();        
      }
   
   // Display answers given by the user
      public void displayResults() {
         System.out.println("Policy Number: " + policyNumber);
         System.out.println("Provider Name: " + providerName);
         System.out.println("Policyholder's First Name: " + policyholderFirstName);
         System.out.println("Policyholder's Last Name: " + policyholderLastName);
         System.out.println("Policyholder's Age: " + policyholderAge);
         System.out.println("Policyholder's Smoking Status: " + smokingStatus);
         System.out.println("Policyholder's Height: " + policyholderHeight);
         System.out.println("Policyholder's Weight: " + policyholderWeight);
         System.out.printf("Policyholder's BMI: %.2f\n", calcBMI());
         System.out.printf("Policy Price: $%.2f", policyPrice());
      
      }
   }