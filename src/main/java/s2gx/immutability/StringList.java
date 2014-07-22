package s2gx.immutability;

import java.util.ArrayList;
import java.util.List;

public class StringList {

	private final int id;

	private final List<String> strings;

	public StringList(int id, List<String> strings) {
		this.id = id;
		this.strings = strings;
		//this.strings = new ArrayList<String>(strings);
	}

	public void display() {
		System.out.println("list #" + this.id + ": " + this.strings);
	}

	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		strings.add("apple");
		strings.add("banana");
		int id = 1;
		//strings = Collections.unmodifiableList(strings);
		StringList list = new StringList(id, strings);
		list.display();
		id = 2;
		strings.add("coconut");
		list.display();
		id = 3;
		strings.remove("banana");
		list.display();
	}

}
