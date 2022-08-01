import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte Months_In_A_Year = 12;
        final byte Percent = 100;
        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to the Bank Of Achilles: Mortgage Calculator");
        
            while (true) {
                System.out.print("Principal (£1k - £1M): ");
                principal = scanner.nextInt();
                if (principal >= 1_000 && principal <= 1_000_000)
                    break;
                System.out.println("Enter a number between 1,000 and 1,000,000");
            }
           
            while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            monthlyInterest = annualInterest / Percent / Months_In_A_Year;
            if (annualInterest >= 0 && annualInterest <= 30)
                break;
            System.out.println("Enter a value greater than 0 or less than 30");
            }
    
            while (true) {
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();
            numberOfPayments = years * Months_In_A_Year;
            if (years >= 0 && years <= 30)
                break;
            System.out.println("Enter a value greater than 0 or less than 30");
            }
            
            double mortgage = principal
                        * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                        / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
            
            String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
            System.out.print("Mortgage: " + mortgageFormatted + System.lineSeparator() );

            System.out.print("Next Person Pls :) \n");
        }
        
        
        

    }
}