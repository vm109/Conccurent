package multiThreading;

/*
 * A volatile variable is which makes the variable transparent to all the threads.
 * So, the changes of a variable are visible to all the threads.
 * 
 * If we dont have the flag variable to be volatile we can expect the variable to be in 
 * thread cache and the loop never stops even after the call `v1.setFlag(false);` in line 39
 */
public class VolatileThreading1 implements Runnable {

	private volatile boolean flag = true;

	public void printAStatement() throws InterruptedException {
		while (flag) {
			System.out.println("printing because the flag is true");
			Thread.sleep(300);
		}
	}

	
	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	public static void main(String[] args) throws InterruptedException {
		VolatileThreading1 v1 = new VolatileThreading1();
		Thread t1 = new Thread(v1);
		t1.start();

		Thread.sleep(3000);

		v1.setFlag(false);
	}

	@Override
	public void run() {
		try {
			printAStatement();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
