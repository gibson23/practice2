package laba2;

import interfaces.task2.FractionNumber;
import interfaces.task2.FractionNumberOperation;

public class Usage {

	public static void main(String[] args) {
		
		FractionNumber fraction1 = new FractionNumberImpl();
		fraction1.setDividend(-5);
		fraction1.setDivisor(8);
		FractionNumber fraction2 = new FractionNumberImpl();
		fraction2.setDividend(-1);
		fraction2.setDivisor(3);
		
		FractionNumberOperation operation =
				new FractionNumberOperationImpl();
		System.out.println(operation.add(fraction1, fraction2));
		System.out.println(operation.sub(fraction1, fraction2));
		System.out.println(operation.mul(fraction1, fraction2));
		System.out.println(operation.div(fraction1, fraction2));
		FractionNumber fn1 = new FractionNumberImpl(1, -20);
		FractionNumber fn2 = new FractionNumberImpl(1, -19);
		System.out.println(operation.add(fn1, fn2));
		
		


	}

}
