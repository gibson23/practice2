package laba7.taskb;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import interfaces.task7.executor.CopyTask;

public class CopyTaskImpl implements CopyTask {

	private int tryCount = 0;
	private String dest;
	InputStream in;

	public CopyTaskImpl() {

	}

	@Override
	public boolean execute() throws Exception {
		boolean done = false;

		try (OutputStream out = new BufferedOutputStream(new FileOutputStream(
				dest))) {
			int k;
			while ((k = in.read()) != -1) {
				out.write(k);
			}
		} catch (IOException e) {
			throw new Exception(e);
		} finally {
			if (in != null) {
				in.close();
			}
		}
		done = true;
		return done;
	}

	@Override
	public int getTryCount() {
		return tryCount;
	}

	@Override
	public void incTryCount() {
		tryCount++;
	}

	@Override
	public void setDest(String dest) {
		if (dest == null)
			throw new NullPointerException();
		this.dest = dest;

	}

	@Override
	public void setSource(String source) {
		try {
			in = new BufferedInputStream(new FileInputStream(source));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
