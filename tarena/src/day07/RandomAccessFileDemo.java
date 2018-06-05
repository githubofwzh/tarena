package day07;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author levono
 *	
 */
public class RandomAccessFileDemo {
	/**
	 * 在任意位置添加一个新的联系人。
	 * 利用RandomAccessFile.write(byte[] buf)写入
	 * 利用RandomAccessFile.seek(long point) 进行定位
	 * seek(point)特点:如果文件是空的，起始位置之前的内容空格填充。
	 * 
	 * @param raf 已打开的文件
	 * @param n	第几位联系人，决定文件中的位置  
	 * @param id 联系人的序号  4个byte
	 * @param time 添加联系人时间  8个byte
	 * @param name 新增联系人姓名 50个byte
	 * @param mobile 新增联系人的手机号 30个byte
	 * @param address 新增联系人的地址  (372-92)个byte
	 * @throws IOException 
	 */
	public void writeContext(RandomAccessFile raf,
			int n,int id ,Date time,String name,
			String mobile,String address) throws IOException {
		long start = 372 * (n - 1);
		raf.seek(start);
		raf.writeInt(id);
		raf.seek(start+4);
		raf.writeLong(time.getTime());
		raf.seek(start+12);
		raf.write(name.getBytes());
		raf.seek(start + 62);
		raf.write(mobile.getBytes());
		raf.seek(start + 92);
		raf.write(address.getBytes());
	}
	
	/**
	 * 读取电话本中的联系人信息
	 * 正常读取的时候 ，指针已经变化了，也可以用seek(long pointer) 每次都重新定位
	 * @param raf 打开或者创建文件
	 * @param n 查询的第几位联系人
	 * @return 联系人信息
	 * @throws IOException
	 */
	public Map readContext(RandomAccessFile raf,
			int n) throws IOException {
		Map<String,Object> map = new HashMap<String,Object>();
		long start = 372 * (n - 1);
		raf.seek(start);
		int id = raf.readInt();
		long time = raf.readLong();
		Date date = new Date(time);
		byte[] name_byte = new byte[50];
		raf.read(name_byte);
		String name = new String(name_byte).trim();
//		raf.seek(62);
		byte[] mobile_byte = new byte[30];
		raf.read(mobile_byte);
		String mobile = new String(mobile_byte).trim();
//		raf.seek(92);
		byte[] address_byte = new byte[372 - 92];
		raf.read(address_byte);
		String address = new String(address_byte).trim();
		map.put("id", id);
		map.put("time", date);
		map.put("name", name);
		map.put("mobile", mobile);
		map.put("address", address);
		return map;
	}
	
	@Test
	public void test() throws IOException {
		RandomAccessFile raf = 
				new RandomAccessFile("demo3.txt", "rw");
		writeContext(raf, 2, 2, new Date(), "吴志鸿", "18367925454", "浙江杭州");
		Map<String,Object> map = readContext(raf, 1);
		Map<String,Object> map2 = readContext(raf, 2);
		System.out.println(map.toString());
		System.out.println(map2.toString());
		raf.close();
		
	}
}
