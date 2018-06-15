package day10;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

/**
 * @author levono
 * 上一个案列介绍了Reader/Writer 的OutputStreamWriter 和 InputStreamReader 字符转换流读写文件。
 * 该类是对字符转换流的扩展，演示PrintWriter类的使用
 */
public class PrintWriterDemo {
	/**
	 * 功能：利用PrintWriter写出文本文件
	 * PrintWriter最经典的用法，也是最底层的一个构造方法（只有参数是一个流的时候才有自动刷新的参数），其他的构造方法都是调用了这个方法。
	 * println()方法会自动执行flush()方法，print()方法不会
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
//	@Test
	public void printWriterTest1() throws UnsupportedEncodingException, FileNotFoundException {
		PrintWriter pw = 
				new PrintWriter(
						new OutputStreamWriter(
								new BufferedOutputStream(
										new FileOutputStream(
												"IO/PrintWriter/demo.txt")),"utf-8"),true);
		pw.println("hello world!");
		pw.println("整个世界！");
		pw.close();
	}
	
	/**
	 * PrintWriter类更灵活的用法，缺点是其默认不自动刷新（结果就是：如果没有达到缓冲区大小，文本内容不会刷新写入到文本文件中）
	 * 功能：利用PrintWriter(filename,charSet)更方便的写出文本文件。
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
//	@Test
	public void printWriter2() throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter pw = 
				new PrintWriter("IO/PrintWriter/demo2.txt","utf-8");
		pw.println("使用PrintWriter(filename,CharSet)进行文本文件的写出，该构造器没有自动刷新的功能");
		pw.close();//如果没有关闭或者没有执行pw.flush()，文本内容只会保存在缓冲区，不会写出到文件中
	}
	
	/**
	 * 功能：最常见的文本文件读取方式
	 * @throws IOException
	 */
	@Test
	public void bufferedReaderTest() throws IOException {
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(
								new BufferedInputStream(
										new FileInputStream("IO/PrintWriter/demo.txt")),"utf-8"));
		String line;
		//每次读取一行，返回null表示读取到EOF
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}
	
	
}
