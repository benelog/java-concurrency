package s2gx.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TaskDemo {

	// TODO: demo ExecutorService, thread pool configuration, rejection policy
	// also: get() returns value, throws ExecutionException, or TimeoutException
	// discuss ordering of results (considering SlowTask has a random sleep)
	// show invokeAny() to get first available result

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newScheduledThreadPool(10);
		List<Callable<String>> tasks = new ArrayList<Callable<String>>();
		for (int i = 1; i <= 10; i++) {
			tasks.add(new SlowTask("test-" + i));
		}
		List<Future<String>> results = executorService.invokeAll(tasks, 12, TimeUnit.SECONDS);
		for (Future<?> next : results) {
			System.out.println(next.get(20, TimeUnit.SECONDS));
		}
		//String result = executorService.invokeAny(tasks, 12, TimeUnit.SECONDS);
		//System.out.println("result: " + result);
	}
}
