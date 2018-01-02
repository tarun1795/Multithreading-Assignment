package com.accolite.miniau.oddEven;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter extends Thread{
	
	final int MAX;
	static AtomicInteger count = new AtomicInteger(1);
	static Lock lock = new ReentrantLock();

	public Counter(String name)
	{
		super(name);
		MAX = 100;
	}
	
	private synchronized void printOdd()
	{
		boolean hasLock = false;
		try {
			while(!hasLock)
				hasLock = lock.tryLock();
			System.out.println("Thread :"+this.getName()+" "+(count));
			//count.incrementAndGet();
			lock.unlock();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private synchronized void printEven()
	{
		boolean hasLock = false;
		try
		{
			while(!hasLock)
				hasLock = lock.tryLock();
			System.out.println("Thread :"+this.getName()+" "+(count));
			//count.incrementAndGet();
			lock.unlock();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public synchronized void run() {
		try
		{
			do
			{
				if(this.getName().equals("ODD") && count.get()%2 !=0)
				{
					printOdd();
					count.incrementAndGet();
				}
				else if(this.getName().equals("EVEN") && count.get()%2 ==0)
				{
					printEven();
					count.incrementAndGet();
				}
			}while(count.get()<=MAX);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
