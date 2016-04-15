package laba7.taska;

import java.io.PrintStream;

import interfaces.task7.simple.NamePrinterRunnable;

public class NamePrinterRunnableImpl implements NamePrinterRunnable {

	private int count;
	private long interval;
	private String name;
	private PrintStream stream;

	public NamePrinterRunnableImpl() {
		
	}

	@Override
	public void setCount(int count) {
		if(count <= 0)
			throw new IllegalArgumentException("count should be 1 or more");
		this.count = count;
	}

	@Override
	public void setInterval(long ms) {
		if(ms <= 0)
			throw new IllegalArgumentException("ms should be 1 or more");
		this.interval = ms;
	}

	@Override
	public void setPrintName(String name) {
		if(name == null) throw new NullPointerException();
		if(name.length() == 0) throw new IllegalArgumentException("empty name");
		this.name = name;

	}

	@Override
	public void setStream(PrintStream stream) {
		if(stream == null) throw new NullPointerException();
		this.stream = stream;
	}

	@Override
	public void run() {
		Thread.currentThread().setName(name);
		
		stream.print(Thread.currentThread().getName());
		while (--count > 0) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stream.print(Thread.currentThread().getName());
		}

	}

}
