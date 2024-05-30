public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount){
        balance += amount;
        System.out.println("deposited: $"+amount+",new balance:$"+balance);
    }
    public synchronized void withdraw(double amount){
        if(balance < amount){
            System.out.println("insufficient funds for withdrawal of $"+amount);
            return;
        }
        balance -= amount;
        System.out.println("withdrew:$"+amount+",new balance:$"+balance);
    }
    public double getBalance(){
        return balance;
    }
    public static void main(String[]args){
        BankAccount account = new BankAccount(100);

        Thread depositThread1 = new Thread(() -> account.deposit(50));
        Thread depositThread2 = new Thread(() -> account.deposit(75));

        Thread withdrawalThread1 = new Thread(() -> account.withdraw(25));
        Thread withdrawalThread2 = new Thread(() -> account.withdraw(100));

        depositThread1.start();
        depositThread2.start();

        withdrawalThread1.start();
        withdrawalThread2.start();

    }
    
}
