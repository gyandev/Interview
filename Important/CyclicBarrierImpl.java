package com.gyan.Important;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
class CabService implements Runnable
{
	CyclicBarrier barrier;
	public CabService(CyclicBarrier barrier) 
	{
		this.barrier=barrier;
	}
	@Override
	public void run() 
	{
		try
		{
			System.out.println("++++ " +Thread.currentThread().getName() + " has arrived");
			try
			{
				barrier.await();
			}
			catch(BrokenBarrierException e)
			{
				e.printStackTrace();
			}
			System.out.println("+++++" + Thread.currentThread().getName()+ "going to board the cab");
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
	
}
public class CyclicBarrierImpl 
{
	public static void main(String[] args) throws InterruptedException{
		CyclicBarrier barrier =new CyclicBarrier(3);
		Thread t1=new Thread(new CabService(barrier));
		t1.setName("Passenger1 ");
		t1.start();
		Thread.sleep(12000);
		Thread t2=new Thread(new CabService(barrier));
		t2.setName("Passenger2 ");
		t2.start();
		Thread.sleep(12000);
		Thread t3=new Thread(new CabService(barrier));
		t3.setName("Passenger3 ");
		t3.start();
		Thread.sleep(12000);
	}

}
