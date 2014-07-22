package s2gx.task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class InterruptDemo {

	public static void main(String[] args) throws Exception {
		Callable<String> task = new Callable<String>() {
			public String call() throws Exception {
				return new InfiniteProcessor().process("foo");
			}
		};
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<String> future = executor.submit(task);
		/*Thread.sleep(3000);
		if (!future.isDone()) {
			future.cancel(true);
		}*/
		try {
			String result = future.get(5000, TimeUnit.MILLISECONDS);
			System.out.println("result: " + result);
		}
		catch (TimeoutException e) {
			System.out.println("timed out, cancelling task...");
			future.cancel(true); // also show with FALSE
		}
		executor.shutdown();
		// the, replace with this: (task won't finish shutdown cleanup)
		//executor.shutdownNow();
	}

}
