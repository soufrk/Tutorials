package ds.linkedlist;

public class SinglyLinkedList<T> {

	Node head;

	public class Node {
		T data;
		Node next;

		public Node(T data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
	}

	@Override
	public String toString() {
		return "SinglyLinkedList [head=" + head + "]";
	}

	public static void main(String[] args) {
		// Create a linked list with 10 nodes
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.head = list.new Node("First Node");
		SinglyLinkedList<String>.Node node = list.new Node("Second Node");
		list.head.next = node;

		for (int i = 0; i < 8; i++) {
			SinglyLinkedList<String>.Node nextNode = list.new Node("Node No : " + (i + 3));
			node.next = nextNode;
			node = nextNode;
		}

		// Traverse the Linked list and print in insertion order
		System.out.println("Traverse the Linked list and print in insertion order");
		SinglyLinkedList<String>.Node currentNode = list.head;
		list.printInOrder(currentNode);

		// Traverse the Linked list and print in reverse order
		System.out.println("\n\nTraverse the Linked list and print in reverse order");
		currentNode = list.head;
		list.printInReverse(currentNode);

		// Reverse the linked list
		System.out.println("Reverse the linked list");
		currentNode = list.head;
		SinglyLinkedList<String> reversedList = new SinglyLinkedList<>();
		SinglyLinkedList<String>.Node tempNode = reversedList.new Node(null);
		reversedList.head = list.reverseLinkedList(currentNode, tempNode);
		
		System.out.println(reversedList);
	}

	public Node reverseLinkedList(Node node, Node tempNode){
		if(node.next == null)
			return node;
		tempNode = reverseLinkedList(node.next, tempNode);
		tempNode.next = node;
		return node;
	}

	// method to print the data in nodes of linked list in order
	public void printInOrder(Node currentNode) {
		if (currentNode == null)
			return;
		System.out.print(currentNode.data + "\t");
		printInOrder(currentNode.next);
	}

	// method to print the data in nodes of linked list in reverse order
	public void printInReverse(Node node) {
		if (node == null)
			return;
		printInReverse(node.next);
		System.out.print(node.data + "\t");
	}

}
