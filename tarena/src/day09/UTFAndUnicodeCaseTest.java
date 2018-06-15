package day09;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.apache.commons.lang3.StringUtils;


/**
 * I/O 流中的字符流：对文字编码的研究 
 * @author levono
 *
 */
public class UTFAndUnicodeCaseTest {
	/**
	 * 对utf-16be编码的测试，该编码的原理是对字符(两字节)进行半切，分别由两个字节组成
	 * @throws UnsupportedEncodingException 
	 */
	//@Test
	public void testUTF16() throws UnsupportedEncodingException {
		String str = "AB中";
		byte[] bytes = str.getBytes("utf-16be");
		System.out.println(bytes);
		for(byte b : bytes) {
			String bin = Integer.toBinaryString(b);
			bin = StringUtils.leftPad(bin, 8,'0');
			System.out.println(bin);
		}
	}
	
	/**
	 * 得到计算机本地的编码类型
	 */
	//@Test
	public void getEncoding() {
		String encode = 
				System.getProperty("file.encoding");
		System.out.println(encode);
	}
	
	
	/**
	 * 对utf-8进行编/解码
	 * 1.对字符串utf-8编码后的字节进行打印输出演示(三种输出形式，一步一步进行优化)
	 * 2.对字节码进行解码，分别演示正确解码 和 错误解码(乱码)
	 * @throws UnsupportedEncodingException 
	 */
	//@Test
	public void testUtf8() throws UnsupportedEncodingException {
		String str = "ABC中国";
		byte[] buf = str.getBytes("utf-8");
		for(byte b : buf) {
			String bin = Integer.toBinaryString(b);
			String bin2 = Integer.toBinaryString(b & 0xff);
			bin = StringUtils.leftPad(bin, 8, '0');
			System.out.print(b + " ");
		}
		System.out.println("");
		for(byte b : buf) {
			String bin = Integer.toBinaryString(b);
			String bin2 = Integer.toBinaryString(b & 0xff);
			bin = StringUtils.leftPad(bin, 8, '0');
			System.out.print(bin + " ");
		}
		System.out.println("");
		for(byte b : buf) {
			String bin = Integer.toBinaryString(b);
			String bin2 = Integer.toBinaryString(b & 0xff);
			bin = StringUtils.leftPad(bin, 8, '0');
			bin2 = StringUtils.leftPad(bin2, 8, '0');
			System.out.print(bin2 + " ");
		}
		System.out.println("");
		String bin_jie = new String(buf,"utf-8");
		String bin_luan = new String(buf,"gbk");
		System.out.println(bin_jie);
		System.out.println(bin_luan);
	}
}
