import java.util.Iterator;
import java.util.NoSuchElementException;


/* A basic doubly linked list implementation.
 * 
 * @Author: NoemiBa
 */
public class DoublyLinkedList<E> implements List<E>, Iterable<E> {

	//---------------- nested Node class ----------------
	/**
	 * Node of a doubly linked list, which stores a reference to its
	 * element and to both the previous and next node in the list.
	 */
	private static class Node<E> {
		private E element; //reference to the element stored at this node

		private Node<E> prev; //reference to the previous node in the list;

		private Node<E> next; // reference to the subsequent node in the list

		/* Constructor --> creates a node with a given element and the next node.
		 * @param element: the element to be stored
		 * @param next: reference to a node that should follow the new node. 
		 */
		public Node(E element, Node<E> prev, Node<E> next) {
			this.element = element; 
			this.prev = prev; 
			this.next = next; 
		}

		//Accessor methods
		public E getElement() {
			return element; 
		}

		public Node<E> getNext() {
			return next;  
		}

		public Node<E> getPrev() {
			return prev; 
		}

		//Modifier methods
		public void setNext(Node<E> next) {
			this.next = next; 
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev; 
		}

		public void setElement(E element) {
			this.element = element;
		}
	} //----------- end of nested Node class -----------

	// instance variables of the DoublyLinkedList
	/** Sentinel node at the beginning of the list */
	private Node<E> header;                    // header sentinel

	/** Sentinel node at the end of the list */
	private Node<E> trailer;                   // trailer sentinel

	/** Number of elements in the list (not including sentinels) */
	private int size = 0;                      // number of elements in the list

	/** Constructs a new empty list. */
	public DoublyLinkedList() { //In an empty list, the header points to the trailer and vice versa. 
		header = new Node<E>(null, null, null);
		trailer = new Node<E>(null, null, null);
		header.setNext(trailer);
		trailer.setPrev(header);
	}

	// public accessor methods

	public Node<E> getHead() {
		if (isEmpty()) {
			return null; 
		}
		return header.getNext();
	}


	public Node<E> getTail() {
		if (isEmpty()) {
			return null; 
		}
		return trailer.getPrev();
	}

	/**
	 * Returns the number of elements in the linked list.
	 * @return number of elements in the linked list
	 */
	public int size() { 
		return size; 
	}

	/**
	 * Tests whether the linked list is empty.
	 * @return true if the linked list is empty, false otherwise
	 */
	public boolean isEmpty() { 
		return size == 0; 
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		Node<E> node = header.getNext(); 
		for(int k = 0; k<index; k++) {
			node = node.getNext();
		}
		return node.getElement();
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		Node<E> node = header.getNext(); 
		for (int k =0; k<i; k++) {
			node = node.getNext(); 
		}
		E temp = node.getElement();
		node.setElement(e);
		return temp; 
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		Node<E> before = header.getNext();
		for (int k=0; k<i-1; k++) {
			before = before.getNext();
		}
		Node<E> after = before.getNext();
		addBetween(e, before, after);
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		Node<E> currentNode = header;
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = 0; i <= index; i++) {
			currentNode = currentNode.next;
		}
		return remove(currentNode);
	}


	@Override
	public Iterator<E> iterator() {
		return new DoublyLinkedListIterator<E>();
	}

	/**
	 * Returns (but does not remove) the first element of the list.
	 * @return element at the front of the list (or null if empty)
	 */
	public E first() {
		if (isEmpty()) {
			return null; 
		}
		return getHead().getElement();
	}

	/**
	 * Returns (but does not remove) the last element of the list.
	 * @return element at the end of the list (or null if empty)
	 */
	public E last() {
		if (isEmpty()) {
			return null; 
		}
		return getTail().getElement();
	}

	// public update methods
	/**
	 * Adds an element to the front of the list.
	 * @param e   the new element to add
	 */
	public void addFirst(E e) {
		addBetween(e, header, header.getNext()); 
	}

	/**
	 * Adds an element to the end of the list.
	 * @param e   the new element to add
	 */
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer); 
	}

	/**
	 * Removes and returns the first element of the list.
	 * @return the removed element (or null if empty)
	 */
	public E removeFirst() {
		if (this.isEmpty()) {
			return null; 
		}
		Node<E> temp = getHead(); 
		header.setNext(getHead().getNext());
		size--;
		return temp.getElement();
	}

	/**
	 * Removes and returns the last element of the list.
	 * @return the removed element (or null if empty)
	 */
	public E removeLast() {
		if (this.isEmpty()) {
			return null; 
		}
		Node<E> temp = getTail(); 
		trailer.setPrev(getTail().getPrev());
		size--; 
		return temp.getElement(); 
	}

	// private update methods
	/**
	 * Adds an element to the linked list in between the given nodes.
	 * The given predecessor and successor should be neighboring each
	 * other prior to the call.
	 *
	 * @param prev   node just before the location where the new element is inserted
	 * @param next     node just after the location where the new element is inserted
	 */
	private void addBetween(E e, Node<E> prev, Node<E> next) {
		Node<E> node = new Node<E>(e, prev, next);
		prev.setNext(node);
		next.setPrev(node);
		size++; 
	}

	private E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--; 
		return node.getElement();
	}


	/**
	 * Produces a string representation of the contents of the list.
	 * This exists for debugging purposes only.
	 */
	public String toString() {
		String output = "[";
		if (isEmpty()) {
			return "[]";
		}
		Node<E> node = getHead(); 
		for (int i = 0; i<this.size(); i++) {
			output = output + node.getElement() + ", "; 
			node = node.getNext(); 
		}
		output = output.substring(0, output.length()-2) + "]";
		return output;
	}

	/*
	 * Inner myIterator class
	 */
	public class DoublyLinkedListIterator<E> implements Iterator<E> {
		private Node<E> currentNode; 

		@SuppressWarnings("unchecked")
		public DoublyLinkedListIterator() { 
			super(); 
			this.currentNode = (Node<E>) header.getNext(); 
		}

		@Override
		public boolean hasNext() {
			return currentNode!=trailer; 
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E node = currentNode.getElement();
			currentNode = currentNode.getNext();
			return node;
		}

	} //----------- end of DoublyLinkedListIterator class -----------
} //----------- end of DoublyLinkedList class -----------
