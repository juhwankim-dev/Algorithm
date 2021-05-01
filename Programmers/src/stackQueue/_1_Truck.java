package stackQueue;

import java.util.*;

public class _1_Truck {

	public static void main(String[] args) {
		int[] truck_weights = {7, 4, 5, 6};
		System.out.println(solution(2, 10, truck_weights));
	}

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<bridge_length; i++) {
        	queue.add(0);
        }
        
        int i = 0;
        int weightSum = 0; // 현재 다리에 있는 차들의 무게 합
        int size = truck_weights.length;
        while(!queue.isEmpty()) { // 큐가 다 비워질때 까지
        	weightSum -= queue.poll();
        	if(i < size) {
        		if(weightSum + truck_weights[i] <= weight) {
        			queue.add(truck_weights[i]);
        			weightSum += truck_weights[i++];
        		} else {
        			queue.add(0);
        		}
        	}
        	answer++; // 1초증가
        } 
        
        return answer;
    }
}
