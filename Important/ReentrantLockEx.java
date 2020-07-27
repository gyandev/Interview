package com.gyan.Important;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource {

	public void doSomething(){
		//do some operation, DB read, write etc
		System.out.println("do some operation, DB read, write etc");
	}
	
	public void doLogging(){
		//logging, no need for thread safety
		System.out.println("logging, no need for thread safety");
	}
}
public class ReentrantLockEx implements Runnable {
	
	private Resource resource;
	private ReentrantLock rlc;
	private Lock lock;
	
	public ReentrantLockEx(Resource r){
		this.resource = r;
		this.lock = new ReentrantLock();
		this.rlc=new ReentrantLock();
	}
	
	@Override
	public void run() {
		try {
			if(lock.tryLock(10, TimeUnit.SECONDS)){
			resource.doSomething();
			System.out.println(rlc.isHeldByCurrentThread());
			System.out.println(rlc.getHoldCount());
			System.out.println(rlc.getQueueLength());
			
			
			}
			else
			{
				resource.doLogging();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			//release lock
			lock.unlock();
		}
	//	resource.doLogging();
	}

	
	public static void main(String[] args) {
		Resource r=new Resource();
		
		ReentrantLockEx RLr=new ReentrantLockEx(r);
		
		Thread t=new Thread(RLr);
		t.start();
		
		
	}

}
