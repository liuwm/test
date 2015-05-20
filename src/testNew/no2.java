package testNew;

public class no2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		no2 no = new no2();
		String str = no.intToHex(-12);
		System.out.println("转换为16进制为：" + str);
	}

	/**
	 * 将一个十进制的数转换为十六进制数
	 * @param a
	 * @return
	 */
	public String intToHex(int a){
		String[] str = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		StringBuilder prefix = new StringBuilder();
		if(a < 0){
			prefix.append("-");
			a = Math.abs(a);
		}
		//用a除以16得到商和余数
		int shang = a/16;
		int yushu = a%16;
		StringBuilder sb = new StringBuilder();
		sb.append(str[yushu]);
		while(shang > 0){
			//如果商大于0，继续用商除以16
			yushu = shang%16;
			shang = shang/16;
			sb.append(str[yushu]);
		}
		return prefix.append(sb.reverse().toString()).toString();
	}
}
