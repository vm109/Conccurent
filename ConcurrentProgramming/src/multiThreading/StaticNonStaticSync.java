package multiThreading;

class StockBroker implements Runnable{
	int amountofpurchase;
	int i=3000;
	public synchronized  void setamountofpurchase(int amount){
		amountofpurchase = amount;
	}
	public static int mediationrate(int amountofpurchase){
		
		if(amountofpurchase <=3000){
			return 20;
		}
	else if(amountofpurchase>3000&&amountofpurchase<5000){
			return 30;
		}
		else if(amountofpurchase>5000&&amountofpurchase<7000){
			return 35;
		}
		else
		{
			return 40;
		}
	}
	public void run(){
		setamountofpurchase(i);
		i +=1000;
System.out.println(mediationrate(amountofpurchase));	
	}
}
public class StaticNonStaticSync {
public static void main(String[] args){
	StockBroker p1 = new StockBroker();
	p1.setamountofpurchase(2000);
	Thread t1 = new Thread(p1);
	t1.start();
	Thread t2 = new Thread(p1);
	t2.start();
	Thread t3 = new Thread(p1);
	t3.start();
	Thread t4 = new Thread(p1);
	t4.start();
	Thread t5 = new Thread(p1);
	t5.start();

}
}
