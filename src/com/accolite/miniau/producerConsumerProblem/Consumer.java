package com.accolite.miniau.producerConsumerProblem;

public class Consumer extends Thread{

	@Override
	public void run() {
		
		try
		{
			while(true)
			{
				int number = Main.queue.take();
				System.out.println("Consumer consumses : "+number);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
