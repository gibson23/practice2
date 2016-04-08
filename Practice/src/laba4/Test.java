package laba4;

import interfaces.task4.MapUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
		
		Dictionary dic = new Dictionary("mama mila ramu poka ne domila 8-800-555-35-35 "
				+ "luchshe pozvonit chem u sosedei zanimat * * . . h -_-");
		dic.showDictionary();
		System.out.println(dic.frequency("pipa"));
		System.out.println(dic.frequency("mil"));
		
		List<Integer> test1 = new ArrayList<>();
		test1.add(1);
		test1.add(3);
		test1.add(5);
		test1.add(5);
		test1.add(5);
		List<Integer> test2 = new ArrayList<>();
		test2.add(1);
		test2.add(2);
		test2.add(5);
		System.out.println(impl.intersection(test1, test2));
		List<Integer> test3 = new ArrayList<>();
		test3.add(5);
		List<Integer> test4 = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			test4.add(5);
		}
		System.out.println(impl.intersection(test3, test4));
		
		String str = "1234567";
        String str2 = "1234 123_234*12";
        MapUtils mapUtils = new MapUtilsImpl();
        Map<String, Integer> result2 = mapUtils.findThrees(str2);
        System.out.println(result2);
        
		Map<String, Integer> result = mapUtils.findThrees(str);
		System.out.println(result);
		
	}

}
