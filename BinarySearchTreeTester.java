package assign07;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tester class for the Binary Search Tree Class
 * 
 * @author Max Barker and Josi Gac
 * @version 10/21/25
 */
class BinarySearchTreeTester {
	BinarySearchTree<Integer> emptyTree;
	BinarySearchTree<Integer> zeroToFour;
	BinarySearchTree<Integer> tenToTwenty; 
	BinarySearchTree<Integer> addedInRandomOrder;
	ArrayList<Integer> listZeroToFour;
	ArrayList<Integer> emptyList;
	ArrayList<Integer> someElements;

	@BeforeEach
	void setUp() {
		emptyTree = new BinarySearchTree<Integer>();
		zeroToFour = new BinarySearchTree<Integer>();
		tenToTwenty = new BinarySearchTree<Integer>();
		listZeroToFour = new ArrayList<Integer>();
		emptyList = new ArrayList<Integer>();
		someElements = new ArrayList<Integer>();
		addedInRandomOrder = new BinarySearchTree<Integer>();
		
		for (int i = 0; i < 5; i++) {
			zeroToFour.add(i);
		}
		
		for (int i = 10; i <= 20; i++) {
			tenToTwenty.add(i);
		}

		for (int i = 0; i < 5; i++) {
			listZeroToFour.add(i);
		}
		
		//random order setup
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 50; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		
		for (int i = 0; i < 50; i++) { 
			addedInRandomOrder.add(list.get(i));
		}
		
	}

	@Test
	void testBinarySearchTreeAddNewElementEmptyTree() {
		assertTrue(emptyTree.add(0));
	}
	
	@Test
	void testBinarySearchAddElementExists() {
		emptyTree.add(0);
		assertFalse(emptyTree.add(0));
	}
	
	@Test
	void testBinarySearchAddElementNotEmptyTree() {
		assertTrue(zeroToFour.add(5));
	}
	
	@Test
	void testAddElementTreeWithRandomlyAddedOrder() {
		assertTrue(addedInRandomOrder.add(51));
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
        assertFalse(emptyTree.containsAll(listZeroToFour));
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
        assertThrows(NoSuchElementException.class, () -> emptyTree.first());
    }
    
    @Test
    void testFirstRandomAddOrder() {
    	assertEquals(0, addedInRandomOrder.first());
    }

    @Test
    void testFirstReturnsSmallestElement() {
        assertEquals(0, zeroToFour.first());
        tenToTwenty.add(-1);
        assertEquals(-1, tenToTwenty.first());
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
    	assertThrows(NoSuchElementException.class, () -> emptyTree.last());
    }
	
	@Test
	void testLastReturnsLargestElement() {
	    assertEquals(4, zeroToFour.last());
	    tenToTwenty.add(25);
	    assertEquals(25, tenToTwenty.last());
	}
	
	@Test
	void testLastRandomAddOrder() {
		assertEquals(49, addedInRandomOrder.last());
	}
	
    @Test
    void testRemoveElementDoesNotExist() {
        assertFalse(zeroToFour.remove(10));
        assertEquals(5, zeroToFour.size());
    }

    @Test
    void testRemoveElementDoesExist() {
        assertTrue(zeroToFour.remove(3));
        assertFalse(zeroToFour.contains(3));
        assertEquals(4, zeroToFour.size());
    }

    @Test
    void testRemoveEmptySet() {
        assertFalse(emptyTree.remove(5));
    }
	
    @Test
    void testRemoveAllNoElementsExist() {
        assertFalse(zeroToFour.removeAll(tenToTwenty.toArrayList()));
    }

    @Test
    void testRemoveAllSomeElementsExist() {
        zeroToFour.add(10);
        zeroToFour.add(11);
        someElements.add(0);
        someElements.add(10);
        assertTrue(zeroToFour.removeAll(someElements));
        assertFalse(zeroToFour.contains(0));
        assertFalse(zeroToFour.contains(10));
    }

    @Test
    void testRemoveAllAllElementsExist() {
        assertTrue(zeroToFour.removeAll(listZeroToFour));
        assertTrue(zeroToFour.isEmpty());
    }	
	
    @Test
    void testSizeEmptySet() {
        assertEquals(0, emptyTree.size());
    }

    @Test
    void testSize() {
        assertEquals(5, zeroToFour.size());
        zeroToFour.add(6);
        assertEquals(6, zeroToFour.size());
    }

    @Test
    void testToArrayListEmptySet() {
        assertEquals(0, emptyTree.toArrayList().size());
    }

    @Test
    void testToArrayListIsSorted() {
        ArrayList<Integer> sorted = zeroToFour.toArrayList();
        assertEquals(listZeroToFour, sorted);
    }
}