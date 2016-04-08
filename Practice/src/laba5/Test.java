package laba5;

import interfaces.task2.FractionNumber;
import interfaces.task2.FractionNumberOperation;
import interfaces.task5.ArrayCollection;

import java.util.Arrays;

import laba2.FractionNumberImpl;
import laba2.FractionNumberOperationImpl;



public class Test {

	public static void main(String[] args) {
		ArrayCollectionImpl<Integer> coll0 = new ArrayCollectionImpl<>();
		for(int i = 1; i<=20; i++) {
			coll0.add(i);
		}
		System.out.println(coll0);
		System.out.println(Arrays.toString(coll0.getArray()));
		Integer[] intArr = new Integer[5];
		Integer[] intArr2 = coll0.toArray(intArr);
		System.out.println(Arrays.toString(intArr2));
		ArrayCollectionImpl<Integer>.Itr iter = coll0.new Itr();
		System.out.println(iter.hasNext());
		while(iter.hasNext())
			System.out.println(iter.next());
		System.out.println(Arrays.toString(iter.getArray()));
		
		
		
		ArrayCollection<FractionNumber> coll1 = new ArrayCollectionImpl<>();
		for(int i = -10; i < -2; i++) {
			coll1.add(new FractionNumberImpl(1, i));
		}
		System.out.println(coll1);
		FractionNumber result = new FractionNumberImpl(0, 1);
		FractionNumberOperation oper = new FractionNumberOperationImpl();
		for(FractionNumber fn : coll1) {
			result = oper.add(result, fn);
		}
		
		System.out.println(result);
		System.out.println(result.value());
		System.out.println(Arrays.toString(coll1.getArray()));
		
		
	}

}
