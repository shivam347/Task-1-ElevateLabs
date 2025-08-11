import java.util.*;


public class Bank {

    /* String as accountNumber and account class act as data type for the accounts */
    Map<String, Account> accounts = new HashMap<>();

    /* To generate the account Number  */
    private Random random = new Random();


    /* Method for account creation */
    public String createAccount(String name, double initialDeposit){
        String accountNo = "AC"+ (300000 + random.nextInt(999)); // generate random accountNo

        accounts.put(accountNo, new Account(accountNo, name, initialDeposit));

        return accountNo;

    }


    /* Method to deposit money to bank account */
    public boolean depositMoney(String accountNo, double amount){

        Account acc = accounts.get(accountNo); // fetch the correct account no if exists

        if(acc != null){
           
          acc.deposit(amount);  // call deposit method from account class
          return true;

        }

        return false;
    }


    /* Method to withdrawl money from bank account */
    public boolean withDrawl(String accountNo, double amount){

      Account acc =   accounts.get(accountNo); // check from accounts it holds account no as key 

      if(acc != null){
        acc.withDrawl(amount);
        return true;
      }

      return false;
    }

    /* Method to check balance using object as return type as it will autoboxed automatically from string to double */
    public double checkBalance(String accNo){
        Account acc = accounts.get(accNo);

        if(acc != null){

            return acc.getBalance();
        }else{
            return (Double) null;
        }

    
    }

    
}
