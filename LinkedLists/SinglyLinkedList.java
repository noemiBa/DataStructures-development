
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * A basic singly linked list implementation.
 * 
 * @Author: noemiBa 
 */
public class SinglyLinkedList<E> implements Cloneable, Iterable<E>, List<E> {
    //---------------- nested Node class ----------------

    /**
     * Node of a singly linked list, which stores a reference to its
     * element and to the subsequent node in the list (or null if this
     * is the last node).
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

    // instance variables of the SinglyLinkedList
    private Node<E> head = null; // head node of the list (or null if empty)
    private Node<E> last = null; //pointer to the last element
    
    private int size = 0; // number of nodes in the list

    public SinglyLinkedList() { // constructs an initially empty list
    	if (isEmpty()) {
    		head = last; 
    	}
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
    public E get(int index) throws IndexOutOfBoundsException {
    	Node<E> node = head; 
		for(int k = 0; k<index; k++) {
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

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
    	if (isEmpty()) {
			return null; 
		}
        Node<E> node = head;
        for(int k = 0; k < index -1; k++){
            node = node.getNext();
        }
        node.setNext(node.getNext().getNext());
        size--; 
        return node.getNext().getElement(); 
    }

    /**
     * Returns (but does not remove) the first element of the list
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
    	if (isEmpty()) {
    		return null;
    	}
    	return head.getElement();
    }

    /**
     * Returns the last node of the list
     * @return last node of the list (or null if empty)
     */
    public Node<E> getLast() {
    	if (isEmpty()) {
    		return null;
    	}
    	return last; 
    }

    /**
     * Returns (but does not remove) the last element of the list.
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
    	if (isEmpty()) {
    		return null;
    	}
    	return last.getElement(); 
    }

    // update methods

    /**
     * Adds an element to the front of the list.
     *
     * @param e the new element to add
     */
    public void addFirst(E e) {
    	head = new Node<E>(e, head);
		if (this.isEmpty()) {
			last = head;
		}
		size++; 
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the new element to add
     */
    public void addLast(E e) {
    	Node<E> node = new Node<E>(e, null);
		
		while (node.getNext() != null) {
			node = node.getNext(); 
		}
		
		last.setNext(node);
		setLast(node);
		size++;
    }

    
	public void setLast(Node<E> last) {
		this.last = last;
	}

	/**
     * Removes and returns the first element of the list.
     *
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
    	if (isEmpty()) {
			return null; 
		}
		Node<E> temp = head; 
		head = head.getNext();
		size--;
		return temp.getElement();
    }
    
    /**
	 * Removes the last element from the List
	 * 
	 * @return the removed element (or null if empty)
	 */
	public E removeLast() {
		if (isEmpty()) {
			return null; 
		}
		Node<E> second_last = head; 
		while (second_last.getNext().getNext() != null) {
			second_last = second_last.getNext(); 
		}
		last = second_last; 
		second_last.setNext(null);
		size--;
	    return head.getElement(); 
	}

    @SuppressWarnings({"unchecked"})
    public boolean equals(Object o) {
    	 if (this == o) {
             return true;
          }
            if  (o instanceof SinglyLinkedList) {
             SinglyLinkedList<E> list   = (SinglyLinkedList<E>)o;
             int n = this.size();
             if (n == list.size()) {
                Node<E> node1 = this.head;
                Node<E> node2 = list.head;
                while (node1 != null) {
                    if (node1.getElement() != node2.getElement()) {
                        return false;
                    }
                    node1 = node1.getNext();
                    node2 = node2.getNext();
                }
                return true;
             }
          }

          return false;
    }

    @SuppressWarnings({"unchecked"})
    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        SinglyLinkedList<E> clone = new SinglyLinkedList<E>(); 
        Node<E> temp = head; 
        while (temp != null) {
        	clone.addLast(temp.getElement());
        	temp = temp.getNext(); 
        }
        return clone; 
    }


    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     * 
     * @return the String representation of the SinglyLinkedList object. 
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

    /*
	 * Inner myIterator class
	 */
	public class SinglyLinkedListIterator<E> implements Iterator<E> {
		private Node<E> currentNode; 

			@SuppressWarnings("unchecked")
			public SinglyLinkedListIterator() { 
				super(); 
				this.currentNode = (Node<E>) head; 
			}

			@Override
			public boolean hasNext() {
				if (currentNode != null)
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

    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator<E>();
    }

    public static void main(String[] args) {
    	//Testing code
        SinglyLinkedList<String> sll = new SinglyLinkedList<String>();

        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String s : alphabet) {
            sll.addFirst(s);
            sll.addLast(s);
        }
        System.out.println(sll);
        
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
}

