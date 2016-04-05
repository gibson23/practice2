package laba4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		CollectionUtilsImpl impl = new CollectionUtilsImpl();
		List<Integer> list1 = new ArrayList<Integer>();
		for(int i = 100; i < 120; i++) {
			list1.add(i);
		}
		list1.add(104);
		list1.add(105);
		List<Integer> list2 = new LinkedList<Integer>();
		for(int i = 100; i < 140; i+=2) {
			list2.add(i);	
		}
		list2.add(104);
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(impl.difference(list1, list2));
		System.out.println(impl.intersection(list1, list2));
		System.out.println(impl.intersectionWithoutDuplicate(list1, list2));
		System.out.println(impl.union(list1, list2));
		
		Dictionary dic = new Dictionary("mama mila ramu poka ne domila");
		dic.showDictionary();
		System.out.println(dic.frequency("pipa"));
		System.out.println(dic.frequency("mil"));
		
		
	}

}
