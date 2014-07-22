package s2gx.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Counter {

	private final AtomicInteger count = new AtomicInteger(0);

	public int increment() {
		return count.getAndIncrement();
	}

}
