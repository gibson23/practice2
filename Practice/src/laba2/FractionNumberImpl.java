package laba2;

import interfaces.task2.FractionNumber;

public class FractionNumberImpl implements FractionNumber{
	
	private int dividend;
	private int divisor;
	
	public FractionNumberImpl() {
		
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
		if(x == 0)
			throw new IllegalArgumentException("cant divide by zero");
		this.divisor = x;
		
	}

	@Override
	public String toStringValue() {
		StringBuilder result = new StringBuilder("");
		if((this.dividend < 0) ^ (this.divisor < 0))
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
		return this.dividend/this.divisor;
	}

}
