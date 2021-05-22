package etc;

import java.util.*;

public class Budget {

	public static void main(String[] args) {
		int[] d = {2, 2, 3, 3};
		System.out.println(solution(d, 9));
	}

    public static int solution(int[] d, int budget) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int cost : d) {
        	queue.add(cost);
        }
        
    	int amount = 0;
    	while(amount <= budget && !queue.isEmpty()) {
    		amount += queue.poll();
    	}
        
    	int answer = d.length - queue.size();
        return (amount > budget) ? answer-1 : answer;
    }
}
