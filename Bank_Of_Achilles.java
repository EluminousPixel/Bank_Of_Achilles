import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;

public class Bank_Of_Achilles {

    private static Scanner scan;

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
            System.out.println("Welcome to the Bank Of Achilles");
            System.out.println("Please select a choice\n 1- Log-In\n 2- Guest\n 3- Exit");
            long userInput_2 = input.nextLong(); 


            if(userInput_2 == 1) {
                
                openFile(); {
                    try {
                        File file = new File ("account_names.txt");
                        scan = new Scanner(file);
                    }
                    catch(Exception e) {
                        System.out.println("could not find file");
                        System.out.println("You are now in guest account");
                        break;
                    }
                }
                System.out.println("Please enter your username: ");
                input.next();
                while(scan.nextLine() == null) {
                    System.out.println("This is not your username, please try again");
                    input.next();
                }
                System.out.println("Welcome to your account number 0537\nHere is your account info:");
                readFile(); {
                    while(scan.hasNext()) {
                        String a = scan.next();
                        String b = scan.next();

                        System.out.printf("%s %s\n" , a, b);
                        
                    }

                }
                
                closeFile(); {
                    scan.close();
                }
               

             
            }

            if(userInput_2 == 2) {
                System.out.println("You are now in guest account");
                break;
            }
            if(userInput_2 == 3) {
                System.exit(0);
            } 
            break;
        }

        
        while (cal) {

            System.out.println("Please Type:\n 1- Mortgage Calculator\n 2- Money Transactions\n 3- Exit");
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
                    System.out.println("Please select:\n 1- Money out\n 2- Money in\n 3- Exit"); 
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
                    if(transactionOption == 3) {
                        System.exit(0);
                    }
                         
                } 

            }

            if(userInput == 3) {
                System.exit(0);
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
