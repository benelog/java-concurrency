package s2gx.confinement;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		Executor executor = Executors.newFixedThreadPool(5);
		Writer writer = new Writer();
		for (int i = 1; i <= 5; i++) {
			executor.execute(new WriterTask(writer, i));
		}
	}


	private static class Writer {

		void write(String value) {
			ConnectionHolder.getConnection().write(value);
		}
	}


	private static class WriterTask implements Runnable {

		private final Writer writer;

		private final int id;

		private WriterTask(Writer writer, int id) {
			this.writer = writer;
			this.id = id;
		}

		public void run() {
			for (int i = 1; i <= 3; i ++) {
				try {
					this.writer.write(this.id + "." + i);
					Thread.sleep(new Random().nextInt(5000));
				}
				catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					return;
				}
			}
		}
	}

}
