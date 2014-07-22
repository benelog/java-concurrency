/*
 * @(#)SyncDemo.java $version 2011. 11. 16.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package study.javacon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author benelog
 */
public class SyncDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object lock = new Object();
		Object lock2 = new Object();
		ExecutorService pool = Executors.newSingleThreadExecutor();
		
		pool.execute(new Walker("A walker",lock));
		pool.execute(new Walker("B walker",lock));
		pool.execute(new Walker("C walker",lock));
		
		pool.shutdown();
	}


	static class Walker implements Runnable {

		private String name;
		private Object lock;
		
		public Walker(String name, Object lock){
			this.name = name;
			this.lock = lock;
		}
		/**
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			moveStep(name,1);
			moveStep(name,2);
			moveStep(name,3);
			
			synchronized (lock) {
				System.out.println(name + " : start sync block");
				moveStep(name,4);
				moveStep(name,5);
				moveStep(name,6);
				System.out.println(name  + ": end sync block");				
			}
			moveStep(name,7);
			moveStep(name,8);
			moveStep(name,9);
			
		
		}
		/**
		 * @param name2
		 * @param i
		 */
		private void moveStep(String name, int i) {
			System.out.printf("%s, %d\n",name,i);
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
		}

	}

}
