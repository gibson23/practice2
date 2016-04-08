package laba4;

import interfaces.task4.MapUtils;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapUtilsImpl implements MapUtils {

	public MapUtilsImpl() {

	}

	@Override
	public Map<String, Integer> findThrees(String str) {
		Map<String, Integer> result = new TreeMap<>();
		Matcher m = Pattern.compile("[A-Za-z0-9]{3}").matcher(str);
		if (m.find())
			for (int i = m.start();;) {
				if (m.find(i)) {
					String temp = m.group();
					i = m.end() - 2;
					result.put(temp,
							result.containsKey(temp) ? result.get(temp) + 1 : 1);
				} else {
					break;
				}
			}
		return result;
	}
}
