package laba7.taskb;

import interfaces.task7.executor.Executor;
import interfaces.task7.executor.Task;
import interfaces.task7.executor.TasksStorage;

public class ExecutorImpl implements Executor {

	private volatile TasksStorage storage;
	private Thread thread;
	private String name;
	private boolean running = false;

	public ExecutorImpl() {

	}

	public ExecutorImpl(String name) {
		this.name = name;
	}

	// сделал для тестов
	@Override
	public TasksStorage getStorage() {
		return storage;
	}

	@Override
	public void setStorage(TasksStorage storage) {
		this.storage = storage;
	}

	@Override
	public void start() {
		if (running)
			throw new IllegalStateException(
					"you must stop executor before making a new start");
		running = true;
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (!thread.isInterrupted()) {
					if (storage.count() > 0) {
						Task task;
						while ((task = storage.get()) != null) {
							try {
								System.out.println(name + "working on "
										+ task.getClass().getSimpleName()
										+ "tryCount()" + task.getTryCount());
								if (!task.execute()) {
									task.incTryCount();
									if (task.getTryCount() < 5)
										storage.add(task);
								}
							} catch (Exception e) {
								task.incTryCount();
								if (task.getTryCount() < 5)
									storage.add(task);
							}
						}
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						thread.interrupt();
					}

				}
			}
		});
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public void stop() {
		if (!running)
			throw new IllegalStateException("you must start executor first");
		thread.interrupt();
		running = false;
	}

}
