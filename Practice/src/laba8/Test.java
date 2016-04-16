package laba8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import interfaces.task8.CyclicCollection;
import interfaces.task8.CyclicItem;
import interfaces.task8.SerializableUtils;

public class Test {

	public static void main(String[] args) throws IOException,
			InterruptedException {

		CyclicItem item1 = new CyclicItemImpl();

		CyclicItem item2 = new CyclicItemImpl();

		CyclicItem item3 = new CyclicItemImpl();

		CyclicItem item4 = new CyclicItemImpl();

		CyclicItem item5 = new CyclicItemImpl();

		item1.setValue("hi");
		item5.setTemp("bye");
		CyclicCollection coll = new CyclicCollectionImpl();
		coll.add(item1);
		coll.remove(item1);
		coll.add(item2);
		coll.add(item3);
		coll.add(item4);
		coll.add(item5);
		item3.setValue("item3");
		System.out.println(coll.size());
		System.out.println(coll.getFirst());
		System.out.println(coll.getFirst().getValue());
		System.out.println(coll.getFirst().getTemp());
		SerializableUtils utils = new SerializableUtilsImpl();
		OutputStream os = new FileOutputStream("D:\\obj.dat");
		utils.serialize(os, coll);

		Thread.sleep(100);
		InputStream is = new FileInputStream("D:\\obj.dat");
		CyclicCollection revived1 = (CyclicCollectionImpl) utils.deserialize(is);

		System.out.println(revived1.size());
		System.out.println(revived1.getFirst().nextItem().nextItem().nextItem()
				.nextItem().getValue());
		System.out.println(revived1.getFirst().getTemp());
		System.out.println(revived1.getFirst().nextItem()
				.nextItem().getValue());
		InputStream is2 = new FileInputStream("D:\\obj.dat");
		CyclicCollection revived2 = (CyclicCollectionImpl) utils.deserialize(is2);
		System.out.println(revived1 == revived2);
	}

}
