package dynamicProgramming;

import java.util.*;

public class _2_OnTheWayToSchool {
	static int[][] map;
	public static void main(String[] args) {
		int[][] puddles = {
				{2,2}
		};
		System.out.println(solution(4, 3, puddles));
	}

    public static int solution(int m, int n, int[][] puddles) {
		/*
		 * Arrays.sort(puddles, new Comparator<int[]>() {
		 * 
		 * @Override public int compare(int[] o1, int[] o2) { if(o1[0] == o2[0]) {
		 * return o1[1] - o2[1]; } return o1[0] - o2[0]; }
		 * 
		 * });
		 */
        
        map = new int[n][m];
        int len = puddles.length;
    	for(int i=0; i<len; i++) {
    		int x = puddles[i][0]-1;
    		int y = puddles[i][1]-1;
    		map[x][y] = -1;
    	}
        
        dfs(0, 0, n-1, m-1);
        
        return map[n-1][m-1];
    }
    
    public static void dfs(int x, int y, int n, int m) {
    	if(x>n || y>m) return;
    	
    	switch(map[x][y]) {
    	case -1:
    		return;
    	case 0:
    		map[x][y] = 1;
    		break;
    	default:
    		map[x][y] += (++map[x][y] % 1000000007);
    	}
    	
<<<<<<< HEAD:Programmers/src/dynamicProgramming/_2_OnTheWayToSchool.java
    	// ³»ºÎ
    	map[0][0] = 1;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(map[i][j] == -1) {
        			map[i][j] = 0;
        			continue;
        		}
        		
                if(i != 0)
                	map[i][j] += map[i-1][j] % 1000000007;

                if(j != 0)
                	map[i][j] += map[i][j-1] % 1000000007;
        	}
        }

        return map[n-1][m-1];
=======
    	dfs(x+1, y, n, m);
    	dfs(x, y+1, n, m);
>>>>>>> parent of 268f116 (Update _2_OnTheWayToSchool.java):Programmers/dynamicProgramming/_2_OnTheWayToSchool.java
    }
}

/*
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
*/

/*
public class _2_OnTheWayToSchool {
public static void main(String[] args) {
	int[][] puddles = {
	
	};
	System.out.println(solution(100, 100, puddles));
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
    
    long answer = dfs(1, 1, m, n, puddles);
    
    return (int) (answer%1000000007);
}

public static int dfs(int x, int y, int n, int m, int[][] puddles) {
	if(x>n || y>m) {
		return 0;
	} else if(x==n && y==m) {
		return 1;
	} else if(isPungDung(x, y, puddles)) {
		return 0;
	}
	
	return dfs(x+1, y, n, m, puddles) + dfs(x, y+1, n, m, puddles);
}

public static boolean isPungDung(int x, int y, int[][] puddles) {
	int len = puddles.length;
	for(int i=0; i<len; i++) {
		if(puddles[i][0] == x && puddles[i][1] == y) {
			return true;
		}
	}
	
	return false;
}
}
*/