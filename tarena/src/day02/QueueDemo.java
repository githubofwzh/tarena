package day02;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author levono
 * ���У�first input first output (�Ƚ��ȳ�)�Ӵ��ıȽ��� 
 * LinkedListʵ����Queue
 * Queue���offer() poll() peek()����ʵ��
 * 	boolean offer(object) �ǴӶ�β���һ��Ԫ�أ���ӳɹ�����true
 * 	poll() �Ӷ��еĶ���ȡ����ɾ��Ԫ��
 * 	peek() �Ӷ��еĶ���ȡ�����ǲ�ɾ��Ԫ��
 */
public class QueueDemo { 
	public static void main(String[] args) {
		Duquetest();
	}
	
	/**
	 * ���У�first input first output (�Ƚ��ȳ�)�Ӵ��ıȽ��� 
	 * LinkedListʵ����Queue
	 * Queue���offer() poll() peek()����ʵ��
	 * 	boolean offer(object) �ǴӶ�β���һ��Ԫ�أ���ӳɹ�����true
	 * 	poll() �Ӷ��еĶ���ȡ����ɾ��Ԫ��
	 * 	peek() �Ӷ��еĶ���ȡ�����ǲ�ɾ��Ԫ��
	 */
	public static void Queuetest() {
		Queue<String> queue = new LinkedList<String>();
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		System.out.println(queue);// 1.��˳�� [a, b, c]
		String str = queue.peek();// 2.��֤��ȡ�����ǵ�һ������Ԫ�أ��Ҳ�ɾ��
		System.out.println("str ======= " + str); // str ======= a
		int i = 0;
		// 3.��֤poll()ȡ���Ƕ��еĶ���Ԫ����ɾ�������е�Ԫ��
		//	queue�ĵ�1��Ԫ�� =========a
		//	queue�ĵ�2��Ԫ�� =========b
		//	queue�ĵ�3��Ԫ�� =========c
		while(queue.size() > 0) {
			System.out.println("queue�ĵ�"+(++i)+"��Ԫ�� =========" + queue.poll());
		}
	}
	
	
	/**
	 * ˫����(�������˶����Խ���)��ջ(˫���е�һ�˷�����ֻ�ܴ�ͬһ���˽�����first input last output)
	 * push() �� pop()
	 * 
	 */
	public static void Duquetest() {
		Deque<String> deque = new LinkedList<String>();
		deque.push("a"); // == deque.offerFirst("a");
		deque.push("b");// == deque.offerFirst("b");
		deque.push("c");// == deque.offerFirst("c");
		System.out.println(deque);// 1.��˳�� [a, b, c]
		String str = deque.peek();// 2.��֤��ȡ�����ǵ�һ������Ԫ�أ��Ҳ�ɾ��
		System.out.println("str ======= " + str); // str ======= a
		int i = 0;
		// 3.��֤poll()ȡ���Ƕ��еĶ���Ԫ����ɾ�������е�Ԫ��
		//	queue�ĵ�1��Ԫ�� =========c
		//	queue�ĵ�2��Ԫ�� =========b
		//	queue�ĵ�3��Ԫ�� =========a
		while(deque.size() > 0) {
			System.out.println("queue�ĵ�"+(++i)+"��Ԫ�� =========" + deque.pop());
		}
	}
}
