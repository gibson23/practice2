package laba8;

import java.io.Serializable;

import interfaces.task8.CyclicCollection;
import interfaces.task8.CyclicItem;

@SuppressWarnings("serial")
public class CyclicCollectionImpl implements CyclicCollection, Serializable {

	private CyclicItem head;
	private CyclicItem tail;

	public CyclicCollectionImpl() {

	}

	private boolean contains(CyclicItem item) {
		if (head == null)
			return false;
		if (item == head)
			return true;
		for (CyclicItem x = head.nextItem(); x != head; x = x.nextItem()) {
			if (item == x)
				return true;
		}
		return false;
	}

	@Override
	public boolean add(CyclicItem item) {
		checkNull(item);
		boolean added = false;
		if (contains(item))
			throw new IllegalArgumentException(
					"Collection already has such element");
		if (head == null) {
			head = item;
			tail = item;
			item.setNextItem(item);
			added = true;
		} else {
			item.setNextItem(head);
			head = item;
			tail.setNextItem(head);
			added = true;
		}
		return added;
	}

	@Override
	public CyclicItem getFirst() {
		return head;
	}

	@Override
	public void insertAfter(CyclicItem item, CyclicItem newItem) {
		checkNull(item, newItem);
		if (!contains(item) || contains(newItem))
			throw new IllegalArgumentException("bad input");
		if (tail == item)
			tail = newItem;
		newItem.setNextItem(item.nextItem());
		item.setNextItem(newItem);

	}

	@Override
	public boolean remove(CyclicItem itemToDelete) {
		checkNull(itemToDelete);
		if (!contains(itemToDelete))
			return false;
		if (itemToDelete == head && head == tail) {
			head = null;
			tail = null;
			return true;
		}

		for (CyclicItem x = head;; x = x.nextItem()) {
			if (itemToDelete == x.nextItem()) {
				if (itemToDelete == head) {
					head = x.nextItem().nextItem();
				} else if (itemToDelete == tail) {
					tail = x;
				}
				x.setNextItem(x.nextItem().nextItem());
				return true;
			}
		}
	}

	@Override
	public int size() {
		if (head == null)
			return 0;
		int size = 1;
		if(head == tail) return 1;
		for (CyclicItem c = head.nextItem(); c != head; c = c.nextItem()) {
			size++;
		}
		return size;
	}

	private void checkNull(Object... obs) {
		for (Object o : obs) {
			if (o == null)
				throw new NullPointerException();
		}
	}

}
