package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest01 {
	public static void main(String[] args) {
//		testWriteFile();
//		testRead();
//		testRead2();
		testWrite1();
	}
	
	/**
	 * д���ļ�
	 */
	public static void testWriteFile() {
		//��һ���ļ�
		//����ļ�ָ���λ��
		//д�����ݣ��ڵ�ǰָ��λ��д��һ��int�ĵ�8λ
		//����ļ�ָ���λ��
		//д������
		try {
			RandomAccessFile raf = 
					new RandomAccessFile("demo.dat","rw");
			long index = raf.getFilePointer();
			System.out.println(index);
			raf.write(50);//1
			index = raf.getFilePointer();
			System.out.println(index);
			raf.write(0xca);//2
			index = raf.getFilePointer();
			System.out.println(index);
			raf.write(256);//3
			index = raf.getFilePointer();
			System.out.println(index);
			raf.write(0x100);//4
			index = raf.getFilePointer();
			System.out.println(index);
			raf.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 读入文件
	 * 验证256读入的是00
	 * 验证文件末尾是-1.
	 */
	public static void testRead() {
		try {
			RandomAccessFile raf = 
					new RandomAccessFile("demo.dat","r");
			long index = raf.getFilePointer();
			System.out.println(index);//0
			int b = raf.read();
			System.out.println(
					Integer.toBinaryString(b));//50
			index = raf.getFilePointer();
			System.out.println(index);//1
			b = raf.read();
			System.out.println(
					Integer.toBinaryString(b));//
			index = raf.getFilePointer();
			System.out.println(index);//2
			b = raf.read();
			System.out.println(
					Integer.toBinaryString(b));
			index = raf.getFilePointer();
			System.out.println(index);//3
			b = raf.read();
			System.out.println(
					Integer.toBinaryString(b));
			index = raf.getFilePointer();
			System.out.println(index);//4
			b = raf.read();
			System.out.println(
					Integer.toBinaryString(b));
			index = raf.getFilePointer();//4
			System.out.println(index);
			b = raf.read();
			System.out.println(
					b);//-1
			index = raf.getFilePointer();
			System.out.println(index);//4
			raf.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取文件的模式化写法(标准写法)
	 * 重要的是要关闭文件
	 */
	public static void testRead2() {
		try {
			RandomAccessFile raf = 
					new RandomAccessFile("demo.dat","r");
			int b;
			while((b = raf.read()) != -1) {
				System.out.println(Integer.toBinaryString(b));
			}
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 实例:利用byte[]数组批量插入一堆数据
	 * 		new RandomAccessFile().write(byte[] byte)
	 */
	public  static void testWrite1() {
		try {
			RandomAccessFile raf = 
					new RandomAccessFile("demo2.bat","rw");
			byte[] buf = {50,(byte)202,0,(byte)0xff};
			raf.write(buf);
			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
