package laba3;

import interfaces.task3.StringDiv;
import interfaces.task3.StringUtils;

public class Test {
	
	public static void main(String[] args) {
		StringUtils  utils = new StringUtilsImpl();
		System.out.println(utils.invert("mama mila ramu"));
		System.out.println(utils.compareWords("parashut", "pirog"));
		try {
		System.out.println(utils.parseDouble("B0435435e18,6p554.3zu"));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(utils.parseDouble("435435e18,6p554.3zu"));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		System.out.println("------------------------------------------");
		StringDiv div = new StringDivImpl();
		System.out.println(div.div("3.14e60masha", "60e20pavlik"));
		try {
			System.out.println(div.div("masha", "5"));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(div.div("3.14e60", "0"));
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
	}

}
