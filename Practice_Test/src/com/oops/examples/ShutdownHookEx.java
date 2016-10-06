package com.oops.examples;

public class ShutdownHookEx {

	public static void main(String[] args) {

	}

}

class MyThreadEx extends Thread{  
    public void run(){  
        System.out.println("Shutdown hook completed");  
    }  
}
