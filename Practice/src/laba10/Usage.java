package laba10;

import junit.framework.TestResult;
import junit.framework.TestSuite;
import interfaces.junit.JunitTester;

public class Usage {
	public static void main(String[] args) {
		JunitTester tester = new JunitTesterImpl();
		TestSuite suite = tester.suite();
		TestResult result = new TestResult();
		suite.run(result);
		System.out.println(result.errorCount());
		System.out.println(result.failureCount());
		System.out.println(result.failures().nextElement());
		System.out.println(result.wasSuccessful());
	}
}