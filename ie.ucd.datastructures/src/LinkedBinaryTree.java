import java.util.ArrayList;



/**
 * Concrete implementation of a binary tree using a node-based, linked
 * structure.
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    static java.util.Random rnd = new java.util.Random();
    /**
     * The root of the binary tree
     */
    protected Node<E> root = null; // root of the tree

    // LinkedBinaryTree instance variables
    /**
     * The number of nodes in the binary tree
     */
    private int size = 0; // number of nodes in the tree

    /**
     * Constructs an empty binary tree.
     */
    public LinkedBinaryTree() {
    } // constructs an empty binary tree

    // constructor


    public static void main(String[] args) {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<Integer>();


		  // Direct construction of Tree Position<Integer> root = bt.addRoot(12);
		  Position<Integer> p1 = bt.addLeft(bt.root, 25); Position<Integer> p2 =
		  bt.addRight(bt.root, 31);

		  Position<Integer> p3 = bt.addLeft(p1, 58); bt.addRight(p1, 36);

		  Position<Integer> p5 = bt.addLeft(p2, 42); bt.addRight(p2, 90);

		  Position<Integer> p4 = bt.addLeft(p3, 62); bt.addRight(p3, 75);


		  // Can you write a level order constructor?
		// Level order construction
		// Integer[] arr = {12, 25, 31, 58, 36, 42, 90, 62, 75};
		// bt.createLevelOrder(arr);

		System.out.println("bt inorder: " + bt.size() + " " + bt.inorder());
		System.out.println("bt preorder: " + bt.size() + " " + bt.preorder());
		System.out.println("bt preorder: " + bt.size() + " " + bt.postorder());

		System.out.println("bt height: " + bt.height(bt.root()));
		System.out.println("bt depth: " + bt.depth(bt.root()));

		System.out.println(bt.toString());
    }


    /**
     * Factory function to create a new node storing element e.
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    /**
     * Verifies that a Position belongs to the appropriate class, and is not one
     * that has been previously removed. Note that our current implementation does
     * not actually verify that the position belongs to this particular list
     * instance.
     *
     * @param p a Position (that should belong to this tree)
     * @return the underlying Node instance for the position
     * @throws IllegalArgumentException if an invalid position is detected
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p; // safe cast
        if (node.getParent() == node) // our convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    /**
     * Returns the number of nodes in the tree.
     *
     * @return number of nodes in the tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the root Position of the tree (or null if tree is empty).
     *
     * @return root Position of the tree (or null if tree is empty)
     */
    @Override
    public Position<E> root() {
        return root;
    }

    /**
     * Returns the Position of p's parent (or null if p is root).
     *
     * @param p A valid Position within the tree
     * @return Position of p's parent (or null if p is root)
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
    	Node<E> node = validate(p); //verify that the node in this position p actually belongs to the tree
    	return node.getParent();
    }

    /**
     * Returns the Position of p's left child (or null if no child exists).
     *
     * @param p A valid Position within the tree
     * @return the Position of the left child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
    	Node<E> node = validate(p); //verify that the node in this position p actually belongs to the tree
		return node.getLeft();
    }

    /**
     * Returns the Position of p's right child (or null if no child exists).
     *
     * @param p A valid Position within the tree
     * @return the Position of the right child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
    	Node<E> node = validate(p); //verify that the node in this position p actually belongs to the tree
		return node.getRight();
    }

    /**
     * Places element e at the root of an empty tree and returns its new Position.
     *
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalStateException if the tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (size() != 0) {
        	throw new IllegalStateException("Sorry, unfortunately the tree is not empty.");
        }
    	root = createNode(e, null, null, null);
        size++; 
		return root;
    }


    /**
     * Creates a new left child of Position p storing element e and returns its
     * Position.
     *
     * @param p the Position to the left of which the new element is inserted
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     * @throws IllegalArgumentException if p already has a left child
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
    	Node<E> parentOfP = validate(p);
    	if (parentOfP == null) {
    		throw new IllegalArgumentException("Sorry, cannot add a left node here");
    	}
    	parentOfP.setLeft(createNode(e, parentOfP, null, null));
    	size++; 
    	return createNode(e, parentOfP, null, null);
    }

    /**
     * Creates a new right child of Position p storing element e and returns its
     * Position.
     *
     * @param p the Position to the right of which the new element is inserted
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     * @throws IllegalArgumentException if p already has a right child
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
    	Node<E> parentOfP = validate(p);
    	if (parentOfP == null) {
    		throw new IllegalArgumentException("Sorry, cannot add a right node here");
    	}
    	parentOfP.setRight(createNode(e, parentOfP, null, null));
    	size++; 
    	return createNode(e, parentOfP, null, null);
    }

    /**
     * Replaces the element at Position p with element e and returns the replaced
     * element.
     *
     * @param p the relevant Position
     * @param e the new element
     * @return the replaced element
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> toReplace = validate(p);
		E elementToReplace = toReplace.getElement();
		toReplace.setElement(e); //replace the element in the right node
		return elementToReplace;
    }

    /**
     * Attaches trees t1 and t2, respectively, as the left and right subtree of the
     * leaf Position p. As a side effect, t1 and t2 are set to empty trees.
     *
     * @param p  a leaf of the tree
     * @param t1 an independent tree whose structure becomes the left child of p
     * @param t2 an independent tree whose structure becomes the right child of p
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     * @throws IllegalArgumentException if p is not a leaf
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        // TODO
    }

    /**
     * Removes the node at Position p and replaces it with its child, if any.
     *
     * @param p the relevant Position
     * @return element that was removed
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     * @throws IllegalArgumentException if p has two children.
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
    	Node<E> toRemove = validate(p);
    	E elementToRemove = toRemove.getElement();
    	
    	if (numChildren(p) > 1) {
    		throw new IllegalArgumentException("Sorry, the node to remove has two children");
    	}
    	
    	//Setting the child's node as either the right child or the left child - whichever is not null
    	Node<E> child = new Node<E>(null, null, null, null); 
    	if (toRemove.getLeft() != null) {
    		child = toRemove.getLeft();
    	}
    	else if (toRemove.getRight() != null) {
    		child = toRemove.getRight();
    	}
    	
    	if (toRemove == root) { //if the node to be removed is the root node, which does not have a parent 
    		root = child; 
    	}
    	else if (child.getElement() != null) {
    		child.setParent(toRemove.getParent()); //bypass the node to be removed
    	}
    	else if (child.getElement() == null) {
    		Node<E> parent = toRemove.getParent();
    		if (toRemove == parent.getLeft()) {
    			parent.setLeft(child);
    		}
    		else if (toRemove == parent.getRight()) {
    			parent.setRight(child);
    		}
    	}
    	size--; 
    	
    	return elementToRemove;
    }

    public String toString() {
    	// you can use either the StringBuilder or ArrayList...
       // StringBuilder sb = new StringBuilder();
        ArrayList<E> buf = new ArrayList<>();
        //sb.append("[");
        for (Position<E> p : positions()) {
            //sb.append(p.getElement());
            //sb.append(", ");
            buf.add(p.getElement());
        }
        //sb.append("]");
        //return sb.toString();
        return buf.toString();
    }

    public void createLevelOrder(ArrayList<E> l) {
    	root = createLevelOrderHelper(l, root, 0);
    }

    private Node<E> createLevelOrderHelper(ArrayList<E> l, Node<E> p, int i) {
		Node<E> currentNode = createNode(l.get(0), null, null, null);
		root = currentNode; 
		
		//TO IMPLEMENT
    	for (E element : l ) {
			
		}
    	
    	return root; 
    }
 
    public void createLevelOrder(E[] arr) {
        root = createLevelOrderHelper(arr, root, 0);
    }

    private Node<E> createLevelOrderHelper(E[] arr, Node<E> p, int i) {
        //TO IMPLEMENT
    	return root; 
    }
    
    public int countExternalRecursive() {
    	return countExternalRecursiveHelper(root);
    }
    
    /*Method counts the total number of external nodes in a tree. 
     * 
     * @param node: the node to start counting from.
     * @Return the integer count of external nodes
     */
    private int countExternalRecursiveHelper(Node<E> node) {
    	int count = 0; 
    	
    	if (isEmpty()) { //if the tree is empty, there are no external nodes 
    		count = 0; 
    	}
    	else if (node.getLeft() == null && node.getRight() == null) { //if the root has no children, the root itself in an external node
    		count = 1; 
    	}
    	else {
    		 count = countExternalRecursiveHelper(node.getLeft()) + countExternalRecursiveHelper(node.getRight()); //otherwise, count the external nodes on the left and on the right
    	}
    	
    	return count; 
    }
    
    public int countLeftExternal() {
    	return countLeftExternalHelper(root);
    }
    	
    /*Method counts the number of external nodes on the left side of the tree only. 
     * 
     * @param node: the node to start counting from.
     * @Return the integer count of external nodes
     */
     private int countLeftExternalHelper(Node<E> node) {
    	int count = 0; 
    	
    	if (isEmpty()) { //if the tree is empty, there are no external nodes 
    		count = 0; 
    	}
    	else if (node.getLeft() == null) { //if the root has no left child, the root itself is a left external node
    		count = 1; 
    	}
    	else {
    		 count = countLeftExternalHelper(node.getLeft()); //otherwise, count the external nodes on the left and on the right
    	}
    	
    	return count;
    }



    /**
     * Nested static class for a binary tree node.
     */
    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> left, right, parent;
        

        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
        	this.element = element; 
        	this.parent = parent; 
        	this.left = left; 
        	this.right = right; 
        }

        /*Accessor methods*/
		@Override
		public E getElement() throws IllegalStateException {
			return element;
		}

		public Node<E> getLeft() {
			return left;
		}

		public Node<E> getRight() {
			return right;
		}

		public Node<E> getParent() {
			return parent;
		}
		
		/*Mutator methods*/
		public void setElement(E element) {
			this.element = element;
		}

		public void setLeft(Node<E> left) {
			this.left = left;
		}

		public void setRight(Node<E> right) {
			this.right = right;
		}

		public void setParent(Node<E> parent) {
			this.parent = parent;
		}
		
    }
}
