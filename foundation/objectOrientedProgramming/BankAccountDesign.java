package foundation.objectOrientedProgramming;

public class BankAccountDesign {

    public static class BankAccount {

        // BankAccount attributes
        private String accountNumber;
        private String accountName;
        private double balance;

        // BankAccount methods

        // the constructor
        public BankAccount(String accountNumber, String accountName) {
            this.accountNumber = accountNumber;
            this.accountName = accountName;
            balance = 0;
        }

        // methods to read attributes
        public String getAccountNumber() {
            return accountNumber;
        }

        public String getAccountName() {
            return accountName;
        }

        public double getBalance() {
            return balance;
        }

        // methods to deposit and withdraw money
        public boolean deposit(double amount) {
            if (amount <= 0) return false;
            balance += amount;
            return true;
        }

        public boolean withdraw(double amount) {
            if (amount > balance) return false;
            balance -= amount;
            return true;
        }
    }

    public static class SavingsAccount extends BankAccount {

        private double interestRate;

        public SavingsAccount(String accountNumber, String accountName, double interestRate) {
            super(accountNumber, accountName);
            this.interestRate = interestRate;
        }

        public void addInterest() {
            double interest = getBalance() * interestRate / 100;
            this.deposit(interest);
        }
    }

    public static class CheckingAccount extends BankAccount {

        private int transactionCount;
        private static final int NUM_FREE = 3;
        private static final double TRANS_FEE = 2;


        public CheckingAccount(String accountNumber, String accountName) {
            super(accountNumber, accountName);
            transactionCount = 0;
        }

        public boolean deposit(double amount) {
            if (super.deposit(amount)) {
                transactionCount++;
                return true;
            }
            return false;
        }

        public boolean withdraw(double amount) {
            if (super.withdraw(amount)) {
                transactionCount++;
                return true;
            }
            return false;
        }

        public void deductFee() {
            if (transactionCount > NUM_FREE) {
                double fees = TRANS_FEE * (transactionCount - NUM_FREE);
                if (super.withdraw(fees)) {
                    transactionCount = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        // kaiyan is an object of BankAccount
        // An Object is a particular instance of a given class. When you open a bank account; an object or instance of the class BankAccount will be created for you.
        BankAccount kaiyan = new BankAccount("20200", "Kaiyan Zheng");

        kaiyan.deposit(500);
        kaiyan.deposit(1500);
        System.out.println("Balance is: " + kaiyan.getBalance());

        kaiyan.withdraw(400);
        System.out.println("Balance is: " + kaiyan.getBalance());

        kaiyan.withdraw(2000); // not possible
        System.out.println("Balance is: " + kaiyan.getBalance());

        SavingsAccount kaiyan_saving = new SavingsAccount("20200", "Kaiyan Zheng", 10);
        kaiyan_saving.deposit(500);
        System.out.println("Balance before interest is: " + kaiyan_saving.getBalance());

        kaiyan_saving.addInterest();
        System.out.println("Balance after interest is: " + kaiyan_saving.getBalance());

        CheckingAccount kaiyan_checking = new CheckingAccount("20200", "Kaiyan Zheng");
        kaiyan_checking.deposit(500);
        kaiyan_checking.withdraw(200);
        kaiyan_checking.deposit(700);
        kaiyan_checking.deductFee();
        System.out.println("Balance when transactions <= 3: " + kaiyan_checking.getBalance());

        kaiyan_checking.deposit(200);
        kaiyan_checking.deductFee();
        System.out.println("Balance when transactions <= 3: " + kaiyan_checking.getBalance());
    }
}

