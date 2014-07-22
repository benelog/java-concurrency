package study.javacon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IteratorAccessor {
	public static void main(String[] args) {
		
		final List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
		
		Runnable addAction = new Runnable(){
			@Override
			public void run() {
				add(list, 1);
				sleep();
				add(list, 2);
				sleep();
				add(list, 3);
				sleep();
				add(list, 4);
				sleep();
			}

			private void add(final List<Integer> list, int i) {
				list.add(i);
				System.out.println("Add:" +i);
			}
		};
		final Iterator<Integer> itr = list.iterator();
		
		Runnable printAction = new Runnable(){
			@Override
			public void run() {
				while(itr.hasNext()){
					System.out.println(itr.next());
					sleep();
				}
			}
		};
		ExecutorService pool = Executors.newFixedThreadPool(1);
		pool.execute(addAction);
		pool.execute(printAction);
	}

	static void sleep() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
