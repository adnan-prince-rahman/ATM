import java.util.*;

class UserAccount {

    private String name; 
    private int accNum; 
    private String passcode; 
    private double checkingBalance; 
    private double savingsBalance; 

   
    public UserAccount(String name, int accNum, String passcode, double checkingBalance,
            double savingsBalance) {
        this.name = name;
        this.accNum = accNum;
        this.passcode = passcode;
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
    }
    // getters for accesing private fields
    public String getName() {
        return name;
    }

    public int getAccNum() {
        return accNum;
    }

    public String getPasscode() {
        return passcode;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    // deposit function for add money to checking amount
    public void deposit(double amount) {
        checkingBalance += amount; 
        System.out.println("Deposit successful.");
    }

    // function for withdraw money from checking account
    public void withdraw(double amount) {
        if (amount <= checkingBalance) { 
            checkingBalance -= amount; 
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient money");
        }
    }
    // transfer money to savings account from checing accont
    public void transferToSavings(double amount) {
        if (amount <= checkingBalance) { 
            checkingBalance -= amount; 
            savingsBalance += amount; 
            System.out.println("Transfer to savings successful.");
        } else {
            System.out.println("Insufficient funds");
        }
    }
     // transfer money to checking accont from saving
    public void transferToChecking(double amount) {
        if (amount <= savingsBalance) { 
            savingsBalance -= amount; 
            checkingBalance += amount; 
            System.out.println("Transfer to checking successful.");
        } else {
            System.out.println("Insufficient money");
        }
    }
    // display balance function
    public void displayCheckingBalance() {
        System.out.println("Checking balance: $" + checkingBalance);
    }
    // display saving account balance function
    public void displaySavingsBalance() {
        System.out.println("Savings balance: $" + savingsBalance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // users account
        UserAccount user1 = new UserAccount("John", 123456, "pass1", 1200.0, 600.0);
        UserAccount user2 = new UserAccount("Bob", 234567, "pass2", 1500.0, 800.0);

        System.out.println("Enter your account number:");
        int accountNumber = scanner.nextInt(); 
        scanner.nextLine(); 
        System.out.println("Enter your passcode:");
        String passcode = scanner.nextLine(); 

        UserAccount currentUser = null; 

        if (accountNumber == user1.getAccNum() && passcode.equals(user1.getPasscode())) {
            currentUser = user1; 
        } else if (accountNumber == user2.getAccNum() && passcode.equals(user2.getPasscode())) {
            currentUser = user2;  
        } else {
            System.out.println("Invalid account number or passcode");
            scanner.close(); 
            return; 
        }

        System.out.println("Welcome " + currentUser.getName() + "!");

        while (true) {
             // main menu display
            System.out.println("Choose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer to Savings");
            System.out.println("4. Transfer to Checking");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    currentUser.deposit(depositAmount); 
                    break;
                case 2:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawalAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    currentUser.withdraw(withdrawalAmount); 
                    break;
                case 3:
                    System.out.println("Enter transfer amount to savings:");
                    double transferToSavingsAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    currentUser.transferToSavings(transferToSavingsAmount); 
                    break;
                case 4:
                    System.out.println("Enter transfer amount to checking:");
                    double transferToCheckingAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    currentUser.transferToChecking(transferToCheckingAmount);
                    
                    break;
                case 5:
                    currentUser.displayCheckingBalance(); 
                    currentUser.displaySavingsBalance(); 
                    scanner.nextLine();
                   
                    break;

                case 6:
                    System.out.println("succesfully Exit");
                    scanner.close();
                    return; 
                default:
                    System.out.println("Invalid choice"); 
            }
        }
    }
}
