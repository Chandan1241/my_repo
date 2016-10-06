package com.oops.examples;

/**
 * if we implement Runnable then need to create object of thread then and put
 * runnable implementation in thread constructor
 * 
 * If we extend our class from Thread then no need to create special object for
 * Thread just create object for the our class and call start method it will be
 * available as we are extending our class from Thread class
 * 
 * @author chand_000
 *
 */
class ThreadImpl implements Runnable {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(10000L);
			System.out.println("Thread excecuted " + getId());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ThreadEx {
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 5; i++) {
			System.out.println("Started :" + i);
			ThreadImpl run = new ThreadImpl();
			run.setId(i);
			Thread th = new Thread(run);
			th.start();
			if (i == 2) {
				th.setPriority(1);
			}
			if (i == 1) {
				th.suspend();
			}
			// it waits for every thread to die
			// th.join();
		}
	}

}
