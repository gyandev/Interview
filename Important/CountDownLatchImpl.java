package com.gyan.Important;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class Processors implements Runnable
{
	private CountDownLatch CountDownLatch;
	public Processors(CountDownLatch CountDownLatch)
	{
		this.CountDownLatch=CountDownLatch;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Started..");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CountDownLatch.countDown();
		
	}
}
public class CountDownLatchImpl 
{
	public static void main(String[] args) throws InterruptedException {
		
	CountDownLatch countDownLatch=new CountDownLatch(3);
	ExecutorService executorService=Executors.newFixedThreadPool(3);
	for(int i=0;i<3;i++)
	{
		executorService.submit(new Processors(countDownLatch));
	}
	countDownLatch.await();
	System.out.println("Completed");
	}

}
