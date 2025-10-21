package assign07;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTester {
	BinarySearchTree<Integer> emptyTree;
	BinarySearchTree<Integer> zeroToFour;
	BinarySearchTree<Integer> tenToTwenty; 
	ArrayList<Integer> listZeroToFour;

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
		emptyTree.addAll(null);
	}
	
	@Test
	void testAddAllSomeItemsExist() {
		
	}
	
	@Test
	void testAddAllNoItemsExist() {
		
	}
	
	@Test
	void testAddAllInsertBetween() {
		
	}
	
	@Test
	void testClear() {
		
	}
	
	@Test
	void testContainsEmptySet() {
		
	}
	
	@Test
	void testContainsDoesNotContain() {
		
	}
	
	@Test
	void tetsContainsDoesContain() {
		
	}
	
	@Test
	void testContainsAllContainsSome() {
		
	}
	
	@Test
	void testContainsAllContainsAll() {
		
	}
	
	@Test
	void testContainsAllContainsNone() {
		
	}
	
	@Test
	void testContainsAllEmptyCollectionAsArgument() {
		
	}
	
	@Test
	void testContainsAllEmptySetEmptyCollection() {
		
	}
	
	@Test
	void testFirstEmptySet() {
		
	}
	
	@Test
	void testFirstReturnsSmallestElement() {
		
	}
	
	@Test
	void testIsEmptySetIsNotEmpty() {
		
	}
	
	@Test
	void testIsEmptySetIsEmpty() {
		
	}
	
	@Test
	void testLastEmptySet() {
		
	}
	
	@Test
	void testLastReturnsSmallestElement() {
		
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

