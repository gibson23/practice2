package laba11;

import org.slf4j.Logger;

import laba5.ArrayCollectionImpl;
import interfaces.logging.LoggingArrayCollection;

public class LoggingArrayCollectionImpl<E> extends ArrayCollectionImpl<E>
		implements LoggingArrayCollection<E> {

	@Override
	public Logger getLogger() {
		return super.LOGGER;
	}

}
