package greedy;

import java.util.*;

public class _5_ConnectIsland {

	public static int[] parent; 
	
	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
		System.out.println(solution(n, costs));
	}

    public static int solution(int n, int[][] costs) {
        // 간선의 길이 순서대로 정렬
        Arrays.sort(costs, new Comparator<int[]>(){
        	
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        });
        
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i; // 처음에는 자기 자신을 가르키도록
        }
        
        int totalCost = 0; // 총 비용
        int cntLine = costs.length; // 간선의 개수
        for(int i=0; i<cntLine && n-1 > 0; i++){ // 간선의 개수만큼 실행 && 섬을 다 이을때 까지
            if(!hasCycle(costs[i][0], costs[i][1])){ // 사이클을 이루지 않으면
                unionParent(costs[i][0], costs[i][1]); // 선을 잇고 union을 합친 다음에
                totalCost += costs[i][2]; // 비용 추가
                n--; // 이어야 할 선 하나 줄었다.
            }
        }
        
        return totalCost;
    }
    
    public static int getParent(int x){
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent[x]);
    }
    
    public static void unionParent(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    
    public static boolean hasCycle(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a == b) return true;
        return false;
    }
}
