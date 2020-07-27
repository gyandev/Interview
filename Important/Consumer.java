package com.gyan.Important;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable
{
	private BlockingQueue queue=null;
	
	public Consumer(BlockingQueue queue) {
		this.queue = queue;
	}

	public Consumer() {
	}

	@Override
	public void run() 
	{
		try
		{
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take());
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}

}
