package laba8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import interfaces.task8.PathClassLoader;

public class PathClassLoaderImpl extends ClassLoader implements PathClassLoader {

	private String path;

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public void setPath(String dir) {
		if (dir == null)
			throw new NullPointerException();
		this.path = dir.concat("/");
	}

	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			String pathOfClass = name.replace('.', '/').concat(".class");
			byte b[] = getByteArray(path + pathOfClass);
			return defineClass(name, b, 0, b.length);
		} catch (FileNotFoundException ex) {
			return super.findClass(name);
		} catch (IOException ex) {
			return super.findClass(name);
		}
	}

	private byte[] getByteArray(String path) throws FileNotFoundException,
			IOException {
		InputStream is = new FileInputStream(new File(path));
		byte[] bytes = new byte[(int) (new File(path).length())];
		is.read(bytes);
		is.close();
		return bytes;
	}
}
