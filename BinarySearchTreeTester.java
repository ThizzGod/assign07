package assign07;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTester {
	BinarySearchTree<Integer> emptyTree;
	BinarySearchTree<Integer> zeroToFour;
	BinarySearchTree<Integer> tenToTwenty; 
	ArrayList<Integer> listZeroToFour;
	ArrayList<Integer> emptyList;

	@BeforeEach
	void setUp() {
		emptyTree = new BinarySearchTree<Integer>();
		zeroToFour = new BinarySearchTree<Integer>();
		tenToTwenty = new BinarySearchTree<Integer>();
		listZeroToFour = new ArrayList<Integer>();
		
		for (int i = 0; i < 5; i++) {
			zeroToFour.add(i);
		}
		
		for (int i = 10; i <= 20; i++) {
			tenToTwenty.add(i);
		}

		for (int i = 0; i < 5; i++) {
			listZeroToFour.add(i);
		}
	}

	@Test
	void testBinarySearchTreeAddNewElement() {
		assertTrue(emptyTree.add(0));
	}
	
	@Test
	void testBinarySearchAddElementExists() {
		emptyTree.add(0);
		assertFalse(emptyTree.add(0));
	}
	
	@Test
	void testElementsAreOrderedAfterAdd() {
		zeroToFour.add(-6);
		zeroToFour.add(7);
		assertEquals(-6, zeroToFour.first());
		assertEquals(7, zeroToFour.last());
	}
	
	@Test
	void testAddAllEmptyTree() {
		assertTrue(emptyTree.addAll(listZeroToFour));
	}
	
	@Test
	void testAddAllSomeItemsExist() {
		tenToTwenty.add(1);
		assertTrue(tenToTwenty.addAll(listZeroToFour));
		assertEquals(0, tenToTwenty.first());
	}
	
	@Test
	void testAddAllNoItemsExist() {
		assertTrue(tenToTwenty.addAll(listZeroToFour));
		assertEquals(0, tenToTwenty.first());
	}
	
	@Test
	void testAddAllAllItemsExist() {
		assertFalse(zeroToFour.addAll(listZeroToFour));
	}
	
	@Test
	void testAddAllInsertBetween() {
		tenToTwenty.addAll(listZeroToFour);
		tenToTwenty.add(7);
		assertEquals(0, tenToTwenty.first());
		assertEquals(20, tenToTwenty.last());
		assertTrue(tenToTwenty.contains(7));
	}
	
	@Test
	void testAddAllEmptyCollectionAdded() {
		assertFalse(zeroToFour.addAll(emptyList));
	}
	
	@Test
	void testAddAllEmptyTreeEmptyCollection() {
		assertFalse(emptyTree.addAll(emptyList));
	}
	
	@Test
	void testClear() {
		tenToTwenty.clear();
		assertEquals(0, tenToTwenty.size());
	}
	
	@Test
	void testContainsEmptySet() {
		assertFalse(emptyTree.contains(5));
	}
	
	@Test
	void testContainsDoesNotContain() {
		assertFalse(zeroToFour.contains(10));
	}
	
	@Test
	void tetsContainsDoesContain() {
		assertTrue(zeroToFour.contains(4));
	}
	
	@Test
	void testContainsAllContainsSome() {
		tenToTwenty.add(1);
		assertFalse(tenToTwenty.containsAll(listZeroToFour));
	}
	
	@Test
	void testContainsAllContainsAll() {
		assertTrue(zeroToFour.containsAll(listZeroToFour));
	}
	
	@Test
	void testContainsAllContainsNone() {
		assertFalse(tenToTwenty.containsAll(listZeroToFour));
	}
	
	@Test
	void testContainsAllEmptyCollectionAsArgument() {
		assertTrue(zeroToFour.containsAll(emptyList));
	}
	
	@Test
	void testContainsAllEmptySetEmptyCollection() {
		assertTrue(emptyTree.containsAll(emptyList));
	}
	
	@Test
	void testFirstEmptySet() {
		assertThrows(NoSuchElementException.class, ()-> emptyTree.first());
	}
	
	@Test
	void testFirstReturnsSmallestElement() {
		assertEquals(0,zeroToFour.first() );
	}
	
	@Test
	void testIsEmptySetIsNotEmpty() {
		assertFalse(zeroToFour.isEmpty());
	}
	
	@Test
	void testIsEmptySetIsEmpty() {
		assertTrue(emptyTree.isEmpty());
	}
	
	@Test
	void testLastEmptySet() {
		assertThrows(NoSuchElementException.class, ()-> emptyTree.last());
	}
	
	@Test
	void testLastReturnsSmallestElement() {
		assertEquals(4,zeroToFour.last() );
	}
	
	@Test
	void testRemoveElementDoesNotExist() {
		
	}
	
	@Test
	void testRemoveElementDoesExist() {
		
	}
	
	@Test
	void testRemoveEmptySet() {
		
	}
	
	@Test
	void testRemoveAllNoElementsExist() {
		
	}
	
	@Test
	void testRemoveAllSomeElementsExist() {
		
	}
	
	@Test
	void testRemoveAllAllElementsExist() {
		
	}
	
	@Test
	void testSizeEmptySet() {
		
	}
	
	@Test
	void testSize() {
		
	}
	
	@Test
	void testToArrayListEmptySet() {
		
	}
	
	@Test
	void testToArrayListIsSorted() {
		
	}
}

