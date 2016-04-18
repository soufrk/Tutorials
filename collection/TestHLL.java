package custom.collection;

public class TestHLL {

	public static void main(String[] args) {
		HierarchicalLinkedList<String> hll = new HierarchicalLinkedList<>();
		hll.addHorizontal("My");
		hll.addHorizontal("Name");
		hll.addHorizontal("Is");
		hll.addHorizontal("Saurabh");
		hll.addHorizontal("Kedia");
		
		System.out.println(hll);
	}

}
