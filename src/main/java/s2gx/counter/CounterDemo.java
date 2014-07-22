package s2gx.counter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CounterDemo {

	public static void main(String[] args) throws Exception {
		final Counter counter = new SynchronizedCounter();
		int loop = 100000;
//		 also try: newSingleThreadPool, newFixedThreadPool(2)
		ExecutorService executor = Executors.newFixedThreadPool(100);
		final CountDownLatch latch = new CountDownLatch(loop);
		long start = System.currentTimeMillis();
		for (int i = 0; i < loop; i++) {
			executor.execute(new Runnable() {
				public void run() {
					counter.increment();
					latch.countDown();
				}
			});
		}
		System.out.println("threads: " + Thread.activeCount());
		latch.await();
		long time = System.currentTimeMillis() - start;
		System.out.println("time:  " + time + "ms");		
		System.out.println("count: " + counter.increment());
		
		executor.shutdown();
	}

}
