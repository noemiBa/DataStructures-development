
public class ArrayStack<E> implements Stack<E> {
	public static final int CAPACITY = 100; //the stack's capacity if not specified by the user
	private E[] data; 
	private int indexTop; //the index of the top element in the stack
	
	public ArrayStack() { //constructs an instance of the class ArrayStack using the default capacity value
		this(CAPACITY); 
	}
	
	public ArrayStack(int capacity) { //constructs an instance of the class ArrayStack using the given capacity
		data=(E[]) new Object[capacity];
	}

	@Override
	public int size() {
		return indexTop+1;
	}

	@Override
	public boolean isEmpty() {
		return indexTop==-1;
	}

	@Override
	public void push(E e) throws IllegalStateException {
		if (size()==data.length) {
			throw new IllegalStateException("Sorry, the Stack is full");
		}
		data[indexTop++] = e; 
	}

	@Override
	public E top() {
		if (isEmpty()) {
			return null; 
		}
		return data[indexTop];
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			return null; 
		}
		E toReturn = data[indexTop];
		data[indexTop] = null; 
		indexTop--;
		return toReturn; 
	}

}