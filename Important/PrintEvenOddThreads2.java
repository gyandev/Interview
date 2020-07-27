package com.gyan.Important;

public class PrintEvenOddThreads2 {
	
public static void main(String[] args) {
		
		ResourceLock1	 lock=new ResourceLock1();
		
		Thread1 t1 =new Thread1(lock);
		Thread2 t2 =new Thread2(lock);
		
		t1.start();
		t2.start();
		
		
	}
}

class Thread1 extends Thread
{
	ResourceLock1 lock;
	

	public Thread1(ResourceLock1 lock) {
		
		this.lock = lock;
	}



	public void run() {
		try
		{
			synchronized (lock) {
				for(int i=0;i<100;i++)
				{
					if(i%2==0)
					{
						while(lock.flag!=1)
						{
							lock.wait();
						}
					System.out.print(Thread.currentThread().getName());
					System.out.println(":is printing even numbers : " +i);
					Thread.sleep(1000);
					lock.flag=2;
					lock.notifyAll();
					
					}
				}
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
class Thread2 extends Thread
{
	ResourceLock1 lock;
	

	public Thread2(ResourceLock1 lock) {
		
		this.lock = lock;
	}



	public void run() {
		try
		{
			synchronized (lock) {
			
				for(int i=0;i<100;i++)
				{
					if(i%2==1)
					{
						while(lock.flag!=2)
						{
							lock.wait();
						}
					System.out.print(Thread.currentThread().getName());
					System.out.println(":is printing odd numbers : " +i);
					Thread.sleep(1000);
					lock.flag=1;
					lock.notifyAll();
					
				}
			}
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}

class ResourceLock1
{
	public volatile int flag=1;
}
	






