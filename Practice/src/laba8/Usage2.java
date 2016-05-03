package laba8;

import java.util.Arrays;


public class Usage2 {

	public static void main(String[] args) throws ClassNotFoundException {
	
		PathClassLoaderImpl loader = new PathClassLoaderImpl();
		loader.setPath("C:/Users/Vasya/git/practice2/Practice/bin");
		Class<?> clazz = loader.findClass("laba1.task1.Matrix");
		System.out.println(Arrays.toString(clazz.getDeclaredMethods()));
	}

}
