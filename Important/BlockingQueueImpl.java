package com.gyan.Important;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueImpl<T>
{
	private Queue<T> queue = new LinkedList<>();
	private final int capacity;

	public BlockingQueueImpl(int capacity) {
		this.capacity = capacity;
	}
	
	public synchronized void put(T element) throws InterruptedException
	{
		while(queue.size() == capacity)
		{
			wait();	
		}
		queue.add(element);
		notify();
		Thread.sleep(1000);
	}
	
	public synchronized T take() throws InterruptedException
	{
		while(queue.isEmpty())
		{
			wait();
		}
		T t= queue.remove();
		notify();
		Thread.sleep(1000);
		return t;
	}



	public static void main(String[] args) throws InterruptedException {
		BlockingQueueImpl<Integer> blockingQueueImpl=new BlockingQueueImpl<>(2);
		
		Runnable p=()->
		{
			Random random =new Random(1000);
			
				try {
					while(true)
					{
						int element =random.nextInt(1000);
						blockingQueueImpl.put(element);
						System.out.println("Produced::" + element);
						Thread.sleep(3000);
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
		};
		
		Runnable c=()->
		{

				try {
					while(true)
					{
						Integer element= blockingQueueImpl.take();
						System.out.println("Consumed::" + element);
						Thread.sleep(3000);
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
		};
		
		Thread producedConsumer =new Thread(p);
		Thread consumeConsumer =new Thread(c);
		
		producedConsumer.start();
		consumeConsumer.start();

	}

}
