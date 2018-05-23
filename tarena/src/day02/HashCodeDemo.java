package day02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class HashCodeDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Map<String,Integer> map = 
				new HashMap<String,Integer>(14000);// 考虑加载因子要小于75%，提交插入元素的性能
		for(int i=0;i<10000;i++) {
			String key = UUID.randomUUID().toString();
			list.add(key);
			map.put(key, i);
		}
		String key = list.get(9999);
		System.out.println("第10000个元素" + key);
		//查找生产key对应的位置i
		int index = list.indexOf(key);
		int in = map.get(key);
		System.out.println(index);
		System.out.println(in);
		
		// 性能比较 1084869,606722774
		// 		 1526894,19363093180
		long t1 = System.nanoTime();
		for(int i=0 ;i<10000;i++) {
			index = list.indexOf(key);
		}
		long t2 = System.nanoTime();
		for(int i=0 ;i<10000;i++) {
			in = map.get(key);
		}
		long t3 = System.nanoTime();
		System.out.println((t3-t2)+","+(t2-t1));
	}
}
