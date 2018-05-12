package day04;

import java.io.File;

public class FileDemoTest1 {
	public static void main(String[] args) {
		test3();
	}
	
	/**
	 * ��֤Ŀ¼�ָ���
	 */
	public static void test() {
		//File �����ļ�/�ļ���
		//�����ļ�����ֻ�Ǵ����ڴ����
		//�����ļ�·���ָ�����3��д��
		// File.separator���Զ��仯��windows -> ��б��"\" Linux->"/"
		String path = "demo"+File.separator+"hello.txt";
		System.out.println(path);
		//windows ר��
		String path2 = "demo/hello.txt";
		//ͨ��д����windows linux unix(mac)
		String path3 = "demo/hello.txt";
		//����file����
		File file = new File(path3);
	}
	
	/**
	 * exist() ʹ�ã��ж��ļ��Ƿ��ڴ����д��ڣ�����"��ɾ�Ĳ�"�еĲ�
	 * Ҳ��Ϊ����֤ new File() ֻ�����ڴ���󣬲��Ǵ���Ӳ���ļ�
	 */
	public static void test2()  {
		String path = "C:/Windows";
		String path2 = "demo/hello.txt";
		String path3 = "demo/hello.txt";
		File file = new File(path3);
		File file1 = new File(path);
		File file2 = new File(path2);
		//���file1��Ӧ��Ӳ��λ���ϵ��ļ��Ƿ����
		System.out.println(file1.exists());
		System.out.println(file2.exists());
	}
	
	/**
	 * isFile() isDirectory() ������ʾ����Ҳ������"��ɾ�Ĳ�"�еĲ�
	 * �ж����ļ� ���� �ļ���
	 */
	public static void test3()  {
		String path = "C:/Windows";
		String path2 = "D:/Git/gitdemo/tarena/tarena/.classpath";
		File file1 = new File(path);
		File file2 = new File(path2);
		//���file1��Ӧ��Ӳ��λ���ϵ��ļ��Ƿ����
		System.out.println(file1.isFile());
		System.out.println(file1.isDirectory());
		System.out.println(file2.isFile());
		System.out.println(file2.isDirectory());
	
	}
}
