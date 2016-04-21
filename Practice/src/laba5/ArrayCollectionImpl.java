package laba5;

import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import interfaces.task5.ArrayCollection;
import interfaces.task5.ArrayIterator;

public class ArrayCollectionImpl<E> implements ArrayCollection<E> {

	protected final Logger LOGGER = LoggerFactory
			.getLogger(ArrayCollectionImpl.class.getName());

	private static final int DEFAULT_CAPACITY = 10;

	protected transient int modCount = 0;

	private static final Object[] EMPTY_ELEMENTDATA = {};

	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

	private Object[] elementData;

	private int size;

	public ArrayCollectionImpl(int initialCapacity) {
		LOGGER.trace("ArrayCollectionImpl(int initialCapacity)");
		if (initialCapacity > 0) {
			this.elementData = new Object[initialCapacity];
		} else if (initialCapacity == 0) {
			this.elementData = EMPTY_ELEMENTDATA;
		} else {
			try {
				throw new IllegalArgumentException("Illegal Capacity: "
						+ initialCapacity);
			} catch (IllegalArgumentException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}

	public ArrayCollectionImpl() {
		LOGGER.trace("ArrayCollectionImpl()");
		this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
	}

	public void ensureCapacity(int minCapacity) {
		LOGGER.trace("ensureCapacity(int minCapacity)");
		int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
		// any size if not default element table
		? 0
				// larger than default for default empty table. It's already
				// supposed to be at default size.
				: DEFAULT_CAPACITY;

		if (minCapacity > minExpand) {
			ensureExplicitCapacity(minCapacity);
		}
	}

	private void ensureCapacityInternal(int minCapacity) {
		if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
			minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
		}

		ensureExplicitCapacity(minCapacity);
	}

	private void ensureExplicitCapacity(int minCapacity) {
		modCount++;

		// overflow-conscious code
		if (minCapacity - elementData.length > 0)
			grow(minCapacity);
	}

	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

	private void grow(int minCapacity) {
		// overflow-conscious code
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if (newCapacity - minCapacity < 0)
			newCapacity = minCapacity;
		if (newCapacity - MAX_ARRAY_SIZE > 0)
			newCapacity = hugeCapacity(minCapacity);
		// minCapacity is usually close to size, so this is a win:
		elementData = Arrays.copyOf(elementData, newCapacity);
	}

	private static int hugeCapacity(int minCapacity) {
		if (minCapacity < 0) // overflow
			throw new OutOfMemoryError();
		return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE
				: MAX_ARRAY_SIZE;
	}

	@Override
	public int size() {
		LOGGER.trace("size()");
		return size;
	}

	@Override
	public boolean isEmpty() {
		LOGGER.trace("isEmpty()");
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		LOGGER.trace("contains(Object o)");
		return indexOf(o) >= 0;
	}

	public int indexOf(Object o) {
		LOGGER.trace("indexOf(Object o)");
		if (o == null) {
			for (int i = 0; i < size; i++)
				if (elementData[i] == null)
					return i;
		} else {
			for (int i = 0; i < size; i++)
				if (o.equals(elementData[i]))
					return i;
		}
		return -1;
	}

	private void rangeCheck(int index) {
		if (index >= size)
			try {
				throw new IndexOutOfBoundsException();
			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
			}
	}

	@SuppressWarnings("unchecked")
	E elementData(int index) {
		return (E) elementData[index];
	}

	public E remove(int index) {
		LOGGER.trace("remove(int index)");
		rangeCheck(index);
		modCount++;
		E oldValue = elementData(index);

		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(elementData, index + 1, elementData, index,
					numMoved);
		elementData[--size] = null; // clear to let GC do its work

		return oldValue;
	}

	public class Itr implements ArrayIterator<E> {

		private int cursor; // index of next element to return
		private int lastRet = -1; // index of last element returned; -1 if no
									// such
		private int expectedModCount = modCount;

		@Override
		public boolean hasNext() {
			LOGGER.trace("hasNext()");
			return cursor != size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			LOGGER.trace("next()");
			checkForComodification();
			int i = cursor;
			if (i >= size)
				try {
					throw new NoSuchElementException();
				} catch (Exception e) {
					LOGGER.error(e.getMessage(), e);
				}
			Object[] elementData = ArrayCollectionImpl.this.elementData;
			if (i >= elementData.length)
				try {
					throw new ConcurrentModificationException();
				} catch (Exception e) {
					LOGGER.error(e.getMessage(), e);
				}
			cursor = i + 1;
			return (E) elementData[lastRet = i];
		}

		@Override
		public Object[] getArray() {
			LOGGER.trace("getArray()");
			return ArrayCollectionImpl.this.getArray();
		}

		final void checkForComodification() {
			if (modCount != expectedModCount)
				try {
					throw new ConcurrentModificationException();
				} catch (Exception e) {
					LOGGER.error(e.getMessage(), e);
				}
		}

		public void remove() {
			LOGGER.trace("remove()");
			if (lastRet < 0)
				try {
					throw new IllegalStateException();
				} catch (Exception e) {
					LOGGER.error(e.getMessage(), e);
				}
			checkForComodification();

			try {
				ArrayCollectionImpl.this.remove(lastRet);
				cursor = lastRet;
				lastRet = -1;
				expectedModCount = modCount;
			} catch (IndexOutOfBoundsException ex) {
				try {
					throw new ConcurrentModificationException();
				} catch (Exception e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
		}

	}

	@Override
	public Iterator<E> iterator() {
		LOGGER.trace("iterator()");
		return new Itr();
	}

	@Override
	public Object[] toArray() {
		LOGGER.trace("toArray()");
		return Arrays.copyOf(elementData, size);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		LOGGER.trace("toArray(T[] a)");
		if (a.length < size)
			// Make a new array of a's runtime type, but my contents:
			return (T[]) Arrays.copyOf(elementData, size, a.getClass());
		System.arraycopy(elementData, 0, a, 0, size);
		if (a.length > size)
			a[size] = null;
		return a;
	}

	@Override
	public boolean add(E e) {
		LOGGER.trace("add(E e)");
		ensureCapacityInternal(size + 1); // Increments modCount!!
		elementData[size++] = e;
		return true;
	}

	private void fastRemove(int index) {
		modCount++;
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(elementData, index + 1, elementData, index,
					numMoved);
		elementData[--size] = null; // clear to let GC do its work
	}

	@Override
	public boolean remove(Object o) {
		LOGGER.trace("remove(Object o)");
		if (o == null) {
			for (int index = 0; index < size; index++)
				if (elementData[index] == null) {
					fastRemove(index);
					return true;
				}
		} else {
			for (int index = 0; index < size; index++)
				if (o.equals(elementData[index])) {
					fastRemove(index);
					return true;
				}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		LOGGER.trace("containsAll(Collection<?> c)");
		for (Object e : c)
			if (!contains(e))
				return false;
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		LOGGER.trace("addAll(Collection<? extends E> c)");
		if (c == this)
			try {
				throw new IllegalArgumentException("can not add itself");
			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
			}
		Object[] a = c.toArray();
		int numNew = a.length;
		ensureCapacityInternal(size + numNew); // Increments modCount
		System.arraycopy(a, 0, elementData, size, numNew);
		size += numNew;
		return numNew != 0;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		LOGGER.trace("removeAll(Collection<?> c)");
		Objects.requireNonNull(c);
		return batchRemove(c, false);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		LOGGER.trace("retainAll(Collection<?> c)");
		Objects.requireNonNull(c);
		return batchRemove(c, true);
	}

	private boolean batchRemove(Collection<?> c, boolean complement) {
		final Object[] elementData = this.elementData;
		int r = 0, w = 0;
		boolean modified = false;
		try {
			for (; r < size; r++)
				if (c.contains(elementData[r]) == complement)
					elementData[w++] = elementData[r];
		} finally {
			// Preserve behavioral compatibility with AbstractCollection,
			// even if c.contains() throws.
			if (r != size) {
				System.arraycopy(elementData, r, elementData, w, size - r);
				w += size - r;
			}
			if (w != size) {
				// clear to let GC do its work
				for (int i = w; i < size; i++)
					elementData[i] = null;
				modCount += size - w;
				size = w;
				modified = true;
			}
		}
		return modified;
	}

	@Override
	public void clear() {
		LOGGER.trace("clear()");
		modCount++;

		// clear to let GC do its work
		for (int i = 0; i < size; i++)
			elementData[i] = null;

		size = 0;

	}

	@Override
	public Object[] getArray() {
		LOGGER.trace("getArray()");
		return this.toArray();
	}

	@Override
	public void setArray(E[] array) {
		LOGGER.trace("setArray(E[] array)");
		elementData = Arrays.copyOf(array, array.length);
		if ((size = elementData.length) != 0) {
			if (elementData.getClass() != Object[].class)
				elementData = Arrays.copyOf(elementData, size, Object[].class);
		} else {
			// replace with empty array.
			this.elementData = EMPTY_ELEMENTDATA;
		}

	}

	@Override
	public String toString() {
		LOGGER.trace("toString()");
		Iterator<E> it = iterator();
		if (!it.hasNext())
			return "[]";

		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (;;) {
			E e = it.next();
			sb.append(e == this ? "(this Collection)" : e);
			if (!it.hasNext())
				return sb.append(']').toString();
			sb.append(',').append(' ');
		}
	}

}
