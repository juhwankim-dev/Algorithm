package _19_queue;

import java.util.*;

public class _2_card {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int num = 1;
		while(num <= N) {
			queue.add(num++);
		}
		
		while(queue.size() != 1) {
			queue.poll();
			queue.add(queue.poll());
		}
		
		System.out.println(queue.poll());
	}

}
