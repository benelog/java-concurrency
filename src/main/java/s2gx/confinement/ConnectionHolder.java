package s2gx.confinement;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class ConnectionHolder {

	private static final AtomicInteger counter = new AtomicInteger();

	private static ThreadLocal<Connection> connection = new ThreadLocal<Connection>() {
		protected Connection initialValue() {
			return new Connection(counter.incrementAndGet());
		}
	};

	public static Connection getConnection() {
		return connection.get();
	}

}
