package s2gx.task;

public class InfiniteProcessor implements Processor {

	public String process(String input) {
		int count = 0;
		while (true) {
			try {
				System.out.println("loop " + (count++));
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				// TODO: maybe we should handle this?

				// step 1:
				// e.printStackTrace();

				// step 2:
				// Thread.currentThread().interrupt();
				
				// step 3:
				System.out.println("doing some stuff at shutdown...");
				try {
					Thread.sleep(3000);
				}
				catch (Exception e2) {
					System.out.println("oh no... didn't finish cleanup!");
					return null;
				}
				System.out.println("really done now");
				Thread.currentThread().interrupt();
				return null;
			}
		}
	}

}
