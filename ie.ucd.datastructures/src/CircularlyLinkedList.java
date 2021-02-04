import java.util.Iterator;
import java.util.NoSuchElementException;


public class CircularlyLinkedList<E> implements List<E> {
    //---------------- nested Node class ----------------
    /**
     * Singly linked node, which stores a reference to its element and
     * to the subsequent node in the list.
     */
    private static class Node<E> {
    	private E element; //reference to the element stored at this node
		
		private Node<E> next; // reference to the subsequent node in the list
		
		/* Constructor --> creates a node with a given element and the next node.
		 * @param element: the element to be stored
		 * @param next: reference to a node that should follow the new node. 
		 */
		public Node(E element, Node<E> next) {
			this.element = element; 
			this.next = next; 
		}
		
		//Accessor methods
		public E getElement() {
			return element; 
		}
		
		public Node<E> getNext() {
			return next;  
		}
		
		//Modifier methods
		public void setNext(Node<E> node) {
			next = node; 
		}
		
		public void setElement(E element) {
			this.element = element; 
		}
    } //----------- end of nested Node class -----------

    // instance variables of the CircularlyLinkedList
    /** The designated cursor of the list */
    private Node<E> tail = null;                 
    private Node<E> head = null; 

    /** Number of nodes in the list */
    private int size = 0;                         // number of nodes in the list

    /** Constructs an initially empty list. */
    public CircularlyLinkedList() { // constructs an initially empty list
    	tail = new Node<E>(null, null);
    	head = new Node<E>(null, null);
    	tail.setNext(head);
    	head.setNext(tail);
    }            

    // access methods
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
    public E get(int i) throws IndexOutOfBoundsException {
    	Node<E> node = head; 
		for(int k = 0; k<i; k++) {
			node = node.getNext();
		}
		return node.getElement();
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
    	Node<E> node = head; 
        for (int k =0; k<i; k++) {
        	node = node.getNext(); 
        }
        E temp = node.getElement();
        node.setElement(e);
        return temp; 
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
    	if (isEmpty() && i == 0) {
    		addFirst(e);
    	}
    	else {
    		Node<E> before = head;
    		for (int k=0; k<i-1; k++) {
    			before = before.getNext();
    		}
    		Node<E> after = before.getNext();
    		
    	    Node<E> node = new Node<E>(e, null);
    	    node.setNext(after);
    	    before.setNext(node);
    	    size++;
    	}
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
    	if (isEmpty()) {
			return null; 
		}
        Node<E> node = head;
        for(int k = 0; k < i-1; k++){
            node = node.getNext();
        }
        node.setNext(node.getNext().getNext());
        size--; 
        return node.getNext().getElement(); 
    }

	@Override
    public Iterator<E> iterator() {
        return new CircularlyLinkedListIterator<E>();
    }

    /**
     * Returns (but does not remove) the first element of the list
     * @return element at the front of the list (or null if empty)
     */
    public E first() {             // returns (but does not remove) the first element
        return tail.getNext().getElement();
    }

    /**
     * Returns (but does not remove) the last element of the list
     * @return element at the back of the list (or null if empty)
     */
    public E last() {              // returns (but does not remove) the last element
        return tail.getElement();
    }

    // update methods
    /**
     * Rotate the first element to the back of the list.
     */
    public void rotate() {         // rotate the first element to the back of the list
    	if(isEmpty() || size()==1) { //Nothing to rotate
			return;
		}
    	else {
    		tail.setNext(this.head);
    		tail = tail.getNext();
		
    		head = tail.getNext();
    	}
    }

    /**
     * Adds an element to the front of the list.
     * @param e  the new element to add
     */
    public void addFirst(E e) {                // adds element e to the front of the list
        Node<E> node = new Node<E>(e, null);
    	if (isEmpty()) {
    		head = node; 
    		tail = node; 
    	}
    	else {
    		Node<E> temp = head; 
    		node.setNext(temp);
    		head = node; 
    		tail.setNext(head);
    	}
    	size++;
    }

    /**
     * Adds an element to the end of the list.
     * @param e  the new element to add
     */
    public void addLast(E e) {                 // adds element e to the end of the list
        if (isEmpty()) {
        	addFirst(e);
        }
        else {
        	Node<E> node = new Node<E>(e, null);
        	tail.setNext(node);
        	tail = node; 
        	tail.setNext(head);
        	size++;
        }
    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {                   // removes and returns the first element
        if (isEmpty()) {
        	return null;
        }
        if (size() == 1) {
        	head.setElement(null);
        	tail.setElement(null);
        	size--; 
        	return head.getElement();
        }
        else {
        	Node<E> second = head.getNext();
        	tail.setNext(second);
        	second.setNext(second.getNext());
        	head = second;
        	return second.getElement();
        }
    }

    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
    	if (isEmpty()) {
			return "[]";
		}
    	String output = "[";
		
    	Node<E> node = head; 
		for (int i = 0; i<this.size(); i++) {
			output = output + node.getElement() + ", "; 
			node = node.getNext(); 
		}
		output = output.substring(0, output.length()-2) + "]";
		return output;
    }


    public static void main(String [] args) {
        //ArrayList<String> all;
        //LinkedList<String> ll;
        CircularlyLinkedList<String> cll = new CircularlyLinkedList<>();

        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String s : alphabet) {
            cll.addFirst(s);
            cll.addLast(s);
        }
        System.out.println(cll.toString());

        cll.rotate();
        cll.rotate();

        System.out.println(cll);
        
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
  		ll.addFirst(0);
  		ll.addFirst(1);
  		ll.addFirst(3);
  		ll.addFirst(4);
  		ll.addFirst(5);
  		ll.add(3, 2);
  		System.out.println(ll);
  		
  		ll.addFirst(-100);
  		ll.addLast(100);
  		System.out.println(ll);
  		
  		ll.removeFirst();
  		ll.removeLast();
  		System.out.println(ll);
  		
  		ll.remove(2); //removes the item at the specified index
  		System.out.println(ll);
  		
  		ll.removeFirst(); 
  		System.out.println(ll);
  		
  		ll.removeLast(); 
  		System.out.println(ll);
  		
  		ll.removeFirst();
  		System.out.println(ll);
  		
  		ll.addFirst(9999);
  		ll.addFirst(8888);
  		ll.addFirst(7777);
  		System.out.println(ll);
  		System.out.println(ll.first());
  		System.out.println(ll.last());
  		
  		System.out.println(ll.get(0));
  		System.out.println(ll.get(1));
  		System.out.println(ll.get(2));
  		System.out.println(ll);    
    }
    
    /*
	 * Inner CircularlyLinkedListIterator class
	 */
	public class CircularlyLinkedListIterator<E> implements Iterator<E> {
		private Node<E> currentNode; 

			@SuppressWarnings("unchecked")
			public CircularlyLinkedListIterator() { 
				super(); 
				this.currentNode = (Node<E>) head; 
			}

			@Override
			public boolean hasNext() {
				if (currentNode != head)
		            return true;
		        else
		            return false;
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
			
		}
	//--------------End of nested Iterator class------------------------
}
