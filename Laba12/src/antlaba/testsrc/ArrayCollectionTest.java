package antlaba.testsrc;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import antlaba.src.ArrayCollectionImpl;
import interfaces.task5.ArrayCollection;

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
  public void shouldThrowIllegalArgExcForAddItself() {
    arrayCollection.add(1);
    arrayCollection.addAll(arrayCollection);
  }

  @Test(timeout = 100)
  public void shouldReturn1AfterAddingOneElement() {
    arrayCollection.add(1);
    assertTrue(arrayCollection.size() == 1);
  }

  @Test(timeout = 100)
  public void sizeShouldBeZeroAfterClear() {
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
    assertTrue("should be empty after creation", arrayCollection.isEmpty());
    arrayCollection.add(3);
    assertFalse("should not be empty after adding an element", arrayCollection.isEmpty());
  }

  @Test(timeout = 100)
  public void testIndexOf() {
    arrayCollection.add(1);
    arrayCollection.add(2);
    arrayCollection.add(3);
    assertTrue("should return true if changed", arrayCollection.removeAll(Arrays.asList(arr1)));
    assertTrue("size should be 1 after previous method call", arrayCollection.size() == 1);
    assertTrue("should contain 1", arrayCollection.contains(1));
  }

  @Test(expected = IllegalArgumentException.class, timeout = 100)
  public void shouldThrowIllegalArgExcWhenTryEnterNegativeCapacity() {
    arrayCollection = new ArrayCollectionImpl<>(-5);
  }

  @Test(timeout = 100)
  public void shouldProvideAddingOfNullObject() {
    arrayCollection.add(null);
    assertTrue(arrayCollection.contains(null));
  }

  @Test(timeout = 100)
  public void shouldBeEqualsToAddedArray() {
    arrayCollection.addAll(Arrays.asList(arr3));
    assertArrayEquals(arr3, arrayCollection.toArray());
  }

  @Test(timeout = 100)
  public void testToThisArray() {
    arrayCollection.addAll(Arrays.asList(arr3));
    Integer[] array2 = new Integer[3];
    assertArrayEquals("should correctly write to given array", arr3, arrayCollection.toArray(array2));
    Integer[] array3 = new Integer[1];
    assertArrayEquals("should correctly write to given array even if it is smaller", arr3,
        arrayCollection.toArray(array3));
  }

  @Test(timeout = 100)
  public void testRemove() {
    arrayCollection.addAll(Arrays.asList(arr3));
    arrayCollection.add(null);
    assertTrue("should return true after changing collection", arrayCollection.remove(arr3[0]));
    assertTrue(arrayCollection.size() == 3);
    assertFalse("should not contain deleted element", arrayCollection.contains(arr3[0]));
    assertTrue("should remove null object properly", arrayCollection.remove(null));
    assertFalse(arrayCollection.contains(null));
    assertFalse("should return false if collection has no removing element", arrayCollection.remove(100));
  }

  @Test(timeout = 100)
  public void containsShouldWorkProperly() {
    arrayCollection.addAll(Arrays.asList(arr3));
    arrayCollection.addAll(Arrays.asList(arr1));
    assertTrue(arrayCollection.containsAll(Arrays.asList(arr3)));
    assertFalse(arrayCollection.containsAll(Arrays.asList(arr2)));
  }

  @Test(timeout = 100)
  public void testRetainAll() {
    arrayCollection.addAll(Arrays.asList(arr3));
    assertTrue(arrayCollection.retainAll(Arrays.asList(arr4)));
    assertTrue("size after retainAll should be equals 2", arrayCollection.size() == 2);
    assertArrayEquals("should contain only retain elements", arr4, arrayCollection.toArray());
  }

  @Test(timeout = 100)
  public void testGetArray() {
    arrayCollection.addAll(Arrays.asList(arr3));
    assertArrayEquals("should return array equals to given", arr3, arrayCollection.getArray());
  }

  @Test(expected = NullPointerException.class, timeout = 100)
  public void shouldThrowNullPointerExcWhenTryToSetNullArray() {
    arrayCollection.setArray(null);
  }

  @Test(timeout = 100)
  public void testSetArray() {
    arrayCollection.setArray(arr3);
    assertArrayEquals("should be equals to given array", arr3, arrayCollection.getArray());
  }
}
