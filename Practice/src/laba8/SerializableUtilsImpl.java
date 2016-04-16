package laba8;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import interfaces.task8.SerializableUtils;

public class SerializableUtilsImpl implements SerializableUtils {

	@Override
	public Object deserialize(InputStream in) {
		checkNull(in);
		Object result;
		try (ObjectInputStream ois = new ObjectInputStream(in)) {
			result = ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	@Override
	public void serialize(OutputStream out, Object obj) {
		checkNull(obj, out);
		try (ObjectOutputStream oos = new ObjectOutputStream(out)) {
			oos.writeObject(obj);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	private void checkNull(Object... obs) {
		for (Object o : obs) {
			if (o == null)
				throw new NullPointerException();
		}
	}
}
