package laba7.taskb;

import java.util.ArrayList;
import java.util.List;

import interfaces.task7.executor.CopyTask;
import interfaces.task7.executor.Executor;
import interfaces.task7.executor.SumTask;
import interfaces.task7.executor.Task;
import interfaces.task7.executor.TasksStorage;

public class Test {

	public static void main(String[] args) {
		TasksStorage storage = new TasksStorageImpl();
		List<SumTask> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			SumTask t = new SumTaskImpl();
			t.setCount(20);
			t.setMax(9_000_000_000L);
			list.add(t);
		}
		for(int i = 0; i < 10; i++) {
			CopyTask t = new CopyTaskImpl();
			t.setSource("F:\\Video\\Morandi-Colors.mkv");
			t.setDest("F:\\copies\\" + i + ".avi");
			storage.add(t);
		}
		for(Task t : list) {
			storage.add(t);
		}
		Executor exec1 = new ExecutorImpl();
		Executor exec2 = new ExecutorImpl();
		Executor exec3 = new ExecutorImpl();
		exec1.setStorage(storage);
		exec1.start();
		exec2.start();
		exec3.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		exec1.stop();
		exec2.stop();
		exec3.stop();
	}

}
