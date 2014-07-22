package s2gx.immutability;

public class StringHolder {

	private final int id;

	private final String value;

	public StringHolder(int id, String value) {
		this.id = id;
		this.value = value;
	}

	public void display() {
		System.out.println(this.id + ": " + this.value);
	}

	public static void main(String[] args) {
		String value = "apple";
		int id = 1;
		StringHolder holder = new StringHolder(id, value);
		holder.display();
		id = 2;
		value = "banana";
		holder.display();
		id = 3;
		value = "coconut";
		holder.display();
	}

}
