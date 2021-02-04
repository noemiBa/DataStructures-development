public class ArrayQueue<E> implements Queue<E> {
	//declaration of instance variables
	private E[] data;       //array used for the storage of data
	private int indexFront; //the index of the front element
	private int currentSize;//current number of array spaces being used
	private static final int CAPACITY = 100; //default capacity of the array if not specified
	
	public ArrayQueue() {
		this(CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		data = (E[]) new Object[capacity];
	}
	
	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public boolean isEmpty() {
		return currentSize==0;
	}

	@Override
	public void enqueue(E e) throws IllegalStateException {
		if (currentSize == data.length) {
			throw new IllegalArgumentException("Sorry, the Queue is full.");
		}
		int nextAvailable = (indexFront+currentSize)%data.length;
		data[nextAvailable] = e;
		currentSize++; 
	}

	@Override
	public E first() {
		if (isEmpty()) {
			return null; 
		}
		return data[indexFront];
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			return null; 
		}
		E toReturn = data[indexFront];
		data[indexFront] = null; 
		indexFront = (indexFront+1)%data.length;
		currentSize--; 
		return toReturn; 
	}

}