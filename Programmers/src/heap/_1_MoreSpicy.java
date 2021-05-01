package heap;

import java.util.*;

public class _1_MoreSpicy {

	public static void main(String[] args) {
		int[] scoville = {1,2,3,9,10,12};
		int answer = 0;
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		for(int s : scoville) {
			priorityQueue.add(s);
		}
		
		int count = 0;
		while(priorityQueue.peek() < 7) {
			if(priorityQueue.size() == 1) {
				answer = -1;
				break;
			}
			int first = priorityQueue.poll();
			int second = priorityQueue.poll();
			priorityQueue.add(first + second*2);
			count++;
		}
		
		System.out.println(count);
	}

}
