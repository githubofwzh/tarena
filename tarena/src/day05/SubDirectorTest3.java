package day05;

import java.io.File;
import java.util.Arrays;

public class SubDirectorTest3 {
	public static void main(String[] args) {
		test1();
	}
	
	/**
	 * �鿴�ļ�������
	 * listFiles()
	 */
	public static void test1() {
		// ��ȡһ���ļ��е�ȫ������
		File dir = new File(".");
		File dir2 = new File("C:/Windows");
		// ��ȡdir�ļ��е�ȫ������(ȫ������)
		File[] files = dir.listFiles();
		Arrays.sort(files);
		//System.out.println(Arrays.toString(files));
		for(File file : files) {
			//������ļ��о����[�ļ���]
			//�ļ���ֱ�����
			if(file.isDirectory()) {
				System.out.println("["+file+"]");
			}else
				System.out.println(file);
			
		}
	}
}
