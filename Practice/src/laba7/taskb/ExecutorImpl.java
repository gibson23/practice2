package laba7.taskb;

import interfaces.task7.executor.Executor;
import interfaces.task7.executor.Task;
import interfaces.task7.executor.TasksStorage;

public class ExecutorImpl implements Executor {

	private static volatile TasksStorage storage;
	private volatile boolean stopped = false;

	@Override
	public TasksStorage getStorage() {
		return storage;
	}

	@Override
	public void setStorage(TasksStorage storage) {
		this.storage = storage;
	}

	// повышать tryCount если execute() возвращает false
	@Override
	public void start() {
		while (!stopped) {
			if (storage.count() > 0) {
				Task t;
				while ((t = storage.get()) != null) {
					try {
						if(!t.execute()) {
							t.incTryCount();
							if (t.getTryCount() < 5)
								storage.add(t);
						}
					} catch (Exception e) {
						t.incTryCount();
						if (t.getTryCount() < 5)
							storage.add(t);
					}
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void stop() {
		stopped = true;
	}

}
