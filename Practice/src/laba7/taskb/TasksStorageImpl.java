package laba7.taskb;

import java.util.LinkedList;
import java.util.Queue;

import interfaces.task7.executor.Task;
import interfaces.task7.executor.TasksStorage;

public class TasksStorageImpl implements TasksStorage {
	
	Queue<Task> queue = new LinkedList<>();
	
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
	public Task get() {
		return queue.poll();
	}

}
