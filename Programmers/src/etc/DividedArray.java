package etc;

import java.util.*;

public class DividedArray {

	public static void main(String[] args) {
		int[] arr = {
				2, 36, 1, 3
		};
		
		solution(arr, 1);
	}

    public static int[] solution(int[] arr, int divisor) {
    	int[] answer;
    	
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : arr) {
        	if(num % divisor == 0) {
        		pq.add(num);
        	}
        }
              
        if(pq.isEmpty()) {
        	answer = new int[1];
        	answer[0] = 1;
        } else {
        	int size = pq.size();
        	answer = new int[size];
        	
        	for(int i=0; i<size; i++) {
        		answer[i] = pq.poll();
        	}
        }
        
        return answer;
    }
}
