package testNew;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class no1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			no1 no = new no1();
			byte[] bytes = no.file2buf(new File("d://test.txt"), false);
			System.out.println(new String(bytes, "UTF-8"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将文件内容转换成byte数组返回,如果文件不存在或者读入错误返回null
	 */
	public byte[] file2buf(File fobj, boolean throwIfException) {
		if (fobj == null) {
			return null;
		}
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(fobj));
			ByteArrayOutputStream out = new ByteArrayOutputStream(4096);
			try {
				Util.copy(out, in);
				return out.toByteArray();
			}
			finally {
				Util.close(out);
			}
		}
		catch (Exception e) {
			if(throwIfException)
				throw new RuntimeException("",e);
			return null;
		}
		finally {
			Util.close(in);
		}
	}
}
