package laba3;

import interfaces.task3.StringDiv;

public class StringDivImpl implements StringDiv{

	@Override
	public double div(String a, String b) {
		
		
		double aDouble;
		double bDouble;
		try {
			aDouble = Double.parseDouble(a);
			bDouble = Double.parseDouble(b);
		} catch (NumberFormatException e) {
			
			throw new IllegalArgumentException("cannot parse", e);
		}
		
		if(bDouble == 0)
			throw new ArithmeticException("can not divide "
					+ "by zero");
		return aDouble/bDouble;
	}
	

}
