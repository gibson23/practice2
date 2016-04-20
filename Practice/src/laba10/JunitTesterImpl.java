package laba10;

import interfaces.junit.JunitTester;
import junit.framework.TestSuite;

public class JunitTesterImpl implements JunitTester {

	@Override
	public TestSuite suite() {
		return new TestSuite(ArrayCollectionTest.class,
				ArrayCollectionIteratorTest.class);
	}

}
