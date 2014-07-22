package net.jcip.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HiddenIteratorAccessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final HiddenIterator itr = new HiddenIterator();
		Runnable ac1 = new Runnable(){
			@Override
			public void run() {
				itr.add(1);
				System.out.println("1");
				sleep();
				itr.add(2);
				System.out.println("2");
				sleep();
				itr.add(3);
				System.out.println("3");
			}
		};
		
		Runnable ac2 = new Runnable(){
			@Override
			public void run() {
				itr.addTenThings();
				sleep();
				itr.addTenThings();
			}
		};
		
		ExecutorService pool = Executors.newFixedThreadPool(1);
		pool.execute(ac2);
		pool.execute(ac1);
	}

	static void sleep() {
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
