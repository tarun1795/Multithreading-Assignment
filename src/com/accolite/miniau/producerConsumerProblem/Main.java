package com.accolite.miniau.producerConsumerProblem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

	public static BlockingQueue<Integer> queue;
	public static void main(String[] args) {
		queue = new ArrayBlockingQueue<>(5);
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		
		producer.start();
		consumer.start();
	}
}
