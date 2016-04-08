package laba2;

import interfaces.task2.FractionNumber;

public class FractionNumberImpl implements FractionNumber {

	private int dividend;
	private int divisor;

	public FractionNumberImpl() {

	}


	public FractionNumberImpl(int dividend, int divisor) {
		if(divisor == 0)
			throw new IllegalArgumentException("cant divide by zero");
		int tempDividend = dividend;
		int tempDivisor = divisor;
		for(int i = 17; i > 1; i--) {
			if((tempDividend%i == 0) && (tempDivisor%i == 0)) {
				tempDividend /= i;
				tempDivisor /= i;
			}
		}
		this.dividend = tempDividend;
		this.divisor = tempDivisor;
	}

	@Override
	public int getDividend() {
		return dividend;
	}

	@Override
	public int getDivisor() {
		return divisor;
	}

	@Override
	public void setDividend(int x) {
		this.dividend = x;

	}

	@Override
	public void setDivisor(int x) {
		if (x == 0)
			throw new IllegalArgumentException("cant divide by zero");
		this.divisor = x;

	}

	@Override
	public String toStringValue() {
		StringBuilder result = new StringBuilder("");
		if ((this.dividend < 0) ^ (this.divisor < 0))
			result.append("-");
		result.append(Math.abs(this.dividend));
		result.append("/");
		result.append(Math.abs(this.divisor));

		return result.toString();
	}

	@Override
	public String toString() {
		return this.toStringValue();
	}

	@Override
	public double value() {
		
		return (double)this.dividend / (double)this.divisor;
	}

}
