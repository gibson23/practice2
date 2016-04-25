package laba11;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import laba5.ArrayCollectionImpl;
import interfaces.logging.LoggingArrayCollection;
import interfaces.task5.ArrayIterator;

public class LoggingArrayCollectionImpl<E> implements LoggingArrayCollection<E> {

	protected final Logger LOGGER = LoggerFactory
			.getLogger(LoggingArrayCollectionImpl.class.getName());

	private ArrayCollectionImpl<E> exucutant;
	private ArrayIterator<E> iterator;

	@Override
	public Logger getLogger() {
		return LOGGER;
	}

	public LoggingArrayCollectionImpl() {
		LOGGER.trace(".");
		exucutant = new ArrayCollectionImpl<E>();
	}

	public LoggingArrayCollectionImpl(int i) {
		LOGGER.trace(".");
		try {
			exucutant = new ArrayCollectionImpl<E>(i);
		} catch (RuntimeException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public int size() {
		LOGGER.trace(".");
		return exucutant.size();
	}

	@Override
	public boolean isEmpty() {
		LOGGER.trace(".");
		return exucutant.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		LOGGER.trace(".");
		return exucutant.contains(o);
	}

	public int indexOf(Object o) {
		LOGGER.trace(".");
		return exucutant.indexOf(o);
	}

	public E remove(int index) {
		LOGGER.trace(".");
		E e = null;
		try {
			e = exucutant.remove(index);
		} catch (RuntimeException exc) {
			LOGGER.error(exc.getMessage(), exc);
		}
		return e;
	}

	@Override
	public Object[] getArray() {
		LOGGER.trace(".");
		return toArray();
	}

	@Override
	public void setArray(E[] array) {
		LOGGER.trace(".");
		try {
			exucutant.setArray(array);
		} catch (RuntimeException e) {
			LOGGER.error(e.getMessage(), e);
		}

	}

	@Override
	public Iterator<E> iterator() {
		LOGGER.trace(".");
		iterator = new ArrayIterator<E>() {
			private ArrayIterator<E> executantIter = (ArrayIterator<E>) exucutant
					.iterator();

			@Override
			public boolean hasNext() {
				LOGGER.trace(".");
				return executantIter.hasNext();
			}

			public void remove() {
				LOGGER.trace(".");
				try {
					executantIter.remove();
				} catch (RuntimeException exc) {
					LOGGER.error(exc.getMessage(), exc);
				}
			}

			@Override
			public E next() {
				LOGGER.trace(".");
				E e = null;
				try {
					e = executantIter.next();
				} catch (RuntimeException exc) {
					LOGGER.error(exc.getMessage(), exc);
				}
				return e;
			}

			@Override
			public Object[] getArray() {
				LOGGER.trace(".");
				Object[] result = null;
				try {
					result = executantIter.getArray();
				} catch (RuntimeException e) {
					LOGGER.error(e.getMessage(), e);
				}
				return result;
			}
		};
		return iterator;
	}

	@Override
	public Object[] toArray() {
		LOGGER.trace(".");
		Object[] result = null;
		try {
			result = exucutant.toArray();
		} catch (RuntimeException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return result;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		LOGGER.trace(".");
		T[] result = null;
		try {
			result = exucutant.toArray(a);
		} catch (RuntimeException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return result;
	}

	@Override
	public boolean add(E e) {
		LOGGER.trace(".");
		boolean result = false;
		try {
			result = exucutant.add(e);
		} catch (RuntimeException exc) {
			LOGGER.error(exc.getMessage(), exc);
		}
		return result;
	}

	@Override
	public boolean remove(Object o) {
		LOGGER.trace(".");
		boolean result = false;
		try {
			result = exucutant.remove(o);
		} catch (RuntimeException exc) {
			LOGGER.error(exc.getMessage(), exc);
		}
		return result;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		LOGGER.trace(".");
		boolean result = false;
		try {
			result = exucutant.containsAll(c);
		} catch (RuntimeException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return result;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		LOGGER.trace(".");
		boolean result = false;
		try {
			result = exucutant.addAll(c);
		} catch (RuntimeException exc) {
			LOGGER.error(exc.getMessage(), exc);
		}
		return result;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		LOGGER.trace(".");
		boolean result = false;
		try {
			result = exucutant.removeAll(c);
		} catch (RuntimeException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return result;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		LOGGER.trace(".");
		boolean result = false;
		try {
			result = exucutant.retainAll(c);
		} catch (RuntimeException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return result;
	}

	@Override
	public void clear() {
		LOGGER.trace(".");
		exucutant.clear();
	}
}
