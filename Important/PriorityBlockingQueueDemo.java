package com.gyan.Important;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo 
{
	
	public static void main(String[] args) {
		
		String[] arrayNames = { "Delhi","Mumbai","Kolkatta","Bangalore","Hyderabad","Chennai"};
		BlockingQueue<String> blockingQueue = new PriorityBlockingQueue<>();
		// producer Thread
		new Thread()
		{
			public void run()
			{
				for (String s:arrayNames)
				{
					try {
				//		System.out.println("Produced:" + s);
						blockingQueue.put(s);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}.start();
		
		// Consume Thread
		new Thread()
		{
			
			public void run()
			{
				for (String s:arrayNames)
				{
					try {
						System.out.println("Consumed :" + blockingQueue.take());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}.start();
		
	}

}
