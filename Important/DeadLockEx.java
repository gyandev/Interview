package com.gyan.Important;
class AB
{
	public synchronized void d2(BA b)
	{
		System.out.println("Thread 2 starts execution from d2() method");
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("Thread2 trying to call AB's last() method");
	}
	public void last()
	{
		System.out.println("inside BA last() method");
	}
}
class BA
{
	public synchronized void d1(AB a)
	{
		System.out.println("Thread 1 starts execution from d1() method");
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("Thread 1 trying to call BA's last() method");
	}
	public void last()
	{
		System.out.println("inside AB last() method");
	}
}
public class DeadLockEx extends Thread{
		AB a=new AB();
		BA b=new BA();
		public void m1()
		{
			this.start();
			a.d2(b);
		}
		@Override
		public void run()
		{
			b.d1(a);
		}
		public static void main(String[] args) {
			DeadLockEx d=new DeadLockEx();
			d.m1();
		}
		
		
	}


