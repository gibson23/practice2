package laba7.taskb;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

import interfaces.task7.executor.CopyTask;

public class CopyTaskImpl implements CopyTask {

	private int tryCount = 0;
	private String dest;
	private String source;

	@Override
	public boolean execute() throws Exception {
		incTryCount();
		boolean done = false;
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
		this.dest = dest;

	}

	@Override
	public void setSource(String source) {
		this.source = source;
	}

}
