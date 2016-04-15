package laba7.taska;

import java.io.PrintStream;

import interfaces.task7.simple.NamePrinterThread;

public class NamePrinterThreadImpl extends NamePrinterThread {

	private int count;
	private long interval;
	private PrintStream stream;

	public NamePrinterThreadImpl() {

	}

	@Override
	public void setCount(int count) {
		if (count <= 0)
			throw new IllegalArgumentException("count should be 1 or more");
		this.count = count;
	}

	@Override
	public void setInterval(long ms) {
		if (ms <= 0)
			throw new IllegalArgumentException("ms should be 1 or more");
		this.interval = ms;
	}

	@Override
	public void setPrintName(String name) {
		if (name == null)
			throw new NullPointerException();
		if (name.length() == 0)
			throw new IllegalArgumentException("empty name");
		setName(name);
	}

	@Override
	public void setStream(PrintStream stream) {
		if (stream == null)
			throw new NullPointerException();
		this.stream = stream;
	}

	@Override
	public void run() {
		stream.print(getName());
		while (--count > 0) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stream.print(getName());
		}

	}
}
