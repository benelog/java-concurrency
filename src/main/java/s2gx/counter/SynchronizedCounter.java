package s2gx.counter;

public class SynchronizedCounter implements Counter {

	private int count = 0;

	public synchronized int increment() {
		return count++;
	}

}
