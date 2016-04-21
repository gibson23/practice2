package laba11;

import java.util.ConcurrentModificationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(laba11.Test.class);
	
	public void pipa() {
		LOGGER.trace("pipa called");
		System.out.println("pipa");
		throw new ConcurrentModificationException();
	}
	
	public void boba() {
		LOGGER.trace("boba called");
		System.out.println("boba");
	}

	public static void main(String[] args) {
		System.out.println(LOGGER.isTraceEnabled());
		Test test = new Test();
		try {
			test.pipa();
		} catch (ConcurrentModificationException e) {
			LOGGER.error(e.getMessage(), e);
			throw e;
		}
		
		test.boba();
	

	}

}
