package assign07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

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
	 * 
	 * @param <E> the type of elements in the node
	 */
    private static class Node<E> {
        E value;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

    	/**
    	 * Creates a new node with the value given
    	 * 
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
			size++;
			return true;
		}
		return addRecursive(root, item);
	}
	
	/**
	 * Helper method for adding an item recursively to the correct place in the tree
	 * 
	 * @param node the node being looked at
	 * @param item the item to add
	 * @return true if the item was added, false if not
	 */
	private boolean addRecursive(Node<Type> node, Type item) {
		if (node.value.compareTo(item) == 0) {
			return false;
		} else if (node.value.compareTo(item) > 0) {
			if (node.left == null) {
				node.left = new Node<Type>(item);
				node.left.parent = node;
				size++;
				return true;
			}
			return addRecursive(node.left, item);
		} else {
			if (node.right == null) {
				node.right = new Node<Type>(item);
				node.right.parent = node;
				size++;
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
		int previousSize = size;
		for (Type item : items) {
			if (!this.contains(item)) {
				this.add(item);
			}
		}
		if (size > previousSize) {
			return true;
		}
		return false;	
	}

	/**
	 * Removes all items from this set. The set will be empty after this method
	 * call.
	 */
	public void clear() {
		root = null;
		size = 0;
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
		return containsRecursive(root, item);
	}
	
	/**
	 * Helper method to recursively check if an item exists in the tree
	 * 
	 * @param node the node being looked at
	 * @param item the item to find
	 * @return true if the item was found false if not
	 */
    private boolean containsRecursive(Node<Type> node, Type item) {
        if (node == null) {
            return false;
        }
        if (node.value.compareTo(item) == 0) {
            return true;
        }
        else if (node.value.compareTo(item) > 0) {
            return containsRecursive(node.left, item);
        } 
        else {
            return containsRecursive(node.right, item);
        }
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
		for (Type item : items) {
			if (!this.contains(item)) {
				return false;
			}
		}
		return true;
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
	
	/**
	 * Helper method to find the smallest value recursively
	 * 
	 * @param node the node being looked at
	 * @return the smallest item's value
	 */
	private Type firstRecursive(Node<Type> node) {
		if (node.left == null) {
			return node.value;
		}
		return firstRecursive(node.left);
	}

	/**
	 * Returns true if this set contains no items.
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the last (i.e., largest) item in this set.
	 * 
	 * @throws NoSuchElementException if the set is empty
	 */
	public Type last() throws NoSuchElementException {
		if (root == null ) {
			throw new NoSuchElementException();
		}
		return lastRecursive(root);
	}
	
	/**
	 * Helper method to find the largest value recursively
	 * 
	 * @param node the node being looked at
	 * @return the largest item's value
	 */
	private Type lastRecursive(Node<Type> node) {
		if (node.right == null) {
			return node.value;
		}
		return lastRecursive(node.right);
	}

	/**
	 * Ensures that this set does not contain the specified item.
	 * 
	 * @param item - the item whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         the input item was actually removed); otherwise, returns false
	 */
	public boolean remove(Type item) {
		if (root == null) {
			return false;
		}
		
		return removeRecursive(root, item);
	}
	
	/**
	 * Helper method to recursively remove a node from the tree
	 * 
	 * @param node the node being looked at
	 * @param item the item to remove
	 * @return true if removed false if not
	 */
	private boolean removeRecursive(Node<Type> node, Type item) {
		if (node.value.compareTo(item) == 0) {
			if (node.left == null && node.right == null) {
				size--;
				return removeLeaf(node);
			} else if (node.left != null  && node.right != null) {
				size --;
				return removeTwoChildren(node, item);
			} else {
				size--;
				return removeOneChild(node);
			}
		}  else if (node.value.compareTo(item) > 0) {
			if (node.left == null) return false;
			return removeRecursive(node.left, item);
		} else {
			if (node.right == null) return false;
			return removeRecursive(node.right, item);
		}
	}
	
	/**
	 * Removes a node that has no children
	 * 
	 * @param node the node to remove
	 * @return true once the leaf is removed
	 */
	private boolean removeLeaf(Node<Type> node) {
		node = null;
		return true;
	}
	
	/**
	 * Removes a node that has only one child
	 * 
	 * @param node the node to remove
	 * @return true once it is removed
	 */
	private boolean removeOneChild(Node<Type> node) {
		if (node.left == null) {
			if (node.value.equals(root.value)) {
				root = node.right;
			} else {
				node.parent.right = node.right;
			}
			return true;
		} else {
			if (node.value.equals(root.value)) {
				root = node.left;
			} else {
				node.parent.left = node.left;
			}
			return true;
		}
	}
	
	/**
	 * Removes a node that has two children by replacing it with its successor
	 * 
	 * @param node the node to remove
	 * @param item the value of the node being removed
	 * @return true once it is removed
	 */
	private boolean removeTwoChildren(Node<Type> node, Type item) {
		
		if (!this.contains(item)) {
			return false;
		} else {
			Node<Type> successor = findSuccessor(node);
			
			node.value = successor.value;
			
			if (successor.left != null || successor.right != null) {
				removeOneChild(successor);
				return true;
			} else {
				removeLeaf(successor);
				return true;
			}
		}
	}
	
	/**
	 * Finds the successor of a node
	 * 
	 * @param node the node whose successor should be found
	 * @return the successor node
	 */
	private Node<Type> findSuccessor(Node<Type> node) {
		Node<Type> start = node.right;
		while (start.left != null) {
			start = start.left;
		}
		return start;
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
		int formerSize = size;
		for (Type item : items) {
			remove(item);
		}
		if (size < formerSize) {
			return true;
		}
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
        ArrayList<Type> list = new ArrayList<>();
        fillInArrayListRecursive(root, list);
        return list;
	}
	
	/**
	 * Helper method to do an in order traversal to fill the list with items
	 * 
	 * @param node the current node 
	 * @param list the list to fill with the items
	 */
    private void fillInArrayListRecursive(Node<Type> node, ArrayList<Type> list) {
        if (node == null) {
            return;
        }
        fillInArrayListRecursive(node.left, list);
        list.add(node.value);
        fillInArrayListRecursive(node.right, list);
    }
}