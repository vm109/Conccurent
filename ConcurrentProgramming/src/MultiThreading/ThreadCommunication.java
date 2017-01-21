package MultiThreading;

class Bank implements Runnable{
	
	int balance;
Bank(int amount){
	balance =  amount;
	}
	public void deposit(int amount){
		balance += amount;
	}
	public void withdraw(int amount){
		balance -= amount;
	}
	public int getbalance(){
		return balance;
	}
	public void printbalance(){
		System.out.println(balance);
	}
	public void run(){
	if(Thread.currentThread().getName().equals("w")){
		withdraw(1000);
		printbalance();
	}
    }	
}

public class ThreadCommunication {
public static void main(String[] args){
	Bank jointAccount = new Bank(10000);
	System.out.println("The balance is "+jointAccount.balance);
	Thread withdraw = new Thread(jointAccount,"w");
	withdraw.start();
	Thread withdraw1 = new Thread(jointAccount,"w");
	withdraw1.start();
}
}
