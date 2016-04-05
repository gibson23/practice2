package laba4;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import interfaces.task4.MapUtils;

public class Dictionary {
	
	private Map<String, Integer> threesMap;

	public Dictionary(String str) {
		threesMap = findThrees2(str);
	}
	
	private Map<String, Integer> findThrees2(String str) {
		return new MapUtils() {
			
			@Override
			public Map<String, Integer> findThrees(String str) {
				Map<String, Integer> result = new TreeMap<>();
				Matcher m = Pattern.compile("[A-Za-z0-9]{3}").matcher(str);
				
				for(int i = 0; i < str.length()-2; i=m.end()-2 ) {
					m.find(i);
					String temp = m.group();
					if(result.containsKey(temp)) {
						result.put(temp, result.get(temp) + 1);
					} else {
						result.put(temp, 1);
					}
				}
				
				return result;
			}
		}.findThrees(str);
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
