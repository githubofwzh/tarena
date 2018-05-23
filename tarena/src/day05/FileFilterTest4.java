package day05;

import java.io.File;
import java.io.FileFilter;

/**
 * @author levono
 * 文件过滤器的介绍
 */
public class FileFilterTest4 {
	public static void main(String[] args) {
//		test();
		test2();
	}
	
	/**
	 * 文件过滤器：FileFilter
	 * listfiles(FileFilter)搭配使用
	 */
	public static void test() {
		//FileFilter是接口 Filter:过滤器
		//文件过滤器：声明的文件过滤规则（方法）
		//--过滤器中返回true的才会被接受
		FileFilter filter = new FileFilter() {
			//规则：接受文件，拒绝文件夹
			public boolean accept(File pathname) {
				return pathname.isFile();
			}
		};
		File f1 = new File("c:/Windows");
		File f2 = new File("D:/Git/gitdemo/tarena/tarena/.classpath");
		System.out.println(filter.accept(f1));
		System.out.println(filter.accept(f2));
		//说明：filter只能接受文件
		//修改accept方法可以改变接受结果！
		//带着过滤(接受条件)的查询文件夹的内容
		File dir = new File("C:/Windows");
		//filter 是过滤条件，listFiles会将dir中每个
		//子项目sub交给accept(sub)，如果接受，返回true
		//就作为返回值放到数组中
		File[] files = dir.listFiles(filter);
		//files 数组中只有文件，没有文件夹
		for(File file : files) {
			System.out.println(file);
		}
	}
	
	/**
	 * 查找显示目录下的子目录
	 * 测试只能接受文件夹的过滤器
	 */
	public static void test2() {
		File dir = new File("C:/Windows");
		File[] files = dir.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.getName().toLowerCase()
							.endsWith("txt");
			}
		});
		for(File file : files) {
			System.out.println(file);
		}
	}
}
