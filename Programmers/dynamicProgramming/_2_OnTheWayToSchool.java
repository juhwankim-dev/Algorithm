package dynamicProgramming;

import java.util.*;

public class _2_OnTheWayToSchool {
	static int route = 0;
	
	public static void main(String[] args) {
		int[][] puddles = {
				{2,2}
		};
		System.out.println(solution(4, 3, puddles));
	}

    public static int solution(int m, int n, int[][] puddles) {
        Arrays.sort(puddles, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
        	
        });
        
        int pudLen = puddles.length;
        long badRoute = 1;
        int startX = 1;
        int startY = 1;
        for(int i=0; i<pudLen; i++) {
        	dfs(startX, startY, puddles[i][1], puddles[i][0]);
        	badRoute *= route;
        	route = 0;
        	startX = puddles[i][1];
        	startY = puddles[i][0];
        }
        dfs(startX, startY, n, m);
        badRoute *= route;
        
        return (int) ((allRoute(n, m) - badRoute)%1000000007);
    }
    
    public static void dfs(int startX, int startY, int endX, int endY) {
    	if(startX==endX && startY== endY) {
    		route++;
    		return;
    	}
    	
    	if(startX < endX) dfs(startX+1, startY, endX, endY);
    	if(startY < endY) dfs(startX, startY+1, endX, endY);
    }
    
    public static long allRoute(int m, int n) {
    	if(m==1 || n==1) {
    		return 1;
    	}
    	
    	return allRoute(m-1, n) + allRoute(m, n-1);
    }
}
