package ds.linkedlist;

public class SinglyLLMainClass {

	public static void main(String[] args) {
		SinglyLL<Integer> list1 = new SinglyLL<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(2);
		list1.add(1);

		SinglyLL<Integer> list2 = new SinglyLL<>();
		list2.add(2);
		list2.add(4);
		list2.add(6);
		list2.add(8);

		SinglyLL<String> list3 = new SinglyLL<>();
		list3.add("Saurabh");
		list3.add("Kedia");
		list3.add("Presents");
		list3.add("Singly");
		list3.add("Linked");
		list3.add("List");

		SinglyLL<Integer> list4 = new SinglyLL<>();
		list4.add(1);
		list4.add(2);
		list4.add(3);
		list4.add(4);
		list4.add(5);
		list4.add(6);
		list4.add(7);
		list4.add(8);
		list4.add(9);
		list4.add(10);
		// creating loop
		Node<Integer> node = list4.get(4);
		list4.current.next = node;

		SinglyLL<Integer> list5 = new SinglyLL<>();
		list5.add(4);
		list5.add(2);
		list5.add(8);
		list5.add(3);
		list5.add(6);
		list5.add(1);
		list5.add(12);
		list5.add(9);
		list5.add(5);
		list5.add(7);

		// System.out.println("MERGED SORTED LIST ::: " +
		// mergeSortedLists(list1, list2));
		// System.out.println(mergeSortedLists2(list1, list2));

		// SWAP NODES
		// list3.swapNodes("Kedia", "List");
		// list3.swapNodes(1, 4);
		// System.out.println("NODES SWAPPED ::: " + list3);

		// GET Nth Node
		// System.out.println("Nth Node ::: " + list3.get(2));

		// GET SUBLIST
		// System.out.println("ORIGINAL LIST ::: " + list3);
		// System.out.println("SUBLIST ::: " + list3.subList(1, 4, list3));

		// SORT THE LIST
		// list3.head = list3.mergeSort();
		// System.out.println("SORTED LIST ::: " + list3);

		// GET MIDDLE ELEMENT
		// System.out.println("MIDDLE ELEMENT (ODD LENGTH) ::: " +
		// list1.getMiddleNode());
		// System.out.println("MIDDLE ELEMENT (EVEN LENGTH) ::: " +
		// list2.getMiddleNode());

		// DELETE LINKED LIST
		// System.out.println("ORIGINAL LIST ::: " + list1);
		// list1.clearList();
		// System.out.println("DELETED LINKED LIST ::: " + list1);

		// REVERSED LIST
		// list2.reverse();
		// System.out.println("REVERSED LIST ::: " + list2);

		// CHECK FOR LOOP
		// System.out.println("IS LOOP PRESENT ::: " + list4.isLoopPresent() + "
		// OF LENGTH ::: " + list4.loopLength());

		// RECURSIVE REVERSE
		// Node<Integer> tail = list1.recursiveReverse(list1.head);
		// tail.next = null;
		// System.out.println("RECURSIVE REVERSE ::: " + list1);

		// INSERT IN Nth POSITION
		// Node<Integer> newNode = new Node<>(66);
		// System.out.println(list1.insertAt(3, list1.head, newNode));

		// RECURSIVE LENGTH
		// System.out.println(list1.length(list1.head));

		// QUICKSORT
		// list5.quickSort(0, list5.length(list5.head) - 1, list5);
		// System.out.println("QUICKSORT ::: " + list5);

		System.out.println("IS PALINDROME ::: " + list1.isPalindrome(list1));

	}

	/**
	 * Merge two sorted lists in order (FIRST ATTEMPT)
	 * 
	 * @param list1
	 *            : first list
	 * @param list2
	 *            : second list
	 * @return merged list
	 */
	public static SinglyLL<Integer> mergeSortedLists(SinglyLL<Integer> list1, SinglyLL<Integer> list2) {
		SinglyLL<Integer> mergedList = new SinglyLL<>();
		if (list1.size != 0 && list2.size != 0 && list1.head.data < list2.head.data) {
			mergedList.add(list1.head.data);
			list1.head = list1.head.next;
		} else {
			mergedList.add(list2.head.data);
			list2.head = list2.head.next;
		}
		Node<Integer> node1 = list1.head;
		Node<Integer> node2 = list2.head;

		while (node1 != null || node2 != null) {
			Integer i = null, j = null;
			if (node1 != null) {
				i = node1.data;
			}
			if (node2 != null) {
				j = node2.data;
			}
			if ((i != null && j != null && i < j) || j == null) {
				mergedList.add(i);
				node1 = node1.next;
			} else if ((i != null && j != null && i > j) || i == null) {
				mergedList.add(j);
				node2 = node2.next;
			}
		}
		return mergedList;
	}

	/**
	 * Merge two sorted lists in order (SECOND ATTEMPT)
	 * 
	 * @param list1
	 *            : first list
	 * @param list2
	 *            : second list
	 * @return merged list
	 *//*
		 * public static SinglyLL<Integer> mergeSortedLists2(SinglyLL<Integer>
		 * list1, SinglyLL<Integer> list2) { Node<Integer> tempNode = null;
		 * Node<Integer> mergedHeadNode = null; if (list1.size != 0 &&
		 * list2.size != 0 && list1.head.data < list2.head.data) { tempNode =
		 * list1.head; mergedHeadNode = tempNode; list1.remove(1); } else {
		 * tempNode = list2.head; mergedHeadNode = tempNode; list2.remove(1); }
		 * 
		 * while (list1.size != 0 || list2.size != 0) { if ((list1.head != null
		 * && list2.head != null && list1.head.data < list2.head.data) ||
		 * list2.head == null) { tempNode.next = list1.head; tempNode =
		 * tempNode.next; list1.remove(1); } else if ((list1.head != null &&
		 * list2.head != null && list1.head.data > list2.head.data) ||
		 * list1.head == null) { tempNode.next = list2.head; tempNode =
		 * tempNode.next; list2.remove(1); } } list1.head = mergedHeadNode;
		 * return list1; }
		 */
}
