package etc;

import java.util.*;

public class Delivery {
	static int[][] times;
	static HashSet<Integer> deliverableArea = new HashSet<>();
	
	public static void main(String[] args) {
		
		/*
		int[][] road = {
				{1,2,1},
				{2,3,3},
				{5,2,2},
				{1,4,2},
				{5,3,1},
				{5,4,2}
		};
		*/
		
		
		int[][] road = {
				{1,2,1},
				{1,3,2},
				{2,3,2},
				{3,4,3},
				{3,5,2},
				{3,5,3},
				{5,6,1}
		};
		
		
		System.out.println(solution(6, road, 4));
	}

	public static int solution(int N, int[][] road, int K) {
		times = new int[N][N];

		for (int i = 0; i < N; i++) {
			int from = road[i][0] - 1;
			int to = road[i][1] - 1;
			int time = road[i][2];
			
			if (times[from][to] == 0 || time < times[from][to]) {
				times[from][to] = time;
				times[to][from] = time;
			}
		}
		
		for(int i=1; i<N; i++) {
			dfs(N, K, 0, i, 0);
		}

		return deliverableArea.size() + 1;
	}
	
	public static void dfs(int N, int K, int from, int to, int deliveryTime) {
		if(from == to && deliveryTime > 0 && deliveryTime <= K) {
			deliverableArea.add(from);
			return;
		}
		
		for(int i=1; i<N; i++) {
			if(i != from) {
				if((times[from][i] != 0) && (deliveryTime + times[from][i] <= K)) {
					dfs(N, K, i, to, deliveryTime + times[from][i]);
				}
			}
		}
	}
}
