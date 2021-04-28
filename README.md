# Comp20280 Data Structures
Java programs created during the spring semester 2020/2021 for the module Comp20280. Developed using Eclipse IDE and Google Drive. 

## Getting started
### Prerequisites 
* While this repository was made using Eclipse IDE (which can be found for free [here](https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers)), you are free to use whichever IDE you are most comfortable with. 
* The classes were compiled using Java 14 - howerever, the project can be rebuilt using a different compiler by clicking Project -> Properties -> Java Compiler -> Tick "enable project specific settings" -> Change to whichever Compiler Compliance Level you desire <br/>

### Build and Run 
* In Eclipse, find the package explorer and right click. Here, click "Import".
* Click "Projects from Git (with smart import)".
* Click "Clone URL".
* Enter the repository URL found on Github, then click finish. 

## Contents overview
|  Topic # | Written Questions | Java Classes | Description |
|---| ---- | ---- | ----------- | 
| 1 | [Linked Lists](https://github.com/ucd2016comp20010/data-structures-development-noemiBa/blob/main/ie.ucd.datastructures/WrittenQuestions/LinkedLists_WrittenQuestions) | [SinglyLinkedList](/ie.ucd.datastructures/src/SinglyLinkedList.java) | A basic java implementation of a Singly Linked List data structure. |  
|   |  | [DoublyLinkedList](./comp20290_Practicals/wk2/ThreeSumB.java) | A basic java implementation of a Doubly Linked List data structure (nodes can be traversed in either direction). |
|   |  | [CircularlyLinkedList](./ie.ucd.datastructures/src/CircularlyLinkedList.java) | A basic java implementation of a Circularly Linked List data structure. |
| 2 | [Stacks and Queues](https://github.com/ucd2016comp20010/data-structures-development-noemiBa/blob/main/ie.ucd.datastructures/WrittenQuestions/StacksQueues_WrittenQuestions.pdf) | [Stack](./ie.ucd.datastructures/src/Stack.java) | An interface for a Stack ADT. |
|   |  | [Queue](./ie.ucd.datastructures/src/Queue.java) | An interface for a Queue ADT. |
|   |  | [Deque](./ie.ucd.datastructures/src/Deque.java) | An interface for a Deque ADT. |
|   |  | [ArrayStack](./ie.ucd.datastructures/src/ArrayStack.java) | Implementation of a Stack data structure with the use of an array.|
|   |  | [ArrayQueue](./ie.ucd.datastructures/src/ArrayQueue.java) | Implementation of a Queue data structure with the use of an array. |
|   |  | [LinkedStack](./ie.ucd.datastructures/src/LinkedStack.java) | Implementation of a Stack data structure with the use of a Singly Linked List. |
|   |  | [LinkedQueue](./ie.ucd.datastructures/src/LinkedQueue.java) | Implementation of a Queue data structure with the use of a Singly Linked List. |
|   |  | [ArrayDeque](./ie.ucd.datastructures/src/ArrayDeque.java) | Implementation of a Double Queue (or Deque) data structure with the use of a circular array. A Deque is a queue-like data structure that supports insertion and deletion at both the front and the back of the queue. | 
|   |  | [BoundedStack](./ie.ucd.datastructures/src/BoundedStack.java) | Implementation of a Bounded Stack data structure with the use of a Singly Linked List. A Bounded Stack has a parameter, maxSize, which sets the maximum capacity upon creation. |
|   |  | [BracketChecker](./ie.ucd.datastructures/src/BracketChecker.java) | This class uses a Stack to check whether the opening brackets and the closing brackets in a String are evenly balanced.|
| 3 | [Trees](https://github.com/ucd2016comp20010/data-structures-development-noemiBa/blob/main/ie.ucd.datastructures/WrittenQuestions/Trees%201_WrittenQuestions.pdf) | [Tree](./ie.ucd.datastructures/src/Tree.java) | An interface for a tree where nodes can have an arbitrary number of children. |  
|   |   | [Position](./ie.ucd.datastructures/src/Position.java) | An interface for a position which is an abstraction for the location at which a single element is stored in a positional container. | 
|   |   | [AbstractTree](./ie.ucd.datastructures/src/AbstractTree.java) | An abstract base class providing some functionality of the Tree interface. | 
|   |   | [BinaryTree](./ie.ucd.datastructures/src/BinaryTree.java) | An interface for a binary tree, in which each node has at most two children. | 
|   |   | [AbstractBinaryTree](./ie.ucd.datastructures/src/AbstractBinaryTree.java) | An abstract base class providing some functionality of the BinaryTree interface. | 
|   |   | [LinkedBinaryTree](./ie.ucd.datastructures/src/LinkedBinaryTree.java) | Concrete implementation of a binary tree using a node-based, linked structure. | 
|   |   | [BinaryTreePrinter](./ie.ucd.datastructures/src/BinaryTreePrinter.java) | A class to print a text representation of a Binary Tree. @author: Aonghus Lawlor. | 
| 4 | [Analysis](https://github.com/ucd2016comp20010/data-structures-development-noemiBa/blob/main/ie.ucd.datastructures/WrittenQuestions/Analysis_WrittenQuestions.pdf) | [Sorter](./ie.ucd.datastructures/src/Sorter.java) | Sorting class contains implementations of the following sorting algorithms: <br/> 1) Bubble Sort. <br/> 2) Selection Sort <br/> 3) Insertion sort|  
|   |   | [Timer](./ie.ucd.datastructures/src/Timer.java) | A simple timer class which utilises System.currentTimeMillis(). | 
| 5 | [Recursion](https://github.com/ucd2016comp20010/data-structures-development-noemiBa/blob/main/ie.ucd.datastructures/WrittenQuestions/Recursion_WrittenQuestions.pdf) | [RecursiveAlgorithms](./ie.ucd.datastructures/src/RecursiveAlgorithms.java) | Recursive Algorithms class contains implementations of the following functions: <br/> 1) IsPalindrome <br/> 2) Recursive implementation of the Collatz sequence <br/> 3) recursiveBubbleSort |  
| 6 | [PQHeaps](https://github.com/ucd2016comp20010/data-structures-development-noemiBa/blob/main/ie.ucd.datastructures/WrittenQuestions/PQHeaps_WrittenQuestions.pdf) | [PriorityQueue](./ie.ucd.datastructures/src/PriorityQueue.java) | Interface for the priority queue ADT. | 
|   |   | [Entry](./ie.ucd.datastructures/src/Entry.java) | Interface for a key-value pair. | 
|   |   | [HeapPriorityQueue](./ie.ucd.datastructures/src/HeapPriorityQueue.java) | An implementation of a priority queue using an array-based heap. | 
| 7 | Maps, Hashtables | [Map](./ie.ucd.datastructures/src/Map.java) | An interface for an associative map which binds a key uniquely to a value. This interface is a simplified version of java.util.Map. | 
|   |   | [AbstractMap](./ie.ucd.datastructures/src/AbstractMap.java) | An abstract base class to ease the implementation of the Map interface.| 
|   |   | [AbstractHashMap](./ie.ucd.datastructures/src/AbstractHashMap.java) | An abstract base class supporting Map implementations that use hash tables with MAD compression.| 
|   |   | [UnsortedTableMap](./ie.ucd.datastructures/src/UnsortedTableMap.java) | An implementation of a map using an unsorted table. |
|   |   | [ChainHashMap](./ie.ucd.datastructures/src/ChainHashMap.java) | Map implementation using hash table with separate chaining. |
|   |   | [WordCounter](./ie.ucd.datastructures/src/WordCounter.java) | Java program which uses a Chain Hash Map to count the frequency of words in a table. |
| 8 | Binary Search Trees | [SortedMap](./ie.ucd.datastructures/src/SortedMap.java) | A map interface with additional support for keys from a total ordering.| 
|   |   | [SortedMap](./ie.ucd.datastructures/src/SortedMap.java) | A map interface with additional support for keys from a total ordering.| 
|   |   | [AbstractSortedMap](./ie.ucd.datastructures/src/AbstractSortedMap.java) | An abstract base class to ease the implementation of the SortedMap interface. | 
|   |   | [TreeMap](./ie.ucd.datastructures/src/TreeMap.java) | An implementation of a sorted map using a binary search tree. | 
| 9 | AVL, Splay Trees | [AVLTreeMap](./ie.ucd.datastructures/src/AVLTreeMap.java) | An implementation of a sorted map using an AVL tree. | 
|   |   | [SplayTreeMap](./ie.ucd.datastructures/src/SplayTreeMap.java) | An implementation of a sorted map using a Splay Tree.| 


## References
* *Data Structures and Algorithms in Java*, by Micheal T. Goodrich and Roberto Tamassia.
* *Beginning Data Structures and Algorithms*, by James Cutajar.
