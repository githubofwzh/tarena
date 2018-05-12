package day05;

import java.io.File;
import java.io.IOException;

/**
 * @author levono
 * File���Ŀ¼�Ĳ�����������
 */
public class DirectorTest2 {
	public static void main(String[] args) {
		test();
		test2();
		test3();
	}
	
	/**
	 * ����mkdir() �����������ļ���
	 *    mkdirs()������һϵ���ļ���
	 * �� :isDirectory()
	 */
	public static void test() {
		//�ڵ�ǰĿ¼�д����ļ���demo
		File dir = new File("demo");
		//success �ɹ�
		boolean success = dir.mkdir();
		if(success) {
			System.out.println("�ɹ������ļ���");
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
	 * ɾ
	 */
	public static void test2() {
		File dir = new File("demo");
		boolean success = dir.delete();
		if(success) {
			System.out.println("Ŀ¼ɾ���ɹ�");
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
	 * ����mkdirs()  ����һϵ���ļ���
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
