package assign07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {
	/**
	 * Ensures that this set contains the specified item.
	 * 
	 * @param item - the item whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         the input item was actually inserted); otherwise, returns false
	 */
	public boolean add(Type item) {
		
		return false;
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
		return null;
		
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
		return 0;
		
	}

	/**
	 * Returns an ArrayList containing all of the items in this set, in sorted
	 * order.
	 */
	public ArrayList<Type> toArrayList() {
		return null;
		
	}
}
