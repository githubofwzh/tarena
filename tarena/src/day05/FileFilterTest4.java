package day05;

import java.io.File;
import java.io.FileFilter;

/**
 * @author levono
 * �ļ��������Ľ���
 */
public class FileFilterTest4 {
	public static void main(String[] args) {
//		test();
		test2();
	}
	
	/**
	 * �ļ���������FileFilter
	 * listfiles(FileFilter)����ʹ��
	 */
	public static void test() {
		//FileFilter�ǽӿ� Filter:������
		//�ļ����������������ļ����˹��򣨷�����
		//--�������з���true�ĲŻᱻ����
		FileFilter filter = new FileFilter() {
			//���򣺽����ļ����ܾ��ļ���
			public boolean accept(File pathname) {
				return pathname.isFile();
			}
		};
		File f1 = new File("c:/Windows");
		File f2 = new File("D:/Git/gitdemo/tarena/tarena/.classpath");
		System.out.println(filter.accept(f1));
		System.out.println(filter.accept(f2));
		//˵����filterֻ�ܽ����ļ�
		//�޸�accept�������Ըı���ܽ����
		//���Ź���(��������)�Ĳ�ѯ�ļ��е�����
		File dir = new File("C:/Windows");
		//filter �ǹ���������listFiles�Ὣdir��ÿ��
		//����Ŀsub����accept(sub)��������ܣ�����true
		//����Ϊ����ֵ�ŵ�������
		File[] files = dir.listFiles(filter);
		//files ������ֻ���ļ���û���ļ���
		for(File file : files) {
			System.out.println(file);
		}
	}
	
	/**
	 * ������ʾĿ¼�µ���Ŀ¼
	 * ����ֻ�ܽ����ļ��еĹ�����
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
