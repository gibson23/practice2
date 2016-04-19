package laba8;

import java.io.Serializable;

import interfaces.task8.CyclicItem;

@SuppressWarnings("serial")
public class CyclicItemImpl implements CyclicItem, Serializable {

	private transient Object temp;
	private Object value;
	private CyclicItem nextItem;

	public CyclicItemImpl() {
		nextItem = this;
	}

	@Override
	public Object getTemp() {
		return temp;
	}

	@Override
	public Object getValue() {
		return this.value;
	}

	@Override
	public CyclicItem nextItem() {
		return nextItem;
	}

	@Override
	public void setNextItem(CyclicItem item) {
		this.nextItem = item;
	}

	@Override
	public void setTemp(Object value) {
		this.temp = value;

	}

	@Override
	public void setValue(Object value) {
		this.value = value;

	}

}
