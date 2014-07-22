package s2gx.counter;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class LockingCounter implements Counter {

	private int count;

	private final WriteLock lock = new ReentrantReadWriteLock().writeLock();

	public int increment() {
		lock.lock();
		try {
			return count++;
		}
		finally {
			lock.unlock();
		}
	}

}
