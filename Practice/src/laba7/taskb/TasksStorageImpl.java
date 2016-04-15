package laba7.taskb;

import java.util.ArrayDeque;
import java.util.Queue;
import interfaces.task7.executor.Task;
import interfaces.task7.executor.TasksStorage;

public class TasksStorageImpl implements TasksStorage {

	private Queue<Task> queue = new ArrayDeque<>();

	public TasksStorageImpl() {

	}

	@Override
	public synchronized void add(Task task) {
		queue.add(task);
	}

	@Override
	public synchronized int count() {
		return queue.size();
	}

	@Override
	public synchronized Task get() {
		return queue.poll();
	}

}
