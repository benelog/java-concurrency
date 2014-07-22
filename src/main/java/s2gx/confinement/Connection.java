package s2gx.confinement;

public class Connection {

	private final int id;

	public Connection(int id) {
		this.id = id;
	}

	public void write(String value) {
		System.out.println(Thread.currentThread().getName() + " writing " + value + " [connection:" + this.id + "]");
	}

}
