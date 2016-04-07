package laba4;

import java.util.Map;

import interfaces.task4.MapUtils;

public class Dictionary {
	
	private Map<String, Integer> threesMap;
	
	private MapUtils mapUtils = new MapUtilsImpl();

	public Dictionary(String str) {
		threesMap = findThrees2(str);
	}
	
	private Map<String, Integer> findThrees2(String str) {
		return mapUtils.findThrees(str);
	}
	
	
	public Integer frequency(String str) {
		if(threesMap.containsKey(str)) {
			return threesMap.get(str);
		}
		return 0;
		
	}
	
	public void showDictionary() {
		System.out.println(threesMap);
	}
	

}
