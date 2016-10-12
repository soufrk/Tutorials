package ds.linkedlist;

import java.util.Comparator;
import java.util.Stack;

public class SinglyLL<T extends Comparable<T>> {
	Node<T> head;
	Node<T> current;
	int size;

	/**
	 * Adds a given object to the list.
	 * 
	 * @param data
	 *            : object to add.
	 */
	public void add(T data) {
		if (current == null) {
			head = new Node<>(data);
			current = head;
		} else {
			current.next = new Node<>(data);
			current = current.next;
		}
		size++;
	}

	/**
	 * Removes a given object from the list.
	 * 
	 * @param data
	 *            : object to delete
	 * @return true if object is found and deleted else false.
	 */
	public boolean remove(T data) {
		Node<T> temp = head;
		if (temp != null && temp.data.equals(data)) {
			head = temp.next;
			size--;
			return true;
		}
		while (temp != null && temp.next != null) {
			if (temp.next.data.equals(data)) {
				temp.next = temp.next.next;
				size--;
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	/**
	 * Removes the node at given index.
	 * 
	 * @param index
	 *            : node position
	 * @return true if node is removed and false if it is not.
	 */
	public boolean remove(int index) {
		int position = 0;
		Node<T> temp = head;
		if (temp != null && index == position) {
			head = temp.next;
			size--;
			return true;
		}
		position++;
		while (temp != null && temp.next != null) {
			if (position == index) {
				temp.next = temp.next.next;
				size--;
				return true;
			}
			temp = temp.next;
			position++;
		}
		return false;

	}

	/**
	 * Prints a list in order
	 * 
	 * @param currentNode
	 */
	public void printInOrder(Node<T> currentNode) {
		if (currentNode == null)
			return;
		System.out.print(currentNode.data + "\t");
		printInOrder(currentNode.next);
	}

	/**
	 * Prints a list in reverse order.
	 * 
	 * @param node
	 */
	public void printInReverse(Node<T> node) {
		if (node == null)
			return;
		printInReverse(node.next);
		System.out.print(node.data + "\t");
	}

	/**
	 * Swap nodes of the given indices
	 * 
	 * @param x
	 * @param y
	 */
	public void swapNodes(int x, int y) {
		Node<T> cursor = head;
		Node<T> curX = null;
		Node<T> prevX = null;
		Node<T> curY = null;
		Node<T> prevY = null;
		int position = 0;
		if (x == y)
			return;
		if (cursor != null && x == position) {
			curX = head;
		}
		position++;
		while (cursor != null && cursor.next != null) {
			if (x == position) {
				prevX = cursor;
				curX = cursor.next;
			}
			if (y == position) {
				prevY = cursor;
				curY = cursor.next;
			}
			position++;
			cursor = cursor.next;
		}
		Node<T> temp = null;
		if (prevX != null)
			prevX.next = curY;
		else
			head = curY;
		prevY.next = curX;
		temp = curY.next;
		curY.next = curX.next;
		curX.next = temp;
	}

	/**
	 * Swap nodes containing the data provided.
	 * 
	 * @param x
	 * @param y
	 */
	public void swapNodes(T x, T y) {
		Node<T> cursor = head;
		Node<T> curX = null;
		Node<T> prevX = null;
		Node<T> curY = null;
		Node<T> prevY = null;
		if (cursor != null && cursor.data.equals(x)) {
			curX = head;
		}
		while (cursor != null && cursor.next != null) {
			if (cursor.next.data.equals(x)) {
				prevX = cursor;
				curX = cursor.next;
			}
			if (cursor.next.data.equals(y)) {
				prevY = cursor;
				curY = cursor.next;
			}
			cursor = cursor.next;
		}
		Node<T> temp = null;
		if (prevX != null)
			prevX.next = curY;
		else
			head = curY;
		prevY.next = curX;
		temp = curY.next;
		curY.next = curX.next;
		curX.next = temp;
	}

	/**
	 * Get nth node in a linked list
	 * 
	 * @param index
	 * @return
	 */
	public Node<T> get(int index) {
		int i = 0;
		Node<T> cursor = head;
		while (cursor != null && i < index) {
			cursor = cursor.next;
			i++;
		}
		return cursor;
	}

	/**
	 * Get subList of a given list for the given index range
	 * 
	 * @param startIndex
	 * @param endIndex
	 * @param list
	 * @return instance of SinglyLL
	 */
	public SinglyLL<T> subList(int startIndex, int endIndex, SinglyLL<T> list) {
		int i = 0;
		SinglyLL<T> subLL = new SinglyLL<>();
		Node<T> cursor = list.head;
		while (cursor != null && startIndex >= 0 && i <= endIndex && endIndex <= list.size - 1) {
			if (i >= startIndex)
				subLL.add(cursor.data);
			cursor = cursor.next;
			i++;
		}
		return subLL;
	}

	/**
	 * Sorts the current object of SinglyLL class using merge sort
	 */
	public Node<T> mergeSort() {
		return split(this);
	}

	/**
	 * Merge Sort Part I - split the list into smallest left and right list
	 * 
	 * @param list
	 * @return instance of Node class
	 */
	private Node<T> split(SinglyLL<T> list) {
		if (list.head == null || list.size == 1)
			return list.head;
		int midIndex = list.size / 2;
		SinglyLL<T> leftHalfList = subList(0, midIndex - 1, list);
		// System.out.println("LEFT PART ::: " + leftHalfList);
		SinglyLL<T> rightHalfList = subList(midIndex, list.size - 1, list);
		// System.out.println("RIGHT PART ::: " + rightHalfList);

		leftHalfList.head = split(leftHalfList);
		rightHalfList.head = split(rightHalfList);

		return merge(leftHalfList, rightHalfList);
	}

	/**
	 * Merge Sort Part II - Merge the left and right part while sorting them in
	 * order
	 * 
	 * @param leftHalfList
	 * @param rightHalfList
	 * @return
	 */
	private Node<T> merge(SinglyLL<T> leftHalfList, SinglyLL<T> rightHalfList) {
		SinglyLL<T> sortedList = new SinglyLL<>();
		Node<T> sortedListCursor = null;
		Node<T> leftCursor = leftHalfList.head;
		Node<T> rightCursor = rightHalfList.head;
		if (leftHalfList.head != null && rightHalfList.head != null
				&& leftHalfList.head.data.compareTo(rightHalfList.head.data) < 0) {
			sortedList.head = leftCursor;
			leftCursor = leftCursor.next;
		} else {
			sortedList.head = rightCursor;
			rightCursor = rightCursor.next;
		}
		sortedListCursor = sortedList.head;
		while (leftCursor != null && rightCursor != null) {
			if (leftCursor.data.compareTo(rightCursor.data) <= 0) {
				sortedListCursor.next = leftCursor;
				leftCursor = leftCursor.next;
			} else if (leftCursor.data.compareTo(rightCursor.data) > 0) {
				sortedListCursor.next = rightCursor;
				rightCursor = rightCursor.next;
			}
			sortedListCursor = sortedListCursor.next;
		}
		if (rightCursor == null)
			sortedListCursor.next = leftCursor;
		if (leftCursor == null)
			sortedListCursor.next = rightCursor;
		return sortedList.head;
	}

	/**
	 * Get middle element of a linked list
	 * 
	 * @return instance of Node class
	 */
	public Node<T> getMiddleNode() {
		Node<T> slowCursor = head;
		Node<T> fastCursor = head;

		while (fastCursor != null && fastCursor.next != null) {
			fastCursor = fastCursor.next.next;
			slowCursor = slowCursor.next;
		}

		return slowCursor;
	}

	/**
	 * Delete a linked list
	 */
	public void clearList() {
		head = null;
	}

	/**
	 * Reverses the current linked list
	 */
	public void reverse() {
		Node<T> cursor = head;
		Node<T> temp = null;
		Node<T> previous = null;
		Node<T> tail = null;
		while (cursor != null) {
			temp = cursor.next;
			cursor.next = previous;
			previous = cursor;
			if (temp == null)
				tail = cursor;
			cursor = temp;
		}
		head = tail;
	}

	/**
	 * Check if a loop is present in a list or not
	 * 
	 * @return
	 */
	public boolean isLoopPresent() {
		Node<T> fastCursor = head;
		Node<T> slowCursor = head;

		while (fastCursor != null && fastCursor.next != null) {
			slowCursor = slowCursor.next;
			fastCursor = fastCursor.next.next;
			if (slowCursor == fastCursor)
				return true;
		}

		return false;
	}

	public int loopLength() {
		Node<T> fastCursor = head;
		Node<T> slowCursor = head;

		int count = 1;
		while (fastCursor != null && fastCursor.next != null) {
			slowCursor = slowCursor.next;
			fastCursor = fastCursor.next.next;
			if (slowCursor == fastCursor) {
				slowCursor = slowCursor.next;
				while (slowCursor != fastCursor) {
					slowCursor = slowCursor.next;
					count++;
				}
				break;
			}
		}

		return count;
	}

	/**
	 * Prints a list in reverse order.
	 * 
	 * @param node
	 */
	public Node<T> recursiveReverse(Node<T> node) {
		if (node.next == null) {
			head = node;
			return node;
		}
		Node<T> xyz = recursiveReverse(node.next);
		xyz.next = node;
		System.out.print(node.data + "\t");
		return xyz.next;
	}

	/**
	 * Insert the given node at given index of the start node
	 * 
	 * @param index
	 * @param startNode
	 * @param node
	 */
	public Node<T> insertAt(int index, Node<T> startNode, Node<T> node) {
		int i = 0;
		Node<T> cursor = startNode;
		Node<T> prev = null;
		while (cursor != null && i < index) {
			prev = cursor;
			cursor = cursor.next;
			i++;
		}
		if (i == index) {
			prev.next = node;
			node.next = cursor.next;
		} else {
			throw new IndexOutOfBoundsException();
		}

		return startNode;
	}

	/**
	 * Get the length of linked list from given node
	 * 
	 * @param node
	 * @return
	 */
	public int length(Node<T> node) {
		if (node == null)
			return 0;
		int i = 1 + length(node.next);
		return i;
	}

	/**
	 * Sort a given list using Quick Sort algorithm
	 * 
	 * @param startIndex
	 *            : start index of the list to be sorted
	 * @param endIndex
	 *            : end index of the list to be sorted
	 * @param list
	 *            : list that needs to be sorted
	 */
	public void quickSort(int startIndex, int endIndex, SinglyLL<T> list) {
		if (startIndex >= endIndex)
			return;
		int pivot = partition(list, startIndex, endIndex);
		quickSort(startIndex, pivot - 1, list);
		quickSort(pivot + 1, endIndex, list);
		return;
	}

	/**
	 * Partition the list based quick sort partition algorithm and return the
	 * pivot index
	 * 
	 * @param list
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	private int partition(SinglyLL<T> list, int startIndex, int endIndex) {
		int pivotIndex = startIndex;
		Node<T> pivot = list.get(endIndex);
		Node<T> cursor = list.get(startIndex);
		int position = startIndex;
		while (cursor != null && position <= endIndex) {
			if (pivot.data.compareTo(cursor.data) >= 0) {
				list.swapNodes(pivotIndex, position);
				pivotIndex++;
				cursor = list.get(position).next;
			} else
				cursor = cursor.next;
			position++;
		}
		return pivotIndex - 1;
	}

	/**
	 * Sort a given list using Quick Sort algorithm using comparator
	 * 
	 * @param startIndex
	 *            : start index of the list to be sorted
	 * @param endIndex
	 *            : end index of the list to be sorted
	 * @param list
	 *            : list that needs to be sorted
	 */
	public void quickSort(int startIndex, int endIndex, SinglyLL<T> list, Comparator<T> comparator) {
		if (startIndex >= endIndex)
			return;
		int pivot = partition(list, startIndex, endIndex, comparator);
		quickSort(startIndex, pivot - 1, list);
		quickSort(pivot + 1, endIndex, list);
		return;
	}

	/**
	 * Partition the list based quick sort partition algorithm and return the
	 * pivot index
	 * 
	 * @param list
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	private int partition(SinglyLL<T> list, int startIndex, int endIndex, Comparator<T> comparator) {
		int pivotIndex = startIndex;
		Node<T> pivot = list.get(endIndex);
		Node<T> cursor = list.get(startIndex);
		int position = startIndex;
		while (cursor != null && position <= endIndex) {
			if (comparator.compare(pivot.data, cursor.data) >= 0) {
				list.swapNodes(pivotIndex, position);
				pivotIndex++;
				cursor = list.get(position).next;
			} else
				cursor = cursor.next;
			position++;
		}
		return pivotIndex - 1;
	}

	/**
	 * Check if a list is palindrome or not
	 */
	public boolean isPalindrome(SinglyLL<T> list) {
		Stack<Node<T>> stack = new Stack<>();
		Node<T> cursor = list.head;
		while (cursor != null) {
			stack.push(cursor);
			cursor = cursor.next;
		}

		cursor = list.head;
		while (cursor != null) {
			if (cursor.data != stack.pop().data)
				return false;
			cursor = cursor.next;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SinglyLL [head=" + head + "]";
	}
}