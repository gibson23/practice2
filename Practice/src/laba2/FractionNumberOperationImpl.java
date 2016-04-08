package laba2;

import interfaces.task2.FractionNumber;
import interfaces.task2.FractionNumberOperation;

public class FractionNumberOperationImpl
		implements FractionNumberOperation {
	
	public FractionNumberOperationImpl() {
		
	}

	@Override
	public FractionNumber add(FractionNumber a, FractionNumber b) {
		int resultDividend = a.getDividend() * b.getDivisor() +
				b.getDividend() * a.getDivisor();
		int resultDivisor = a.getDivisor() * b.getDivisor();

		return new FractionNumberImpl(resultDividend, resultDivisor);
	}

	@Override
	public FractionNumber div(FractionNumber a, FractionNumber b) {
		if(b.getDividend() == 0)
			throw new ArithmeticException("cant divide by zero");
		int resultDividend = a.getDividend() * b.getDivisor();
		int resultDivisor = a.getDivisor() * b.getDividend();

		return new FractionNumberImpl(resultDividend, resultDivisor);
	}

	@Override
	public FractionNumber mul(FractionNumber a, FractionNumber b) {
		int resultDividend = a.getDividend() * b.getDividend();
		int resultDivisor = a.getDivisor() * b.getDivisor();

		return new FractionNumberImpl(resultDividend, resultDivisor);
	}

	@Override
	public FractionNumber sub(FractionNumber a, FractionNumber b) {
		int resultDividend = a.getDividend() * b.getDivisor() -
				b.getDividend() * a.getDivisor();
		int resultDivisor = a.getDivisor() * b.getDivisor();

		return new FractionNumberImpl(resultDividend, resultDivisor);
	}

}
