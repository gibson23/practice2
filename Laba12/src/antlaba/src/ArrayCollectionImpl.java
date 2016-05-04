package antlaba.src;

import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import interfaces.task5.ArrayCollection;
import interfaces.task5.ArrayIterator;

/**
 * @author hypson
 *
 * @param <E>
 */
public class ArrayCollectionImpl<E> implements ArrayCollection<E> {

  /**
   * Default initial capacity.
   */
  private static final int DEFAULT_CAPACITY = 10;
  /**
   * The number of times this list has been <i>structurally modified</i>.
   * Structural modifications are those that change the size of the list, or
   * otherwise perturb it in such a fashion that iterations in progress may
   * yield incorrect results.
   *
   * <p>
   * This field is used by the iterator and list iterator implementation
   * returned by the {@code iterator} and {@code listIterator} methods. If the
   * value of this field changes unexpectedly, the iterator (or list iterator)
   * will throw a {@code ConcurrentModificationException} in response to the
   * {@code next}, {@code remove}, {@code previous}, {@code set} or {@code add}
   * operations. This provides <i>fail-fast</i> behavior, rather than
   * non-deterministic behavior in the face of concurrent modification during
   * iteration.
   *
   * <p>
   * <b>Use of this field by subclasses is optional.</b> If a subclass wishes to
   * provide fail-fast iterators (and list iterators), then it merely has to
   * increment this field in its {@code add(int, E)} and {@code remove(int)}
   * methods (and any other methods that it overrides that result in structural
   * modifications to the list). A single call to {@code add(int, E)} or
   * {@code remove(int)} must add no more than one to this field, or the
   * iterators (and list iterators) will throw bogus
   * {@code ConcurrentModificationExceptions}. If an implementation does not
   * wish to provide fail-fast iterators, this field may be ignored.
   */
  private transient int modCount = 0;
  /**
   * Shared empty array instance used for empty instances.
   */
  private static final Object[] EMPTY_ELEMENTDATA = {};
  /**
   * Shared empty array instance used for default sized empty instances. We
   * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
   * first element is added.
   */
  private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
  /**
   * The array buffer into which the elements of the ArrayList are stored. The
   * capacity of the ArrayList is the length of this array buffer. Any empty
   * ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA will be
   * expanded to DEFAULT_CAPACITY when the first element is added.
   */
  private Object[] elementData;
  /**
   * The size of the ArrayList (the number of elements it contains).
   */
  private int size;

  /**
   * Constructs an empty list with the specified initial capacity.
   *
   * @param initialCapacity
   *          the initial capacity of the list
   * @throws IllegalArgumentException
   *           if the specified initial capacity is negative
   */
  public ArrayCollectionImpl(final int initialCapacity) {
    if (initialCapacity > 0) {
      this.elementData = new Object[initialCapacity];
    } else if (initialCapacity == 0) {
      this.elementData = EMPTY_ELEMENTDATA;
    } else {
      throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
    }
  }

  /**
   * Constructs an empty list with an initial capacity of ten.
   */
  public ArrayCollectionImpl() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
  }

  private void ensureCapacityInternal(final int minCapacity) {
    int newCapacity = 0;
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
      newCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
    }

    ensureExplicitCapacity(newCapacity);
  }

  private void ensureExplicitCapacity(final int minCapacity) {
    modCount++;

    // overflow-conscious code
    if (minCapacity - elementData.length > 0) {
      grow(minCapacity);
    }
  }

  /**
   * The maximum size of array to allocate. Some VMs reserve some header words
   * in an array. Attempts to allocate larger arrays may result in
   * OutOfMemoryError: Requested array size exceeds VM limit
   */
  private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

  private void grow(final int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity < 0) {
      newCapacity = minCapacity;
    }
    if (newCapacity - MAX_ARRAY_SIZE > 0) {
      newCapacity = hugeCapacity(minCapacity);
    }
    // minCapacity is usually close to size, so this is a win:
    elementData = Arrays.copyOf(elementData, newCapacity);
  }

  private static int hugeCapacity(final int minCapacity) {
    if (minCapacity < 0) { // overflow
      throw new OutOfMemoryError();
    }

    if (minCapacity > MAX_ARRAY_SIZE) {
      return Integer.MAX_VALUE;
    } else {
      return MAX_ARRAY_SIZE;
    }
  }

  /**
   * Returns the number of elements in this list.
   *
   * @return the number of elements in this list
   */
  @Override
  public final int size() {
    return size;
  }

  /**
   * Returns <tt>true</tt> if this list contains no elements.
   *
   * @return <tt>true</tt> if this list contains no elements
   */
  @Override
  public final boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns <tt>true</tt> if this list contains the specified element. More
   * formally, returns <tt>true</tt> if and only if this list contains at least
   * one element <tt>e</tt> such that
   * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
   *
   * @param o
   *          element whose presence in this list is to be tested
   * @return <tt>true</tt> if this list contains the specified element
   */
  @Override
  public final boolean contains(final Object o) {
    return indexOf(o) >= 0;
  }

  /**
   * Returns the index of the first occurrence of the specified element in this
   * list, or -1 if this list does not contain the element. More formally,
   * returns the lowest index <tt>i</tt> such that
   * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
   * or -1 if there is no such index.
   *
   * @param o
   *          is the Object which index is need to find out.
   * @return the lowest index or -1 if there is no such index.
   */
  public final int indexOf(final Object o) {
    if (o == null) {
      for (int i = 0; i < size; i++) {
        if (elementData[i] == null) {
          return i;
        }
      }
    } else {
      for (int i = 0; i < size; i++) {
        if (o.equals(elementData[i])) {
          return i;
        }
      }
    }
    return -1;
  }

  private void rangeCheck(final int index) {
    if (index >= size) {
      throw new IndexOutOfBoundsException();
    }
  }

  /**
   * Positional Access Operations.
   *
   * @param index
   *          is the index of element which is need to get
   * @return element with specified index
   */
  @SuppressWarnings("unchecked")
  final E elementData(final int index) {
    return (E) elementData[index];
  }

  /**
   * Removes the element at the specified position in this list. Shifts any
   * subsequent elements to the left (subtracts one from their indices).
   *
   * @param index
   *          the index of the element to be removed
   * @return the element that was removed from the list
   * @throws IndexOutOfBoundsException
   *           {@inheritDoc}
   */
  public final E remove(final int index) {
    rangeCheck(index);
    modCount++;
    E oldValue = elementData(index);

    int numMoved = size - index - 1;
    if (numMoved > 0) {
      System.arraycopy(elementData, index + 1, elementData, index, numMoved);
    }
    elementData[--size] = null; // clear to let GC do its work

    return oldValue;
  }

  /**
   * An optimized version of AbstractList.Itr.
   */
  public class Itr implements ArrayIterator<E> {

    private int cursor; // index of next element to return
    private int lastRet = -1; // index of last element returned; -1 if no
    // such
    private int expectedModCount = modCount;

    @Override
    public final boolean hasNext() {
      return cursor != size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final E next() {
      checkForComodification();
      int i = cursor;
      if (i >= size) {
        throw new NoSuchElementException();
      }
      Object[] newElementData = ArrayCollectionImpl.this.elementData;
      if (i >= newElementData.length) {
        throw new ConcurrentModificationException();
      }
      cursor = i + 1;
      lastRet = i;
      return (E) newElementData[i];
    }

    @Override
    public final Object[] getArray() {

      return ArrayCollectionImpl.this.getArray();
    }

    /**
     * Just checks if there was modification while using iterator.
     */
    final void checkForComodification() {
      if (modCount != expectedModCount) {
        throw new ConcurrentModificationException();
      }
    }

    @Override
    public final void remove() {
      if (lastRet < 0) {
        throw new IllegalStateException();
      }
      checkForComodification();

      try {
        ArrayCollectionImpl.this.remove(lastRet);
        cursor = lastRet;
        lastRet = -1;
        expectedModCount = modCount;
      } catch (IndexOutOfBoundsException ex) {
        throw new ConcurrentModificationException();
      }
    }

  }

  @Override
  public final Iterator<E> iterator() {
    return new Itr();
  }

  @Override
  public final Object[] toArray() {
    return Arrays.copyOf(elementData, size);
  }

  @SuppressWarnings("unchecked")
  @Override
  public final <T> T[] toArray(final T[] a) {
    if (a.length < size) {
      // Make a new array of a's runtime type, but my contents:
      return (T[]) Arrays.copyOf(elementData, size, a.getClass());
    }
    System.arraycopy(elementData, 0, a, 0, size);
    if (a.length > size) {
      a[size] = null;
    }
    return a;
  }

  @Override
  public final boolean add(final E e) {
    ensureCapacityInternal(size + 1); // Increments modCount!!
    elementData[size++] = e;
    return true;
  }

  private void fastRemove(final int index) {
    modCount++;
    int numMoved = size - index - 1;
    if (numMoved > 0) {
      System.arraycopy(elementData, index + 1, elementData, index, numMoved);
    }
    elementData[--size] = null; // clear to let GC do its work
  }

  @Override
  public final boolean remove(final Object o) {
    if (o == null) {
      for (int index = 0; index < size; index++) {
        if (elementData[index] == null) {
          fastRemove(index);
          return true;
        }
      }
    } else {
      for (int index = 0; index < size; index++) {
        if (o.equals(elementData[index])) {
          fastRemove(index);
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public final boolean containsAll(final Collection<?> c) {
    for (Object e : c) {
      if (!contains(e)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public final boolean addAll(final Collection<? extends E> c) {
    if (c == this) {
      throw new IllegalArgumentException("can not add itself");
    }
    Object[] a = c.toArray();
    int numNew = a.length;
    ensureCapacityInternal(size + numNew); // Increments modCount
    System.arraycopy(a, 0, elementData, size, numNew);
    size += numNew;
    return numNew != 0;
  }

  @Override
  public final boolean removeAll(final Collection<?> c) {
    Objects.requireNonNull(c);
    return batchRemove(c, false);
  }

  @Override
  public final boolean retainAll(final Collection<?> c) {
    Objects.requireNonNull(c);
    return batchRemove(c, true);
  }

  private boolean batchRemove(final Collection<?> c, final boolean complement) {
    final Object[] newElementData = this.elementData;
    int r = 0, w = 0;
    boolean modified = false;
    try {
      for (; r < size; r++) {
        if (c.contains(newElementData[r]) == complement) {
          newElementData[w++] = newElementData[r];
        }
      }
    } finally {
      // Preserve behavioral compatibility with AbstractCollection,
      // even if c.contains() throws.
      if (r != size) {
        System.arraycopy(newElementData, r, newElementData, w, size - r);
        w += size - r;
      }
      if (w != size) {
        // clear to let GC do its work
        for (int i = w; i < size; i++) {
          newElementData[i] = null;
        }
        modCount += size - w;
        size = w;
        modified = true;
      }
    }
    return modified;
  }

  @Override
  public final void clear() {
    modCount++;

    // clear to let GC do its work
    for (int i = 0; i < size; i++) {
      elementData[i] = null;
    }

    size = 0;

  }

  @Override
  public final Object[] getArray() {
    return this.toArray();
  }

  @Override
  public final void setArray(final E[] array) {
    elementData = Arrays.copyOf(array, array.length);
    size = elementData.length;
    if ((elementData.length) != 0) {

      if (elementData.getClass() != Object[].class) {
        elementData = Arrays.copyOf(elementData, size, Object[].class);
      }
    } else {
      // replace with empty array.
      this.elementData = EMPTY_ELEMENTDATA;
    }
  }

  /**
   * Returns a string representation of this collection. The string
   * representation consists of a list of the collection's elements in the order
   * they are returned by its iterator, enclosed in square brackets (
   * <tt>"[]"</tt>). Adjacent elements are separated by the characters
   * <tt>", "</tt> (comma and space). Elements are converted to strings as by
   * {@link String#valueOf(Object)}.
   *
   * @return a string representation of this collection
   */
  @Override
  public final String toString() {
    Iterator<E> it = iterator();
    if (!it.hasNext()) {
      return "[]";
    }

    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (;;) {
      E e = it.next();
      sb.append(e);
      if (!it.hasNext()) {
        return sb.append(']').toString();
      }
      sb.append(',').append(' ');
    }
  }

}
