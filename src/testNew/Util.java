package testNew;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Util {

	/**
	 * 关闭流
	 * @param in
	 */
	public static void close(InputStream in) {
		try {
			if(in != null)
			in.close();
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 复制流
	 * @param out
	 * @param in
	 * @throws IOException
	 */
	public static void copy(OutputStream out, InputStream in) throws IOException {
		byte[] b = new byte[4096];
		int n;
		while ((n = in.read(b)) != -1) {
			out.write(b, 0, n);
		}
	}

	/**
	 * 关闭流
	 * @param out
	 */
	public static void close(OutputStream out) {
		try {
			if(out != null)
			out.close();
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}	
	}

}
