/* Java implementation of a Buonded Stack. A Bounded Stack has a parameter, maxSize, which sets
 * the maximum capacity on creation. 
 */
public class BoundedStack<E> implements Stack<E>{
	private SinglyLinkedList<E> list = new SinglyLinkedList<E>();
	private int maxSize; 
	private final static int DEFAULT_MAX_SIZE = 100; //maximum size if not specified upon construction of the Bounded Stack
	
	public BoundedStack(int maxSize) {
		this.maxSize = maxSize; 
	}
	
	public BoundedStack() {
		this(DEFAULT_MAX_SIZE);
	}
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void push(E e) {
		if (list.size()+1 > maxSize) {
			throw new IllegalArgumentException("Sorry, unfortunately the stack is full.");
		}
		list.addFirst(e);
	}

	@Override
	public E top() {
		return list.first();
	}

	@Override
	public E pop() {
		return list.removeFirst();
	}
	
	@Override
	public String toString() {
		return list.toString();
	}

}
