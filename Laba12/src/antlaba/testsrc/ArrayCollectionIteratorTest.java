package antlaba.testsrc;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

import antlaba.src.ArrayCollectionImpl;
import interfaces.task5.ArrayIterator;
import junit.framework.TestCase;

public class ArrayCollectionIteratorTest extends TestCase {

  private ArrayCollectionImpl<Integer> coll;
  private ArrayIterator<Integer> iter;

  @Override
  public void setUp() throws Exception {
    coll = new ArrayCollectionImpl<>();
  }

  public void testNext() {
    coll.add(5);
    iter = coll.new Itr();
    if (iter.hasNext())
      assertTrue(iter.next().equals(5));
  }

  public void testNoSuchElementException() {
    iter = coll.new Itr();
    try {
      iter.next();
      fail("there must be NoSuchElementException");
    } catch (NoSuchElementException e) {
    }
  }

  public void testConcurrentModificationException() {
    iter = coll.new Itr();
    try {
      coll.add(5);
      iter.next();
      fail("there must be ConcurrentModificationException");
    } catch (ConcurrentModificationException e) {
    }
  }

  public void testRemove() {
    coll.add(5);
    iter = coll.new Itr();
    iter.next();
    iter.remove();
    assertFalse(iter.hasNext());
  }
}
