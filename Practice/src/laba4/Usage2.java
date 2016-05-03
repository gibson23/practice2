package laba4;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usage2 {
	public static Map<String, Integer> findThrees(String str) {
		Map<String, Integer> result = new TreeMap<>();
		Matcher m = Pattern.compile("[A-Za-z0-9]{3}").matcher(str);
		if(m.find())
		for (int i = m.start();
				i < str.length()-2;
				) {
				if(m.find(i)) {
				String temp = m.group();
				i = m.end()-2;
				if (result.containsKey(temp)) {
					result.put(temp, result.get(temp) + 1);
				} else {
					result.put(temp, 1);
				}
				} else {
					break;
				}
			

		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findThrees("1234 123_234*23"));
        String str = "12345671234567";
        String str2 = "1234 123_234*12 "
				+ "luchshe pozvonit chem u sosedei zanimat";
        System.out.println(findThrees(str));
        System.out.println(findThrees(str2));
	}
}
