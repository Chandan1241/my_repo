package com.oops.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Thread could return some value that we can use. Java 5 introduced
 * java.util.concurrent.Callable interface in concurrency package that is
 * similar to Runnable interface but it can return any Object and able to throw
 * Exception.
 * 
 * Java Callable interface use Generic to define the return type of Object.
 * Executors class provide useful methods to execute Java Callable in a thread
 * pool. Since callable tasks run in parallel, we have to wait for the returned
 * Object.
 * 
 * Java Callable tasks return java.util.concurrent.Future object. Using Java
 * Future object, we can find out the status of the Callable task and get the
 * returned Object. It provides get() method that can wait for the Callable to
 * finish and then return the result.
 * 
 * @author chand_000
 *
 */
public class CallableThreadEx {
	public static void main(String[] args) {
		// pool size
		ExecutorService executor = Executors.newFixedThreadPool(10);
		// list of future threads
		List<Future<String>> futureList = new ArrayList<Future<String>>();
		// object for our callable
		long time = System.currentTimeMillis();
		for (int i = 0; i < 20; i++) {
			Callable<String> callable = new CallableThread("Itr " + i);
			Future<String> future = executor.submit(callable);
			futureList.add(future);
		}
		for (Future<String> future : futureList) {
			try {
				System.out.println(new Date() + future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println((System.currentTimeMillis() - time) + "ms");
		executor.shutdown();
	}

}

class CallableThread implements Callable<String> {

	private String name;

	@Override
	public String call() throws Exception {

		// write some logic or call rest calls so that we can feel the real uses
		// of it
		// for now I'm writing dummy logic
		Thread.sleep(10000);
		return name  + Thread.currentThread().getName();
	}

	public CallableThread(String name) {
		this.name = name;
	}

}
