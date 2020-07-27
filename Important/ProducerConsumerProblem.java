package com.gyan.Important;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerProblem 
{
	
	public static void main(String[] args) 
	{
	    Random random = new Random();

		BlockingQueue  blockingQueue =new ArrayBlockingQueue(10); 
		 final Runnable producer =()->
		 {
			 while(true)
			 {
				 int element = random.nextInt();
				 try {
				System.out.println("Produced :" + element);
				blockingQueue.put(element);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			 
		 };
		 new Thread(producer).start();
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 final Runnable consumer =()->
		 {
			 while(true)
			 {
				 try {
					System.out.println("Consume :" + blockingQueue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			 }
			 
		 };
		 new Thread(consumer).start();
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
