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
	public void add(Task task) {
		queue.add(task);
	}

	@Override
	public int count() {
		return queue.size();
	}

	@Override
	public synchronized Task get() {
		return queue.poll();
	}

}
