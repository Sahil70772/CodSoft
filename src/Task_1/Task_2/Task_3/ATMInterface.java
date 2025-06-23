import java.util.Scanner;

public class ATMInterface {

    // BankAccount inner class
    static class BankAccount {
        private int balance;

        public BankAccount(int initialBalance) {
            this.balance = initialBalance;
        }

        public void deposit(int amount) {
            balance += amount;
        }

        public boolean withdraw(int amount) {
            if (amount > balance) {
                return false;
            }
            balance -= amount;
            return true;
        }

        public int getBalance() {
            return balance;
        }
    }

    // ATM logic
    static class ATM {
        private BankAccount account;
        private Scanner scanner;

        public ATM(BankAccount account) {
            this.account = account;
            this.scanner = new Scanner(System.in);
        }

        public void start() {
            int choice;
            do {
                displayMenu();
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        performWithdrawal();
                        break;
                    case 2:
                        performDeposit();
                        break;
                    case 3:
                        showBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM.");
                        break;
                    default:
                        System.out.println("Invalid selection. Try again.");
                        break;
                }
            } while (choice != 4);
        }

        private void displayMenu() {
            System.out.println("\n=== ATM MENU ===");
            System.out.println("--------------------");
            System.out.println("1. Withdraw Funds");
            System.out.println("2. Deposit Funds");
            System.out.println("3. View Balance");
            System.out.println("4. Exit");
        }

        private void performWithdrawal() {
            System.out.print("Enter amount to withdraw: ");
            int amount = scanner.nextInt();
            if (account.withdraw(amount)) {
                System.out.println("Successfully withdrawn: " + amount);
            } else {
                System.out.println("Insufficient balance.");
            }
        }

        private void performDeposit() {
            System.out.print("Enter amount to deposit: ");
            int amount = scanner.nextInt();
            account.deposit(amount);
            System.out.println("Successfully deposited: " + amount);
        }

        private void showBalance() {
            System.out.println("Current balance: " + account.getBalance());
        }
    }

    // Main method
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(1000);
        ATM atm = new ATM(myAccount);
        atm.start();
    }
}
