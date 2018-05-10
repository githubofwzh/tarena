package day03;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author levono
 * 统计各个pm2.5地点的最大值
 */
public class TongJiZuiDaTest1 {
	public static void main(String[] args) {
		String str = "a=12;b=23;c=34;a=23;b=45;c=89";
		tjMax(str); // {a=23, b=45, c=89}
	}
	
	/**
	 * @param str
	 * str 必须有格式要求，"key=value;..",如""
	 */
	public static void tjMax(String str) {
		Map<String ,Integer> map = 
				new HashMap<String,Integer>();
		//
		String[] strs = str.split("[=,;]");
		//遍历整个数组，组装成集合
		// [key1,value1,key2,value2,key3,value3,...]
		// 0		1	2		3	4		5	..
		for(int i = 0; i< strs.length; i+=2) {
			String key = strs[i];
			int value = Integer.parseInt(strs[i+1]);
			if(map.containsKey(key)) {// 如果key已经存在，说明不是第一次统计，需要跟集合中保存着的数据对比，重新保存一个最大值，保证key对应的value是一个最大值
				int v = map.get(key);
				map.put(key, Math.max(value, v));
			}else {// 说明是第一次统计，直接进行保存
				map.put(key, value);
			}
		}
		System.out.println(map);
		
		//利用key的迭代，实现将map结果进行输出
		// 1) 得到所有key的集合
		// 2) 迭代key的集合
		// 3) 在迭代时候可以利用get获取value
		System.out.println("利用key的迭代，输出：" );
		Set<String> keySet = map.keySet();
		// keySet 包含所有的地点：a,b,c,...
		for(String key : keySet) {
			int value = map.get(key);
			// key 是地点，value是地点对应的最大值
			System.out.println(key+"|"+value);
		}
		
		//利用entry set 进行迭代
		//这里的泛型：表示set集合中的元素是Entry类型
		//而Entry中的属性是String 和 Integer类型
		// Entry(条目)：是Map的一个内部类接口，必须导包才能用，
		Set<Entry<String , Integer>> entrySet = 
				map.entrySet();
		//每个Entry中key是String类型，value是Integer类型
		for(Entry<String ,Integer> entry : entrySet) {
			//e中的key就是统计地点
			//e中的Value就是pm2.5的值
			System.out.println(entry.getKey() + "|" + entry.getValue());
		}
		
		
	}
}
