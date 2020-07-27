package com.gyan.Important;

public class DeadLockUsingSynchronized {
	
	public static void main(String[] args) {
		Shared s1=new Shared();
		Shared s2=new Shared();
		
		Thread5 t1=new Thread5(s1,s2);
		t1.start();
		
		Thread6 t2=new Thread6(s1,s2);
		
		t2.start();
		Util1.sleep(2000);
	}
	

}
class Util1
{
	static void sleep(long mills)
	{
		try
		{
			Thread.sleep(mills);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
class Shared 
{
	synchronized void test1(Shared s2)
	{
		System.out.println("test1 -begins");
		Util1.sleep(1000);
		s2.test2(this);
		System.out.println("test1-ends");
	}
	
	synchronized void test2(Shared s1)
	{
		System.out.println("test2 -begin");
		Util1.sleep(1000);
		s1.test1(this);
		System.out.println("test2-ends");
	}
}

class Thread5 extends Thread
{
	private Shared s1;
	private Shared s2;
	public Thread5(Shared s1, Shared s2) {
		
		this.s1 = s1;
		this.s2 = s2;
	}
	
	@Override
	public void run() {
		s1.test1(s2);
	}
	
}
	


class Thread6 extends Thread
{
	private Shared s1;
	private Shared s2;
	public Thread6(Shared s1, Shared s2) {
		super();
		this.s1 = s1;
		this.s2 = s2;
	}
	
	@Override
	public void run() {
		s2.test2(s1);
	}
}


