

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * An implementation of a priority queue using an array-based heap. 
 * @author: Noemi Banal 
 */

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

	protected ArrayList<Entry<K, V>> heap = new ArrayList<>();
	protected Comparator<K> comparator; 
	
	/* Static inner class PQEntry implements the Entry interface. 
	 * PQEntry is a utility class to hold and access key, value pairs. 
	 */
	protected static class PQEntry<K, V> implements Entry<K, V> {
		protected V value; 
		protected K key; 
		
		/*Constructor*/
		public PQEntry(K key, V value) {
			this.key = key; 
			this.value = value; 
		}
		
		/*Accessor methods for instance variables*/
		@Override
		public K getKey() {
			return key; 
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public String toString() {
			return "PQEntry [value=" + value + ", key=" + key + "]";
		}
	}
	
	/**
	 * Creates an empty priority queue based on the natural ordering of its keys.
	 */
	public HeapPriorityQueue() {
		super();
		//initialise the heap and the comparator for the keys.
		heap = new ArrayList<Entry<K, V>>(); 
		comparator = new DefaultComparator<K>(); 
	}

	/**
	 * Creates an empty priority queue using the given comparator to order keys.
	 * 
	 * @param comp comparator defining the order of keys in the priority queue
	 */
	public HeapPriorityQueue(Comparator<K> comp) {
		super(comp);
		this.comparator = comp; //set the given comparator as the instance comparator
		heap = new ArrayList<Entry<K, V>>(); //initialise the heap
	}

	/**
	 * Creates a priority queue initialized with the respective key-value pairs. The
	 * two arrays given will be paired element-by-element. They are presumed to have
	 * the same length. (If not, entries will be created only up to the length of
	 * the shorter of the arrays)
	 * 
	 * @param keys   an array of the initial keys for the priority queue
	 * @param values an array of the initial values for the priority queue
	 */
	public HeapPriorityQueue(K[] keys, V[] values) {
		 super();
		    for (int i = 0; i < keys.length; i++) {
		      heap.add((new PQEntry<>(keys[i], values[i])));
		    }
		    heapify();
	}

	// protected utilities
	protected int parent(int j) {
		return (int) Math.floor((j-1)/2); //return the index of the parent of a given element
	}

	protected int left(int j) {
		return 2*j+1; //returns the index of the left element
	}

	protected int right(int j) {
		return 2*j+2; //returns the index of the right element
	}

	protected boolean hasLeft(int j) {
		return left(j) > 0 && left(j)<heap.size();
	}

	protected boolean hasRight(int j) {
		return right(j) > 0 && right(j)<heap.size();
	}
	
	protected boolean isRoot(int j) {
		return j == 0; 
	}
	
	protected boolean isInternal(int j) {
		return hasLeft(j) && hasRight(j); 
	}

	/** Exchanges the entries at indices i and j of the array list. */
	protected void swap(int i, int j) {
		Entry<K, V> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
		return;
	}

	/**
	 * Moves the entry at index j higher, if necessary, to restore the heap
	 * property.
	 */
	protected void upheap(int j) {
		while (!isRoot(j)) {
			int parent = parent(j); 
			
			//compare the keys to decide whether it is necessary to continue
			if(comparator.compare(heap.get(parent).getKey(), heap.get(j).getKey()) <=0) {
				break; 
			}
			swap(parent, j); 
			j = parent; 
		}
	}

	/**
	 * Moves the entry at index j lower, if necessary, to restore the heap property.
	 */
	protected void downheap(int j) {
		while (isInternal(j)) {
			int smallerChild; 
			
		    //find the position of the smaller child
			if (!hasRight(j)) {
				smallerChild = left(j); //if there is no right child, set the smaller child as the left one
		    }
			else if (comparator.compare(heap.get(left(j)).getKey(), heap.get(right(j)).getKey()) <= 0) {
				smallerChild = left(j);
			}
			else {
				smallerChild = right(j);
			}
			
			//compare the keys to check whether any swapping is necessary
			if (comparator.compare(heap.get(smallerChild).getKey(), heap.get(j).getKey()) < 0) {
				swap(j, smallerChild);
				j = smallerChild; 
			}
			else {
				break; 
			}
			
		}
	}

	/** Performs a bottom-up construction of the heap in linear time. */
	protected void heapify() {
		int index = parent(size()-1);
		for (int i = index; i>=0; i--) {
			downheap(i);
		}
	}

	// public methods

	/**
	 * Returns the number of items in the priority queue.
	 * 
	 * @return number of items
	 */
	@Override
	public int size() {
		return heap.size();
	}

	/**
	 * Returns (but does not remove) an entry with minimal key.
	 * 
	 * @return entry having a minimal key (or null if empty)
	 */
	@Override
	public Entry<K, V> min() {
		if (isEmpty()) {
			return null; 
		}
		return heap.get(0);
	}

	/**
	 * Inserts a key-value pair and return the entry created.
	 * 
	 * @param key   the key of the new entry
	 * @param value the associated value of the new entry
	 * @return the entry storing the new key-value pair
	 * @throws IllegalArgumentException if the key is unacceptable for this queue
	 */
	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key); //check whether the key is valid
		PQEntry<K, V> newEntry = new PQEntry(key, value); 
		heap.add(newEntry);
		upheap(size()-1); //upheap if necessary to maintain a valid heap
		return newEntry; 
	}

	/**
	 * Removes and returns an entry with minimal key.
	 * 
	 * @return the removed entry (or null if empty)
	 */
	@Override
	public Entry<K, V> removeMin() {
		if (isEmpty()) {
			return null; 
		}
		
		PQEntry<K, V> minEntry = (PQEntry<K, V>) heap.get(0); //get the root
		if (size() == 1) {
			heap.remove(0); 
		}
		else {
			swap(0, heap.size()); 
			heap.remove(heap.size()-1); 
			downheap(0); 
		}
		
		return minEntry;  
	}
	
	public String toString() {
		return heap.toString();
	}
	

	/** Used for debugging purposes only */
	private void sanityCheck() {
		for (int j = 0; j < heap.size(); j++) {
			int left = left(j);
			int right = right(j);
			//System.out.println("-> " +left + ", " + j + ", " + right);
			Entry<K, V> e_left, e_right;
			e_left = left < heap.size() ? heap.get(left) : null;
			e_right = right < heap.size() ? heap.get(right) : null;
			if (left < heap.size() && compare(heap.get(left), heap.get(j)) < 0) {
				System.out.println("Invalid left child relationship");
				System.out.println("=> " + e_left + ", " + heap.get(j) + ", " + e_right);
			}
			if (right < heap.size() && compare(heap.get(right), heap.get(j)) < 0) {
				System.out.println("Invalid right child relationship");
				System.out.println("=> " + e_left + ", " + heap.get(j) + ", " + e_right);
			}
		}
	}

	public static <T> String toBinaryTreeString(PriorityQueue<T> pq) {
		LinkedBinaryTree<T> bt = new LinkedBinaryTree<>();
		bt.createLevelOrder(new ArrayList<T>(pq));
		BinaryTreePrinter<T> btp = new BinaryTreePrinter<T>(bt);
		return btp.print();
	}

	
	public static void main(String [] args) {
		//HeapPriorityQueue<Integer, Integer> pq = new HeapPriorityQueue<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new DefaultComparator());
		//Integer [] rands = new Integer[]{44,17,88,8,32,65,97,28,54,82,93,21,29,76,68,80};
		Integer[] rands = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};
		
		for(Integer i : rands) {
			pq.add(i);
			System.out.println(pq.toString());
			System.out.println(toBinaryTreeString(pq));
		}
		
		pq.add(34);
		System.out.println(toBinaryTreeString(pq));
	}

	
}
