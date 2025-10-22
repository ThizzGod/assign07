package assign07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class contains the methods to create and edit a binary tree data structure.
 * @param <Type> the type of element in the tree
 * 
 * @author Max Barker and Josi Gac
 * @version 10/21/25
 */
public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {
	
    private Node<Type> root;
    private int size;
	
    /**
     * Constructor for an empty tree
     */
    public BinarySearchTree() {
        root = null;
        size = 0;
    }
    
	/**
	 * Represents a single node in a tree
	 * @param <E> the type of elements in the node
	 */
    private static class Node<E> {
        E value;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

    	/**
    	 * Creates a new node with the value given
    	 * @param value the value to be stored in the node
    	 */
        Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }
    
	/**
	 * Ensures that this set contains the specified item.
	 * 
	 * @param item - the item whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         the input item was actually inserted); otherwise, returns false
	 */
	public boolean add(Type item) {
		if (root == null) {
			Node<Type> rootNode = new Node<>(item);
			root = rootNode;
			return true;
		}
		return addRecursive(root, item);
	}
	
	private boolean addRecursive(Node<Type> node, Type item) {
		if (node.value.compareTo(item) == 0) {
			return false;
		} else if (node.value.compareTo(item) < 0) {
			if (node.left == null) {
				node.left = new Node<Type>(item);
				return true;
			}
			return addRecursive(node.left, item);
		} else {
			if (node.right == null) {
				node.right = new Node<Type>(item);
				return true;
			}
			return addRecursive(node.right, item);
		}
	}

	/**
	 * Ensures that this set contains all items in the specified collection.
	 * 
	 * @param items - the collection of items whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         any item in the input collection was actually inserted); otherwise,
	 *         returns false
	 */
	public boolean addAll(Collection<? extends Type> items) {
		return false;
		
	}

	/**
	 * Removes all items from this set. The set will be empty after this method
	 * call.
	 */
	public void clear() {
		
	}

	/**
	 * Determines if there is an item in this set that is equal to the specified
	 * item.
	 * 
	 * @param item - the item sought in this set
	 * @return true if there is an item in this set that is equal to the input item;
	 *         otherwise, returns false
	 */
	public boolean contains(Type item) {
		return false;
		
	}

	/**
	 * Determines if for each item in the specified collection, there is an item in
	 * this set that is equal to it.
	 * 
	 * @param items - the collection of items sought in this set
	 * @return true if for each item in the specified collection, there is an item
	 *         in this set that is equal to it; otherwise, returns false
	 */
	public boolean containsAll(Collection<? extends Type> items) {
		return false;
		
	}

	/**
	 * Returns the first (i.e., smallest) item in this set.
	 * 
	 * @throws NoSuchElementException if the set is empty
	 */
	public Type first() throws NoSuchElementException {
		if (root == null) {
			throw new NoSuchElementException();
		}
		return firstRecursive(root);
	}
	
	private Type firstRecursive(Node<Type> node) {
		if (node.left == null) {
			return node.value;
		}
		return firstRecursive(node);
	}

	/**
	 * Returns true if this set contains no items.
	 */
	public boolean isEmpty() {
		return false;
		
	}

	/**
	 * Returns the last (i.e., largest) item in this set.
	 * 
	 * @throws NoSuchElementException if the set is empty
	 */
	public Type last() throws NoSuchElementException {
		return null;
		
	}

	/**
	 * Ensures that this set does not contain the specified item.
	 * 
	 * @param item - the item whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         the input item was actually removed); otherwise, returns false
	 */
	public boolean remove(Type item) {
		return false;
		
	}

	/**
	 * Ensures that this set does not contain any of the items in the specified
	 * collection.
	 * 
	 * @param items - the collection of items whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         any item in the input collection was actually removed); otherwise,
	 *         returns false
	 */
	public boolean removeAll(Collection<? extends Type> items) {
		return false;
		
	}

	/**
	 * Returns the number of items in this set.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns an ArrayList containing all of the items in this set, in sorted
	 * order.
	 */
	public ArrayList<Type> toArrayList() {
		return null;
		
	}
}
