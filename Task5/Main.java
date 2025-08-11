import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n***** BANK MANAGEMENT SYSTEM *****");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    sc.nextLine(); // consume newline
                    String name = sc.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double deposit = sc.nextDouble();
                    String accNo = bank.createAccount(name, deposit);
                    System.out.println("Account created! Account Number: " + accNo);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    String accNoDep = sc.next();
                    System.out.print("Enter deposit amount: ");
                    double amtDep = sc.nextDouble();
                    if (bank.depositMoney(accNoDep, amtDep))
                        System.out.println("Deposit successful.");
                    else
                        System.out.println("Account not found!");
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    String accNoWit = sc.next();
                    System.out.print("Enter withdraw amount: ");
                    double amtWit = sc.nextDouble();
                    if (bank.withDrawl(accNoWit, amtWit))
                        System.out.println("Withdrawal successful.");
                    else
                        System.out.println("Insufficient funds or account not found!");
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    String accNoBal = sc.next();
                    Double bal = bank.checkBalance(accNoBal);
                    if (bal != null)
                        System.out.println("Balance: " + bal);
                    else
                        System.out.println("Account not found!");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
