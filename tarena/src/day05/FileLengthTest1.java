package day05;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileLengthTest1 {
	public static void main(String[] args) {
		test();
		try {
			test2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test3();
		test4();
	}
	
	/**
	 * 测试File的文件信息查看方法
	 * file.length() 查看文件的大小 (单位：byte)；如果是文件夹，返回0byte
	 * file.lastModified() 查看文件最后修改的时间
	 */
	public static void test() {
		String path = "D:/googledownload/Stools/CentOS-7-x86_64-DVD-1708.iso";
		File file = new File(path);
		long size = file.length();
		long time = file.lastModified();
		System.out.println(size + "byte");
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		System.out.println(sdf.format(time));
	}
	
	/**
	 * @throws IOException
	 * 相对路径  和 绝对路径的理解
	 * getAbsolutePath() 
	 * getCanonicalPath() 标准的绝对路径
	 */
	public static void test2() throws IOException {
		//绝对路径和相对路径
		//绝对路径：从/开始的路径
		//相对路径：从当前目录开始，Java中是
		//java软件的启动目录，在eclipse中是项目
		//所在的文件夹。
		//new File(".")使用相对路径创建file对象
		//.的绝对位置（绝对路径）在哪里？
		File current = new File("./src");
		//Absolute 绝对的Path路径
		String path1 = current.getAbsolutePath();
		//Canonical 规范的绝对路径（标准的）
		String path2 = current.getCanonicalPath();
		System.out.println(path1);
		System.out.println(path2);
	}
	
	/**
	 * 增 createNewFile()
	 */
	public static void test3() {
		// 在当前目录（eclipse项目文件夹）中创建新文件
		String path = "demo.txt";
		File  file = new File(path);
		boolean success;
		try {
			success = file.createNewFile();
			if(success) {
				System.out.println("创建成功");
			}
			System.out.println(file.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 删 delete() 
	 * 条件 : 如果是文件，只能删除有删除权限的文件
	 * 		如果是文件夹，只能删除空文件夹，即目录下不能有任何子文件夹和文件
	 */
	public static void test4() {
		//删除文件
		File file = new File("demo.txt");
		boolean success = file.delete();
		if(success) {
			System.out.println("删除成功");
		}
		System.out.println(file.exists());
		
	}
	
}
