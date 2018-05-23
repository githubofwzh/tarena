package day02;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author levono
 * 队列：first input first output (先进先出)接触的比较少 
 * LinkedList实现了Queue
 * Queue类的offer() poll() peek()方法实例
 * 	boolean offer(object) 是从队尾添加一个元素，添加成功返回true
 * 	poll() 从队列的对首取出并删除元素
 * 	peek() 从队列的队首取出但是不删除元素
 */
public class QueueDemo { 
	public static void main(String[] args) {
		Duquetest();
	}
	
	/**
	 * 队列：first input first output (先进先出)接触的比较少 
	 * LinkedList实现了Queue
	 * Queue类的offer() poll() peek()方法实例
	 * 	boolean offer(object) 是从队尾添加一个元素，添加成功返回true
	 * 	poll() 从队列的对首取出并删除元素
	 * 	peek() 从队列的队首取出但是不删除元素
	 */
	public static void Queuetest() {
		Queue<String> queue = new LinkedList<String>();
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		System.out.println(queue);// 1.有顺序 [a, b, c]
		String str = queue.peek();// 2.验证先取到的是第一个队首元素，且不删除
		System.out.println("str ======= " + str); // str ======= a
		int i = 0;
		// 3.验证poll()取得是队列的队首元素且删除队列中的元素
		//	queue的第1个元素 =========a
		//	queue的第2个元素 =========b
		//	queue的第3个元素 =========c
		while(queue.size() > 0) {
			System.out.println("queue的第"+(++i)+"个元素 =========" + queue.poll());
		}
	}
	
	
	/**
	 * 双队列(队列两端都可以进出)和栈(双队列的一端封死，只能从同一个端进出：first input last output)
	 * push() 和 pop()
	 * 
	 */
	public static void Duquetest() {
		Deque<String> deque = new LinkedList<String>();
		deque.push("a"); // == deque.offerFirst("a");
		deque.push("b");// == deque.offerFirst("b");
		deque.push("c");// == deque.offerFirst("c");
		System.out.println(deque);// 1.有顺序 [a, b, c]
		String str = deque.peek();// 2.验证先取到的是第一个队首元素，且不删除
		System.out.println("str ======= " + str); // str ======= a
		int i = 0;
		// 3.验证poll()取得是队列的队首元素且删除队列中的元素
		//	queue的第1个元素 =========c
		//	queue的第2个元素 =========b
		//	queue的第3个元素 =========a
		while(deque.size() > 0) {
			System.out.println("queue的第"+(++i)+"个元素 =========" + deque.pop());
		}
	}
}
