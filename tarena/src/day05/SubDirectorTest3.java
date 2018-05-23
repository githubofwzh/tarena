package day05;

import java.io.File;
import java.util.Arrays;

public class SubDirectorTest3 {
	public static void main(String[] args) {
		test1();
	}
	
	/**
	 * 查看文件夹内容
	 * listFiles()
	 */
	public static void test1() {
		// 获取一个文件夹的全部内容
		File dir = new File(".");
		File dir2 = new File("C:/Windows");
		// 获取dir文件夹的全部内容(全部孩子)
		File[] files = dir.listFiles();
		Arrays.sort(files);
		//System.out.println(Arrays.toString(files));
		for(File file : files) {
			//如果是文件夹就输出[文件夹]
			//文件名直接输出
			if(file.isDirectory()) {
				System.out.println("["+file+"]");
			}else
				System.out.println(file);
			
		}
	}
}
