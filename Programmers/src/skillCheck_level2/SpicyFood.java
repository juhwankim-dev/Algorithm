package skillCheck_level2;

import java.util.*;

public class SpicyFood {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        
        for(int s : scoville) {
        	pQueue.add(s);
        }
        
        if(pQueue.peek() >= K) return 0;
        
        while(pQueue.peek() < K) {
        	if(pQueue.size() == 1) return -1;
        	int newScoville = pQueue.poll() + pQueue.poll() * 2;
        	pQueue.add(newScoville);
        	answer++;
        }

        return answer;
    }
}
