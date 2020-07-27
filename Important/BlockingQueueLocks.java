package com.gyan.Important;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueLocks<T>
{
	private Queue<T> queue =new LinkedList<>();
	private final int capacity;
	
	private Lock lock =new ReentrantLock();
	private Condition fullCondition =lock.newCondition();
	private Condition emptyCondition = lock.newCondition();
	
	
	
	public BlockingQueueLocks(int capacity) {
		this.capacity = capacity;
	}



	public void put (T element) throws InterruptedException
	{
		lock.lock();
		while(queue.size() == capacity)
		{
			fullCondition.await();
		}
		queue.add(element);
		emptyCondition.signal();
		lock.unlock();	
	}
	
	public T take() throws InterruptedException
	{
		lock.lock();
		while(queue.isEmpty())
		{
			emptyCondition.await();
		}
		T t = queue.remove();
		fullCondition.signal();
		lock.unlock();
		return t;
		
	}
	
	public static void main(String[] args) {
BlockingQueueLocks<Integer> blockingQueueImpl=new BlockingQueueLocks(2);
		
		Runnable p=new Runnable()
		{
			Random random =new Random(1000);

			@Override
			public void run() 
			{
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
				
			}
			
			
		};
		
		Runnable c=new Runnable()
		{

			@Override
			public void run() 
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
				
			}
			
			
		};
		
		Thread producedConsumer =new Thread(p);
		Thread consumeConsumer =new Thread(c);
		
		producedConsumer.start();
		consumeConsumer.start();

	}

}
	
	
	


