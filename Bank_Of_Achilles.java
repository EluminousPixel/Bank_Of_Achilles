import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;

public class Bank_Of_Achilles {

    public static void main(String[] args) throws FileNotFoundException {
        final byte Months_In_A_Year = 12;
        final byte Percent = 100;
        long principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;
        int moneyInBank = 0;
        boolean cal = true;
        boolean account = true;

        Scanner input = new Scanner(System.in);

        while(account) {
            System.out.println("Welcome to the Bank Of Achilles: Mortgage Calculator");
            System.out.println("Please select a choice\n 1- Log-In\n 2- Guest");
            long userInput_2 = input.nextLong();

            if(userInput_2 == 1) {
                Scanner scan;

                openFile(); {
                    try {
                        scan = new Scanner(new File ("account_names.txt"));
                    }
                    catch(Exception e) {
                        System.out.println("could not find file");
                    }
                }
                System.out.println("Please enter your username: ");
                Boolean userInput_3 = input.nextBoolean();
                while(userInput_3 = scan.nextLine() != "0537") {
                    System.out.println("This is not your username, please try again");
                    userInput_3 = input.nextBoolean();
                }
                System.out.println("Welcome to your account number 0537\n Here is your account info:");
                readFile(); {
                    while(scan.hasNext()) {
                        String a = scan.next();
                        String b = scan.next();
                        String c = scan.next();

                        System.out.printf("%s %s %s", a, b, c);
                    }

                }
                
                closeFile(); {
                    scan.close();
                }


                
            }


        }



        while (cal) {
            System.out.println("Please Type:\n 1- Mortgage Calculator\n 2- Money Transactions");
            int userInput = input.nextInt();
            
            if (userInput == 1) {
               while (true) {
                 
                
                    System.out.print("Principal (£1k - £1M): ");
                    principal = input.nextLong();
                    while(principal <= 1_000 || principal >= 1_000_000) {
                        System.out.println("Enter a number between 1,000 and 1,000,000");
                        principal = input.nextLong();  
                    }
                
                    System.out.print("Annual Interest Rate: ");
                    float annualInterest = input.nextFloat();
                    while(annualInterest <= 0 || annualInterest >= 30) {
                        System.out.println("Enter a value greater than 0 or less than 30");
                        annualInterest = input.nextFloat();
                    } 
                    monthlyInterest = annualInterest / Percent / Months_In_A_Year;
                       
                    System.out.print("Period (Years): ");
                    int years = input.nextInt();
                    while(years <= 0 || years >= 30) {
                        System.out.println("Enter a value greater than 0 or less than 30");
                        years = input.nextInt();
                    }
                    numberOfPayments = years * Months_In_A_Year;
                
                    double mortgage = principal 
                                        * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))  
                                        / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1); 
                    String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage); 
                    System.out.print("Mortgage: " + mortgageFormatted + System.lineSeparator() ); 
                    break;
                } 
            }
            

            if (userInput == 2) {
                while (true) {
                    System.out.println("Please select 1 - to take money out and 2 - to put money in."); 
                    int transactionOption = input.nextInt();        
                    if (transactionOption == 1) {
                        System.out.println("You have " + moneyInBank + " how much would you like to take out? (note limmit is 300)"); 
                        int moneyOut = input.nextInt();
                        while(moneyOut > 301) {
                            System.out.println("// Error Please Enter Amount Again //\n");
                            moneyOut = input.nextInt();  
                        }
                        moneyInBank = moneyInBank - moneyOut;
                        System.out.print("You now have " + moneyInBank + "\nThank you come again :)\n");
                    }  


                    if (transactionOption == 2) {
                        System.out.println("You have " + moneyInBank + " how much money would you\nlike to put in (note limit is 300)");
                        int moneyIn = input.nextInt();
                        while(moneyIn > 301) {
                            System.out.println("// Error Please Enter Amount Again //\n");
                            moneyIn = input.nextInt();
                        }
                        moneyInBank =  moneyInBank + moneyIn;
                        System.out.print("You now have " + moneyInBank + "\nThank you come again :)\n");        

                    
                    }       
                } 

            }

            if(userInput == 3) {
                System.out.println("Please enter account number: ");
                long account_Name_1 = input.nextLong();

            }
                      
        }
        input.close();

    }

    private static void openFile() {
    }

    private static void readFile() {
    }

    private static void closeFile() {
    }

}
