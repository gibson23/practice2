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
		char[] aChars = a.toCharArray();
		Set<Character> aSet = new HashSet<Character>();
		for(char ch : aChars) {
			aSet.add(ch);
		}
		char[] bChars = b.toCharArray();
		Set<Character> bSet = new HashSet<Character>();
		for(char ch : bChars) {
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
		char[] chars = str.toCharArray();
		int size = chars.length;
		
		for (int i = 0; i < size/2; i++) {
			char temp = chars[i];
			chars[i] = chars[size-i-1];
			chars[size-i-1] = temp;
			
		}
		return new String(chars);
	}

	@Override
	public double parseDouble(String str) {
		Pattern p = Pattern.compile("^-?[0-9]+(\\.|,)?([0-9]+)?(e[0-9]+)?");
		Matcher m = p.matcher(str);
		if(m.find()) {
			str = m.group();
		} else {
			throw new IllegalArgumentException("can not parse double out of " 
						+ str);
		}
		str = str.replace(",", ".");
		return Double.parseDouble(str);
	}

}
