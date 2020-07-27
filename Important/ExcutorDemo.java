package com.gyan.Important;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorDemo {
	
	public static void main(String[] args) {
		PrintJobs[] jobs= {new PrintJobs("gyan"),new PrintJobs("rahul"),new PrintJobs("amit"),new PrintJobs("summit")};
		ExecutorService service=Executors.newFixedThreadPool(5);
		for(PrintJobs job:jobs)
		{
			service.submit(job);
		}
		service.shutdown();
	}


}
	
class PrintJobs implements Runnable
{
	String name;

	public PrintJobs(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println( name + "Jobs started by Thread" + Thread.currentThread().getName());
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(name + "Jobs Started by Thread" + Thread.currentThread().getName());
		
	}
	
	
	
}
		

