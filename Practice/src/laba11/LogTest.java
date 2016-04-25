package laba11;

import java.util.Arrays;

import interfaces.logging.LoggingArrayCollection;
import interfaces.task5.ArrayIterator;

public class LogTest {

	public static void main(String[] args) {
		LoggingArrayCollection<Integer> coll0 = new LoggingArrayCollectionImpl<>();
		for(int i = 0; i < 20; i++)
			coll0.add(i);
		System.out.println(Arrays.toString(coll0.getArray()));
		ArrayIterator<Integer> iter = (ArrayIterator<Integer>) coll0.iterator();
		int in = 0;
		while(iter.hasNext()) {
			in += iter.next();
		}
		System.out.println(in);
		coll0.add(5);
		iter.next();
	}

}
