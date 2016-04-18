package custom.collection;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class HierarchicalLinkedList<E> extends AbstractSequentialList<E>
		implements List<E>, Deque<E>, Cloneable, Serializable {
	private transient Entry<E> header = new Entry<E>(null, null, null);
	private transient int size = 0;

	// constructs an empty list
	public HierarchicalLinkedList() {
		header.nextX = header.nextY = header;
	}

	// adds a new element in vertical direction
	public Entry<E> addVertical(E e) {
		if (e == null)
			throw new NullPointerException("Element is null");
		Entry<E> entry = new Entry<E>(e, null, null);
		entry.nextY = this.header;
		header = entry;
		return entry;
	}

	// adds a new element in horizontal direction
	public Entry<E> addHorizontal(E e) {
		if (e == null)
			throw new NullPointerException("Element is null");
		Entry<E> entry = new Entry<E>(e, null, null);
		entry.nextX = this.header;
		header = entry;
		return entry;
	}

	@Override
	public String toString() {
		return this.header.toString();
	}

	private static class Entry<E> {
		E element;
		Entry<E> nextX;
		Entry<E> nextY;

		Entry(E element, Entry<E> next, Entry<E> nextY) {
			this.element = element;
			this.nextX = next;
			this.nextY = nextY;
		}

		@Override
		public String toString() {
			String str = "";
			str += "Entry [element=" + element != null ? element.toString()
					: null + ", nextX=" + nextX != null ? nextX.toString()
							: null + ", nextY=" + nextY != null ? nextY
									.toString() : null + "]";
			return str;
		}

	}

	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean offerFirst(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offerLast(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pollFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pollLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peekFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peekLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(E e) {
		// TODO Auto-generated method stub

	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
