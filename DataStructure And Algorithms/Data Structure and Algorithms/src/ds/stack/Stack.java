package ds.stack;

import java.util.LinkedList;
import java.util.List;

public class Stack<T> {
	private int top;
	private List<T> dataList;
	private int capacity;

	public Stack() {
		this.top = 0;
		this.capacity = 32;
		this.dataList = new LinkedList<>();
	}

	public void push(T data) throws Exception {
		if (dataList.size() == capacity) {
			throw new Exception("Stack is full");
		}
		dataList.add(data);
		top++;
	}

	public T pop() throws Exception {
		if (dataList.size() == 0) {
			throw new Exception("Stack is empty");
		}
		T t = dataList.remove(top - 1);
		top--;
		return t;
	}

	public T peek() throws Exception {
		if (dataList.size() == 0) {
			return null;
		}
		return dataList.get(top - 1);
	}

	@Override
	public String toString() {
		return "Stack=" + dataList ;
	}

}
