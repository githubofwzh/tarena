package day08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

/**
 * @author levono
 * 1.CopyFile1使用节点流FileInputStream /FileOutputStream 进行文件的复制 (效率低)
 * 2.CopyFile2对该功能进行优化(节点流的自我优化)
 * 3.CopyFile3对该功能进行使用api的优化，BufferedInputStream / BufferedOutputStream 
 * 4.CopyFile4对节点流构造器方法参数的研究，通过一个boolean类型来确定是对文件的改写 还是 追写内容
 * 
 */
public class CopyFileWithIODemo {
	//@Test
	/**
	 * 一个字节一个字节进行复制
	 * int n 是文件的内容
	 * @throws IOException
	 */
	public void CopyFile1() throws IOException {
		InputStream fis = 
				new FileInputStream("IO/Copy/srcFile.docx");
		
		OutputStream fos = 
				new FileOutputStream("IO/Copy/copyFile1.docx");
		
		int n  ;// 这个是读取的内容
		while((n = fis.read()) != -1) {
			fos.write(n);
		}
		System.out.println("文件复制完成！");
		fis.close();
		fos.close();
	}
	
	
	/**
	 * 对CopyFile1的优化：一堆一堆字节的读取和复制
	 * int n 是读取的字节长度 
	 * byte[] buf 是读取的文件内容
	 * fos.write(buf,0,n)：考虑最后一次可能不足数组长度，提高效率
	 * 这样优化的原理是硬盘中读取有顺序读取 和  随机读取两种模式，相对来说顺序读取的效率能够快很多，
	 * 使用字节数据就是为了实现顺序读取(固态硬盘没差别)
	 * @throws IOException
	 */
	//@Test
	public void CopyFile2() throws IOException {
		InputStream fis = 
				new FileInputStream("IO/Copy/srcFile.docx");
		
		OutputStream fos = 
				new FileOutputStream("IO/Copy/copyFile2.docx");
		byte[] buf = new byte[1024 * 8];//一次性读取的长度，这里才是读取的内容了
		int n  ;// 这个是读取的长度
		while((n = fis.read(buf)) != -1) {
			System.out.println(n);
			fos.write(buf,0,n);//如果最后一次读取不足数组长度，只写入真实长度的内容
		}
		System.out.println("文件复制完成！");
		fis.close();
		fos.close();
	}
	
	/**
	 * 通过sum公司提供的api进行性能优化，提高执行效率
	 * BufferedInputStream / BufferedOutputStream 内部也是各自有一个8k大小的缓冲数组，
	 * n是读取的字节内容，会先存入缓冲区中，
	 * 因为这种方式存在两个不同的缓冲区，而CopyFile2()共用了同一个缓冲区，所以效率比CopyFile3()更高，
	 * 优点是更方便，不用自己考虑缓冲区大小等问题。
	 * @throws IOException
	 */
	//@Test
	public void CopyFile3() throws IOException {
		BufferedInputStream fis = 
				new BufferedInputStream(
						new FileInputStream("IO/Copy/srcFile.docx"));
		
		BufferedOutputStream fos = 
				new BufferedOutputStream(
						new FileOutputStream("IO/Copy/copyFile3.docx"));
		
		int n  ;// 这个是读取的内容
		while((n = fis.read()) != -1) {
			fos.write(n);
		}
		System.out.println("文件复制完成！");
		fis.close();
		fos.close();
	}
	
	/**
	 * 研究节点流构造器方法中的boolean类型参数，选择是追加内容还是改写文件内容
	 * @throws IOException
	 */
	//@Test
	public void CopyFile4() throws IOException {
		File file = new File("IO/Copy/copyFile4.txt");
		BufferedOutputStream fos = 
				new BufferedOutputStream(
						new FileOutputStream(file,true));
		
		fos.write(10);
		System.out.println(file.length());
		fos.flush();//刷出(倾倒)缓冲区，可靠写硬盘
		fos.close();//先刷出缓冲，再关闭文件
	}
}
