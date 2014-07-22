package s2gx.immutability;

import java.util.HashMap;
import java.util.Map;

public class MapHolder {

	private final Map<Integer, StringValue> map;

	public MapHolder(Map<Integer, StringValue> map) {
		this.map = new HashMap<Integer, StringValue>(map);
	}

	public void display() {
		System.out.println(this.map);
	}

	public static void main(String[] args) {
		Map<Integer, StringValue> map = new HashMap<Integer, StringValue>();
		StringValue value1 = new StringValue("apple");
		StringValue value2 = new StringValue("banana");
		map.put(1, value1);
		map.put(2, value2);
		MapHolder holder = new MapHolder(map);
		holder.display();
		value1.setString("coconut");
		holder.display();
	}


	public static class StringValue {

		private String string;

		public StringValue(String string) {
			this.string = string;
		}

		public void setString(String string) {
			this.string = string;
		}

		public String toString() {
			return this.string;
		}
	}

}
