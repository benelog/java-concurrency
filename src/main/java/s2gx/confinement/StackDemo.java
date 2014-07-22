package s2gx.confinement;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class StackDemo {

	public static void main(String[] args) {
		Executor executor = Executors.newFixedThreadPool(5);
		for (int i = 1; i <= 5; i++) {
			final int id = i;
			executor.execute(new Runnable() {
				public void run() {
					Writer writer = new Writer(id);
					Connection connection = new Connection(id);
					for (int i = 1; i <= 3; i++) {
						writer.write(i, connection);
					}
				}
			});
		}
	}


	private static class Writer {

		private final int id ;

		private Writer(int id) {
			this.id = id;
		}

		private void write(int number, Connection connection) {
			connection.write(id + "." + number);
		}
	}

}
