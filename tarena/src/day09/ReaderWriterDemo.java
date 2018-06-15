package day09;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

import org.junit.Test;

/**
 * @author levono
 * 字符转换流的演示
 * 所谓的字符转换流，本质也是扩展流，需要依赖节点流。
 * 字符流的扩展作用就是底层封装了字符的编码 和 解码。
 */
public class ReaderWriterDemo {

//	@Test
	/**
	 * @throws IOException
	 * 对字符和字符串进行utf-8方式编码，并写入文件中(通过字符转换流)
	 */
	public void testTestFile() throws IOException {
		// 用utf-8编码方式对字符串和字符进行编码，并写入文件中
		OutputStreamWriter osw = 
				new OutputStreamWriter(
						new FileOutputStream(
								"IO/byteTOchar/demo.txt"),"utf-8");
		osw.write('中');
		osw.write("ABC中国");
		osw.close();
	}
	
	/**
	 * @throws IOException
	 * 对文件中字符 进行utf-8方式的解码，并进行打印输出(因为返回的就是字符而不是字节)
	 */
	@Test
	public void testReader() throws IOException {
		// 一个字节一个字节的读取文件中的字节并打印输出
		Reader isr = 
				new InputStreamReader(
						new BufferedInputStream(
								new FileInputStream(
										"IO/byteTOchar/demo.txt")),"utf-8");
		// in.read()从文件中读取byte然后解码为字符
		// 返回，填充到int的低16位
		int n ;
		while((n = isr.read())!=-1) {
			char ch = (char)n;
			System.out.print(ch);
			//System.out.print(StringUtils.leftPad(Integer.toBinaryString(n & 0xff), 8, '0') + " ");
		}
		isr.close();
	}
}
