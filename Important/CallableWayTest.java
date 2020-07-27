package com.gyan.Important;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class CallableThread implements Callable<String>{

	 @Override
	 public String call() throws Exception {
	  System.out.println("in Callable");
	  
	  
	  return "finished";
	 }
	 

	}
public class CallableWayTest {
	
	public static void main(String args[]) {
		  CallableThread callableThread = new CallableThread();
		  FutureTask futureTask = new FutureTask(callableThread);
		  futureTask.run();
		  System.out.println("hi");
		  try {
		   System.out.println(futureTask.get());
		  } catch (Exception e) {
		  }
		 }
		}

// This is the biggest difference between Runnable and Callable.
//Callable provides us a way by which we can check
//status, return value and exception of that thread which is not 
//possible in Runnable and Thread class.
