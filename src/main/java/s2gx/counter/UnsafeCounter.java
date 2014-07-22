package s2gx.counter;

public class UnsafeCounter implements Counter {

	private int count = 0;

	public int increment() {
		return count++;
	}

}
