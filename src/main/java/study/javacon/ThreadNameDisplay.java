package study.javacon;

/**
 * @author benelog
 */
public class ThreadNameDisplay {

	public static void main(String[] args) {
		  System.out.println(Thread.currentThread().getName());
		  System.out.println(Runtime.getRuntime().availableProcessors());
	}
}
