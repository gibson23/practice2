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
		this.count = count;
	}

	@Override
	public void setInterval(long ms) {
		this.interval = ms;
	}

	@Override
	public void setPrintName(String name) {
		this.name = name;

	}

	@Override
	public void setStream(PrintStream stream) {
		this.stream = stream;
	}

	@Override
	public void run() {
		stream.print(name);
		while (--count > 0) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stream.print(name);
		}

	}

}
