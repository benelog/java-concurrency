package s2gx.task;

import java.util.Random;

public class SlowProcessor implements Processor {

	private static final Random random = new Random();

	/**
	 * Takes between 5-10 seconds to process the input String.
	 * @param input String to be processed
	 * @return uppercase value of input String
	 */
	public String process(String input) {
		String result = input;
		try {
			int delay = 5000 + random.nextInt(5000);
			System.out.println("processing " + input + " [will take " + delay + "ms]");
			Thread.sleep(delay);
			result = result.toUpperCase();
		}
		catch (InterruptedException e) {
			System.out.println("interrupted task while processing " + result);
			Thread.currentThread().interrupt();
		}
		System.out.println("returning " + result);
		return result;
	}

}
