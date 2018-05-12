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
	 * ����File���ļ���Ϣ�鿴����
	 * file.length() �鿴�ļ��Ĵ�С (��λ��byte)��������ļ��У�����0byte
	 * file.lastModified() �鿴�ļ�����޸ĵ�ʱ��
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
	 * ���·��  �� ����·�������
	 * getAbsolutePath() 
	 * getCanonicalPath() ��׼�ľ���·��
	 */
	public static void test2() throws IOException {
		//����·�������·��
		//����·������/��ʼ��·��
		//���·�����ӵ�ǰĿ¼��ʼ��Java����
		//java���������Ŀ¼����eclipse������Ŀ
		//���ڵ��ļ��С�
		//new File(".")ʹ�����·������file����
		//.�ľ���λ�ã�����·���������
		File current = new File("./src");
		//Absolute ���Ե�Path·��
		String path1 = current.getAbsolutePath();
		//Canonical �淶�ľ���·������׼�ģ�
		String path2 = current.getCanonicalPath();
		System.out.println(path1);
		System.out.println(path2);
	}
	
	/**
	 * �� createNewFile()
	 */
	public static void test3() {
		// �ڵ�ǰĿ¼��eclipse��Ŀ�ļ��У��д������ļ�
		String path = "demo.txt";
		File  file = new File(path);
		boolean success;
		try {
			success = file.createNewFile();
			if(success) {
				System.out.println("�����ɹ�");
			}
			System.out.println(file.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ɾ delete() 
	 * ���� : ������ļ���ֻ��ɾ����ɾ��Ȩ�޵��ļ�
	 * 		������ļ��У�ֻ��ɾ�����ļ��У���Ŀ¼�²������κ����ļ��к��ļ�
	 */
	public static void test4() {
		//ɾ���ļ�
		File file = new File("demo.txt");
		boolean success = file.delete();
		if(success) {
			System.out.println("ɾ���ɹ�");
		}
		System.out.println(file.exists());
		
	}
	
}
