package laba6;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import interfaces.task6.IOUtils;

public class Test {

	public static void main(String[] args) throws IOException {
		File sourceFile = new File("D:\\books\\kniga.pdf");
		String sourceString = "D:\\books\\kniga.pdf";

		IOUtils utils = new IOUtilsImpl();
		long start = System.currentTimeMillis();

		utils.copyFileBuffered(sourceFile, new File("D:\\books\\1.pdf"));
		System.out.println("time of copyFileBuffered() is "
				+ (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		utils.copyFile(sourceString, "D:\\books\\2.pdf");
		System.out.println("time of copyFile() is "
				+ (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		utils.copyFileBest(sourceString, "D:\\books\\3.pdf");
		System.out.println("time of copyFileBest() is "
				+ (System.currentTimeMillis() - start));

		for (String s : utils.findFiles("D:\\films")) {
			System.out.println(s);
		}

		System.out.println("-------------------------");

		for (String s : utils.findFiles(
				"C:\\Users\\Vasya\\git\\practice2\\Practice", ".java")) {
			System.out.println(s);
		}

		Reader in = new FileReader("D:\\from.txt");
		Writer out = new FileWriter("D:\\to.txt");

		utils.replaceChars(in, out, "mo-.", null);

	}

}
