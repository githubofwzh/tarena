package day08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import org.junit.Test;

/**
 * 对象输入/输出流 
 * @author levono
 *
 */
public class ObjectIODemo {
	@Test
	public void testWriteObject() throws FileNotFoundException, IOException, ClassNotFoundException {
		//创建对象输出流
		//创建一个context对象
		//将对象写出到文件中
		//关闭文件
		ObjectOutputStream out = 
				new ObjectOutputStream(
						new BufferedOutputStream(
								new FileOutputStream("IO/Object/obj.dat")));
		Content c1 = new Content(1,new Date(),"吴志鸿","18367856363","浙江杭州");
		Content c2 = new Content(2,new Date(),"猫咪","18367866363","浙江金华");
		out.writeObject(c1);
		out.writeObject(c2);
		out.close();
		
		//创建对象输入流
		//创建一个context对象
		//从文件中读取对象并得到对象的属性值
		//关闭文件
		ObjectInputStream in = 
				new ObjectInputStream(
						new BufferedInputStream(
								new FileInputStream("IO/Object/obj.dat")));
		Object obj = in.readObject();
		Object obj2 = in.readObject();
//		Object obj3 = in.readObject(); 文件中只有两个对象，取第三个对象的操作会报错
		
		System.out.println(obj.toString());
		System.out.println(obj2.toString());
		
		
	}
}


