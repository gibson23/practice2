package laba7.taska;

import interfaces.task7.simple.NamePrinterRunnable;
import interfaces.task7.simple.NamePrinterThread;


public class Usage {

	public static void main(String[] args) {
		
		NamePrinterRunnable runnImpl = new NamePrinterRunnableImpl();
		runnImpl.setCount(5);
		runnImpl.setInterval(2000);
		runnImpl.setPrintName("Mihail");
		runnImpl.setStream(System.out);
		Thread thread1 = new Thread(runnImpl);
		thread1.start();
		NamePrinterThread thread2 = new NamePrinterThreadImpl();
		thread2.setCount(8);
		thread2.setInterval(1000);
		thread2.setPrintName("Ibragim");
		thread2.setStream(System.out);
		thread2.start();

	}

}
