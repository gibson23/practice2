package laba6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.task6.IOUtils;

public class IOUtilsImpl implements IOUtils {

	@Override
	public void copyFile(String source, String dest) {
		if (source.equalsIgnoreCase(dest))
			throw new IllegalArgumentException("Can not copy to the same file");

		try (InputStream in = new FileInputStream(source);
				OutputStream out = new FileOutputStream(dest)) {
			int k;
			while ((k = in.read()) != -1) {
				out.write(k);
			}
		} catch (FileNotFoundException | SecurityException e) {
			throw new IllegalArgumentException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void copyFileBest(String source, String dest) {

		try (FileChannel sourceChannel = new FileInputStream(source).getChannel();
				FileChannel destChannel = new FileOutputStream(dest).getChannel()) {
			sourceChannel.transferTo(0, sourceChannel.size(), destChannel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void copyFileBuffered(File source, File dest) {
		if (source.equals(dest))
			throw new IllegalArgumentException("Can not copy to the same file");

		try (InputStream in = new BufferedInputStream(new FileInputStream(
				source));
				OutputStream out = new BufferedOutputStream(
						new FileOutputStream(dest))) {
			int k;
			while ((k = in.read()) != -1) {
				out.write(k);
			}
		} catch (FileNotFoundException | SecurityException e) {
			throw new IllegalArgumentException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String[] findFiles(String dir) {
		File path = new File(dir);
		if (!path.isDirectory())
			throw new IllegalArgumentException();
		File[] fileArr = path.listFiles();
		List<String> list = new ArrayList<>();
		for (File file : fileArr) {
			if (file.isFile()) {
				list.add(file.getAbsolutePath());
			} else {
				list.addAll(Arrays.asList(findFiles(file.getAbsolutePath())));
			}
		}
		String[] result = new String[list.size()];
		return list.toArray(result);
	}

	@Override
	public String[] findFiles(String dir, String extention) {

		if (extention == null)
			return findFiles(dir);
		File path = new File(dir);
		if (!path.isDirectory())
			throw new IllegalArgumentException();
		File[] fileArr = path.listFiles();
		List<String> list = new ArrayList<>();
		for (File file : fileArr) {
			if (file.isFile()) {
				if (file.getName().endsWith(extention)) {
					list.add(file.getAbsolutePath());
				}
			} else {
				list.addAll(Arrays.asList(findFiles(file.getAbsolutePath(),
						extention)));
			}
		}
		String[] result = new String[list.size()];
		return list.toArray(result);
	}

	@Override
	public void replaceChars(Reader in, Writer out, String inChars,
			String outChars) {
		if (inChars == null || outChars == null) {
			int k;
			try {
				while ((k = in.read()) != -1) {
					out.write(k);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return;
		}

		if (inChars.length() != outChars.length())
			throw new IllegalArgumentException();

		Map<Character, Character> map = new HashMap<>();
		char[] inArr = inChars.toCharArray();
		char[] outArr = outChars.toCharArray();
		for (int i = 0; i < outArr.length; i++) {
			map.put(inArr[i], outArr[i]);
		}

		int k;
		try {
			while ((k = in.read()) != -1) {

				out.write(map.containsKey((char) k) ? map.get((char) k) : k);
			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
