package laba3;

import interfaces.task3.StringDiv;
import interfaces.task3.StringUtils;

public class StringDivImpl implements StringDiv{

	@Override
	public double div(String a, String b) {
		StringUtils utils = new StringUtilsImpl(); 
		double aDouble = utils.parseDouble(a);
		double bDouble = utils.parseDouble(b);
		if(bDouble == 0)
			throw new ArithmeticException("can not divide "
					+ "by zero");
		return aDouble/bDouble;
	}
	

}
