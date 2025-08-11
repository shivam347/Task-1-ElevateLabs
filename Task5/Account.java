public class Account {

    private String accountNumber;
    private String name;
    private double balance;

    public Account(String accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    /* Method for deposit Money */
    public void deposit(double amount){
        balance += amount;
    }

    /* Method to withdraw money */
    public boolean withDrawl(double amount){

        if(amount <= balance){
            balance -= amount;
            return true;
        }

        return false;
    }

    

    
    
}
