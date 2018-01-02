package com.accolite.miniau.oddEven;

public class Main {

	public static void main(String[] args) {
		Counter counterThread1 = new Counter("EVEN");
		Counter counterThread2 = new Counter("ODD");
		counterThread2.start();
		counterThread1.start();

	}
}
