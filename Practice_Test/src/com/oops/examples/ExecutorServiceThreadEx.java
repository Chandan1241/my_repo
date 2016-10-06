package com.oops.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExecutorServiceThread {

	public int id;

	public ExecutorServiceThread(int id) {
		this.id = id;
	}

	public void display() {
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread end :::: " + id);
	}
}

public class ExecutorServiceThreadEx {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println("Start time :: " + startTime);
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 15; i++) {
			ExecutorServiceThread th = new ExecutorServiceThread(i);
			service.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("Started thread executing ::: " + th.id);
					th.display();
				}
			});
		}
		service.shutdown();
		while (!service.isTerminated()) {
		}
		System.out.println("Finished");
		long endTime = System.currentTimeMillis();
		System.out.println("Time Took ::::: " +((endTime- startTime)/1000.0) + " sec ");
		
	}
}
