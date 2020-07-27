package com.gyan.Important;

public class PrintThreeThreads {
	
	public static void main(String[] args) {
		ResourceLock lock=new ResourceLock();
		
		ThreadA t1 =new ThreadA(lock);
		Thread1B t2 =new Thread1B(lock);
		ThreadC t3 =new ThreadC(lock);
		t1.start();
		t2.start();
		t3.start();
	}
}
class ThreadA extends Thread
{
	ResourceLock lock;
	

	public ThreadA(ResourceLock lock) {
		
		this.lock = lock;
	}



	public void run() {
		try
		{
			synchronized (lock) {
				for(int i=0;i<100;i++)
				{
					while(lock.flag!=1)
					{
						lock.wait();
					}
					System.out.print(Thread.currentThread().getName() + ":");
					System.out.println("A");
					Thread.sleep(1000);
					lock.flag=2;
					lock.notifyAll();
					
				}
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
class Thread1B extends Thread
{
	ResourceLock lock;
	

	public Thread1B(ResourceLock lock) {
		
		this.lock = lock;
	}



	public void run() {
		try
		{
			synchronized (lock) {
				for(int i=0;i<100;i++)
				{
					while(lock.flag!=2)
					{
						lock.wait();
					}
					System.out.print(Thread.currentThread().getName() + ":");
					System.out.println("B");
					Thread.sleep(1000);
					lock.flag=3;
					lock.notifyAll();
					
				}
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}

class ThreadC extends Thread
{
	ResourceLock lock;
	

	public ThreadC(ResourceLock lock) {
		super();
		this.lock = lock;
	}



	public void run() {
		try
		{
			synchronized (lock) {
				for(int i=0;i<100;i++)
				{
					while(lock.flag!=3)
					{
						lock.wait();
					}
					System.out.print(Thread.currentThread().getName() + ":");
					System.out.println("C");
					Thread.sleep(1000);
					lock.flag=1;
					lock.notifyAll();
					
				}
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}



class ResourceLock
{
	public volatile int flag=1;
}
	
	
		
	





