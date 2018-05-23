package day05;

import java.io.File;
import java.io.IOException;

/**
 * @author levono
 * File类对目录的操作方法介绍
 */
public class DirectorTest2 {
	public static void main(String[] args) {
		test();
		test2();
		test3();
	}
	
	/**
	 * 增：mkdir() ：创建单个文件夹
	 *    mkdirs()：创建一系列文件夹
	 * 查 :isDirectory()
	 */
	public static void test() {
		//在当前目录中创建文件夹demo
		File dir = new File("demo");
		//success 成功
		boolean success = dir.mkdir();
		if(success) {
			System.out.println("成功创建文件夹");
			try {
				System.out.println(dir.getCanonicalPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(dir.isDirectory());
		}
	}
	
	/**
	 * 删
	 */
	public static void test2() {
		File dir = new File("demo");
		boolean success = dir.delete();
		if(success) {
			System.out.println("目录删除成功");
			System.out.println(dir.isDirectory());
			System.out.println(dir.exists());
			try {
				System.out.println(dir.getCanonicalPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 增：mkdirs()  增加一系列文件夹
	 */
	public static void test3() {
		String path = "test/demo/data/abc";
		File dirs = new File(path);
		dirs.mkdirs();
		try {
			System.out.println(dirs.getCanonicalFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
