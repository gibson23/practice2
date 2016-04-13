package laba7.taskb;

import java.math.BigInteger;
import java.util.Random;

import interfaces.task7.executor.SumTask;

public class SumTaskImpl implements SumTask{
	
	private int tryCount = 0;
	private long max;
	private int count;
	private BigInteger result = BigInteger.valueOf(0L);
	
	public SumTaskImpl() {
		
	}

	@Override
	public boolean execute() throws Exception {
		boolean done = false;
		while(count-- > 0) {
			result = result.add(getRandom());
		}
		done = true;
		return done;
	}

	@Override
	public int getTryCount() {
		return tryCount;
	}

	@Override
	public void incTryCount() {
		tryCount++;
	}

	@Override
	public BigInteger getRandom() {
		Random r = new Random();
		long randomLong = (long)(r.nextDouble()*max);
		return BigInteger.valueOf(randomLong);
	}

	@Override
	public BigInteger getResult() {
		return result;
	}

	@Override
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void setMax(long max) {
		this.max = max;
	}

}
