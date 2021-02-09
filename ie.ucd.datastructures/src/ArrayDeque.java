/* This class implements a Double-Ended Queue using a circular array. 
 * A Deque is a queue-like data structure that supports insertion and deletion at both the front and the back of the queue
 * 
 * @Author: NoemiBa
 */
public class ArrayDeque implements Deque<Object>{

	//declaration of instance variables
	private Object[] data;       //array used for the storage of data
	private int indexFront; //the index of the front element
	private int indexRear; //the index of the rear element
	private int currentSize;//current number of array spaces being used
	private static final int CAPACITY = 100; //default capacity of the array if not specified

	public ArrayDeque() {
		this(CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public ArrayDeque(int capacity) {
		data = (Object[]) new Object[capacity];
		currentSize = 0;
		indexFront = -1; 
		indexRear = 0;
	}

	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public boolean isEmpty() {
		return indexFront == -1; 
	}

	public boolean isFull() {
		return currentSize == data.length;
	}

	@Override
	public Object first() {
		if (isEmpty()) {
			return null; 
		}
		return data[indexFront];
	}

	@Override
	public Object last() {
		if (isEmpty()) {
			return null; 
		}
		return data[indexRear];
	}

	@Override
	public void addFirst(Object e) {
		validateAdd();

		if (size() == 0) { //if the queue is empty
			setIndexFront(0);
			setIndexRear(0);
		}
		else if (indexFront == 0) { //if the front is at the first index
			setIndexFront(size()-1);
		}
		else {
			setIndexFront(indexFront-1); 
		}
		data[indexFront] = e;
		setCurrentSize(currentSize++); 
	}

	@Override
	public void addLast(Object e) {
		validateAdd();

		if (indexFront == -1) { //if the queue is empty
			this.setIndexFront(0);
			this.setIndexRear(0);
		}
		else if (indexRear == size()-1) { //if the index of the last element has reach the last available index
			setIndexRear(0);
		}
		else {
			setIndexRear(indexRear+1);
		}
		data[indexRear] = e;
		setCurrentSize(currentSize++); 
	}

	@Override
	public Object removeFirst() {
		if (isEmpty()) {
			return null; //nothing to remove
		}

		Object toReturn = data[indexFront];

		if (indexFront == indexRear) { //if the queue has only one element
			setIndexFront(-1);
			setIndexRear(-1);
		}
		else {
			if (indexFront == data.length-1) { //if the index of the front element has reached the last available index in the array
				setIndexFront(0);
			}
			else {
				setIndexFront(indexFront+1);
			}
		}
		setCurrentSize(currentSize--); 
		return toReturn; 
	}

	@Override
	public Object removeLast() {
		if (isEmpty()) {
			return null; //nothing to remove
		}
		
		Object toRemove = data[indexRear];
		
		if (indexFront == indexRear) { //if the double queue has only one element
			setIndexFront(-1);
			setIndexRear(-1);
		}
		else if (indexRear == 0) { //if the index of the rear element has reached the first index in the array.
			setIndexRear(size()-1);
		}
		else {
			setIndexRear(indexRear-1);
		}
		setCurrentSize(currentSize--); 
		return toRemove;
	}

	/* Private helper method for exception handling in the add methods.
	 */
	private void validateAdd() {
		if (isFull()) {
			throw new IllegalArgumentException("Sorry, queue is full");
		}
	}
	
	private void setIndexFront(int indexFront) {
		this.indexFront = indexFront;
	}

	private void setIndexRear(int indexRear) {
		this.indexRear = indexRear;
	}
	
	
	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}

	public static void main (String [] args) {
		//Testing code
		ArrayDeque dq = new ArrayDeque(); 
		dq.addLast(5);
		dq.addFirst(3);
		dq.addFirst(7);
		System.out.println(dq.first());
		
		dq.removeLast();
		dq.removeLast();
		dq.removeFirst();
		System.out.println(dq.isEmpty());

		dq.addFirst(6);
		System.out.println(dq.last());
	}
}
