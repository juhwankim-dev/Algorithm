package dynamicProgramming;

import java.util.*;

public class _1_IntegerTriangle {

	public static void main(String[] args) {
		int[][] triangle = {
				{7},
				{3, 8},
				{8,1,0},
				{2,7,4,4},
				{4,5,2,6,5}
		};
		System.out.println(solution(triangle));
	}

    public static int solution(int[][] triangle) {
        int answer = 0;
        
        int depth = triangle.length;
        for(int i=1; i<depth; i++) {
        	int width = triangle[i].length;
        	int j=1;
        	
        	triangle[i][0] += triangle[i-1][0];
        	while(j<width-1) {
        		triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        		j++;
        	}
        	triangle[i][width-1] += triangle[i-1][width-2];
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        for(int n : triangle[depth-1]) {
        	pq.add(n);
        }
        
        return pq.poll();
    }
}
