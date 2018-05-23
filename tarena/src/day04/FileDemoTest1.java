package day04;

import java.io.File;

public class FileDemoTest1 {
	public static void main(String[] args) {
		test3();
	}
	
	/**
	 * 验证目录分隔符
	 */
	public static void test() {
		//File 代表文件/文件夹
		//创建文件对象：只是创建内存对象
		//关于文件路径分隔符：3种写法
		// File.separator会自动变化：windows -> 反斜线"\" Linux->"/"
		String path = "demo"+File.separator+"hello.txt";
		System.out.println(path);
		//windows 专用
		String path2 = "demo/hello.txt";
		//通用写法：windows linux unix(mac)
		String path3 = "demo/hello.txt";
		//创建file对象
		File file = new File(path3);
	}
	
	/**
	 * exist() 使用，判断文件是否在磁盘中存在，属于"增删改查"中的查
	 * 也是为了验证 new File() 只创建内存对象，不是创建硬盘文件
	 */
	public static void test2()  {
		String path = "C:/Windows";
		String path2 = "demo/hello.txt";
		String path3 = "demo/hello.txt";
		File file = new File(path3);
		File file1 = new File(path);
		File file2 = new File(path2);
		//检查file1对应的硬盘位置上的文件是否存在
		System.out.println(file1.exists());
		System.out.println(file2.exists());
	}
	
	/**
	 * isFile() isDirectory() 方法的示例，也是属于"增删改查"中的查
	 * 判断是文件 还是 文件夹
	 */
	public static void test3()  {
		String path = "C:/Windows";
		String path2 = "D:/Git/gitdemo/tarena/tarena/.classpath";
		File file1 = new File(path);
		File file2 = new File(path2);
		//检查file1对应的硬盘位置上的文件是否存在
		System.out.println(file1.isFile());
		System.out.println(file1.isDirectory());
		System.out.println(file2.isFile());
		System.out.println(file2.isDirectory());
	
	}
}
