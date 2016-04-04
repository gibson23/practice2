package laba3;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import interfaces.task3.StringUtils;

public class StringUtilsImpl implements StringUtils {
	
	public StringUtilsImpl() {
		
	}

	@Override
	public String compareWords(String a, String b) {
		Set<Character> aSet = new HashSet<>();
		for(char ch : a.toCharArray()) {
			aSet.add(ch);
		}
		Set<Character> bSet = new HashSet<>();
		for(char ch : b.toCharArray()) {
			bSet.add(ch);
		}
		aSet.removeAll(bSet);
		StringBuilder sb = new StringBuilder("");
		for(Character c : aSet) {
			sb.append(c);
		}
		
		return sb.toString();
	}

	@Override
	public String invert(String str) {
		if(str == null)
			return "";
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		return sb.toString();
	}

	@Override
	public double parseDouble(String str) {
		Matcher m = Pattern.compile("^-?[0-9]+(\\.|,)?([0-9]+)?(e(-|\\+)?[0-9]+)?").matcher(str);
		if(m.find()) {
			str = m.group();
		} else {
			throw new IllegalArgumentException("can not parse double out of " 
						+ str, new NumberFormatException("can not parse"));
		}
		str = str.replace(",", ".");
		return Double.parseDouble(str);
	}

}
