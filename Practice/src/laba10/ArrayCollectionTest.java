package laba10;

import java.util.Arrays;

import laba5.ArrayCollectionImpl;
import interfaces.task5.ArrayCollection;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArrayCollectionTest {
	private ArrayCollection<Integer> arrayCollection;
	private Integer[] arr1 = { 2, 3 };
	private Integer[] arr2 = { 1, 4 };
	private Integer[] arr3 = { 5, 10, 15 };
	private Integer[] arr4 = { 10, 15 };

	@Before
	public void before() throws Exception {
		arrayCollection = new ArrayCollectionImpl<Integer>();
	}

	@Test(expected = IllegalArgumentException.class, timeout = 100)
	public void testAddItself() {
		arrayCollection.add(1);
		arrayCollection.addAll(arrayCollection);
	}

	@Test(timeout = 100)
	public void testSize() {
		arrayCollection.add(1);
		assertTrue(arrayCollection.size() == 1);
	}

	@Test(timeout = 100)
	public void testClear() {
		arrayCollection.add(1);
		arrayCollection.add(2);
		arrayCollection.add(3);
		arrayCollection.clear();
		assertTrue(arrayCollection.size() == 0);
	}

	@Test(timeout = 100)
	public void testContains() {
		arrayCollection.add(1);
		arrayCollection.add(2);
		arrayCollection.add(3);
		assertTrue(arrayCollection.contains(2));
		assertFalse(arrayCollection.contains(5));
	}

	@Test(timeout = 100)
	public void testIsEmpty() {
		assertTrue(arrayCollection.isEmpty());
		arrayCollection.add(3);
		assertFalse(arrayCollection.isEmpty());
	}

	@Test(timeout = 100)
	public void testIndexOf() {
		arrayCollection.add(1);
		arrayCollection.add(2);
		arrayCollection.add(3);
		assertTrue(arrayCollection.removeAll(Arrays.asList(arr1)));
		assertTrue(arrayCollection.size() == 1);
		assertTrue(arrayCollection.contains(1));
	}

	@Test(expected = IllegalArgumentException.class, timeout = 100)
	public void testNegativeCapacity() {
		arrayCollection = new ArrayCollectionImpl<>(-5);
	}

	@Test(timeout = 100)
	public void testNullObject() {
		arrayCollection.add(null);
		assertTrue(arrayCollection.contains(null));
	}

	@Test(timeout = 100)
	public void testToArray() {
		arrayCollection.addAll(Arrays.asList(arr3));
		assertArrayEquals(arr3, arrayCollection.toArray());
	}

	@Test(timeout = 100)
	public void testToThisArray() {
		arrayCollection.addAll(Arrays.asList(arr3));
		Integer[] array2 = new Integer[3];
		assertArrayEquals(arr3, arrayCollection.toArray(array2));
		Integer[] array3 = new Integer[1];
		assertArrayEquals(arr3, arrayCollection.toArray(array3));
	}

	@Test(timeout = 100)
	public void testRemove() {
		arrayCollection.addAll(Arrays.asList(arr3));
		arrayCollection.add(null);
		assertTrue(arrayCollection.remove(arr3[0]));
		assertTrue(arrayCollection.size() == 3);
		assertFalse(arrayCollection.contains(arr3[0]));
		assertTrue(arrayCollection.remove(null));
		assertFalse(arrayCollection.contains(null));
		assertFalse(arrayCollection.remove(100));
	}

	@Test(timeout = 100)
	public void testContainsAll() {
		arrayCollection.addAll(Arrays.asList(arr3));
		arrayCollection.addAll(Arrays.asList(arr1));
		assertTrue(arrayCollection.containsAll(Arrays.asList(arr3)));
		assertFalse(arrayCollection.containsAll(Arrays.asList(arr2)));
	}

	@Test(timeout = 100)
	public void testRetainAll() {
		arrayCollection.addAll(Arrays.asList(arr3));
		assertTrue(arrayCollection.retainAll(Arrays.asList(arr4)));
		assertTrue(arrayCollection.size() == 2);
		assertArrayEquals(arr4, arrayCollection.toArray());
	}

	@Test(timeout = 100)
	public void testGetArray() {
		arrayCollection.addAll(Arrays.asList(arr3));
		assertArrayEquals(arr3, arrayCollection.getArray());
	}

	@Test(expected = NullPointerException.class, timeout = 100)
	public void testSetNullArray() {
		arrayCollection.setArray(null);
	}

	@Test(timeout = 100)
	public void testSetArray() {
		arrayCollection.setArray(arr3);
		assertArrayEquals(arr3, arrayCollection.getArray());
	}
}
