package s2gx.task;

import java.util.concurrent.Callable;

public class SlowTask implements Callable<String> {

	private final SlowProcessor processor = new SlowProcessor();

	private final String input;

	public SlowTask(String input) {
		this.input = input;
	}

	public String call() throws Exception {
		return this.processor.process(input);
	}

}
