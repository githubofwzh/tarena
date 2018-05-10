package day03;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author levono
 * ͳ�Ƹ���pm2.5�ص�����ֵ
 */
public class TongJiZuiDaTest1 {
	public static void main(String[] args) {
		String str = "a=12;b=23;c=34;a=23;b=45;c=89";
		tjMax(str); // {a=23, b=45, c=89}
	}
	
	/**
	 * @param str
	 * str �����и�ʽҪ��"key=value;..",��""
	 */
	public static void tjMax(String str) {
		Map<String ,Integer> map = 
				new HashMap<String,Integer>();
		//
		String[] strs = str.split("[=,;]");
		//�����������飬��װ�ɼ���
		// [key1,value1,key2,value2,key3,value3,...]
		// 0		1	2		3	4		5	..
		for(int i = 0; i< strs.length; i+=2) {
			String key = strs[i];
			int value = Integer.parseInt(strs[i+1]);
			if(map.containsKey(key)) {// ���key�Ѿ����ڣ�˵�����ǵ�һ��ͳ�ƣ���Ҫ�������б����ŵ����ݶԱȣ����±���һ�����ֵ����֤key��Ӧ��value��һ�����ֵ
				int v = map.get(key);
				map.put(key, Math.max(value, v));
			}else {// ˵���ǵ�һ��ͳ�ƣ�ֱ�ӽ��б���
				map.put(key, value);
			}
		}
		System.out.println(map);
		
		//����key�ĵ�����ʵ�ֽ�map����������
		// 1) �õ�����key�ļ���
		// 2) ����key�ļ���
		// 3) �ڵ���ʱ���������get��ȡvalue
		System.out.println("����key�ĵ����������" );
		Set<String> keySet = map.keySet();
		// keySet �������еĵص㣺a,b,c,...
		for(String key : keySet) {
			int value = map.get(key);
			// key �ǵص㣬value�ǵص��Ӧ�����ֵ
			System.out.println(key+"|"+value);
		}
		
		//����entry set ���е���
		//����ķ��ͣ���ʾset�����е�Ԫ����Entry����
		//��Entry�е�������String �� Integer����
		// Entry(��Ŀ)����Map��һ���ڲ���ӿڣ����뵼�������ã�
		Set<Entry<String , Integer>> entrySet = 
				map.entrySet();
		//ÿ��Entry��key��String���ͣ�value��Integer����
		for(Entry<String ,Integer> entry : entrySet) {
			//e�е�key����ͳ�Ƶص�
			//e�е�Value����pm2.5��ֵ
			System.out.println(entry.getKey() + "|" + entry.getValue());
		}
		
		
	}
}
