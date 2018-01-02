package com.accolite.miniau.producerConsumerProblem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread{

	@Override
	public void run() {
		try
		{
			while(true)
			{
				int number = (int) Math.floor(Math.random()*100);
				System.out.println("Producer is producing : "+number);
				Main.queue.put(number);
				Thread.sleep(1000);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
