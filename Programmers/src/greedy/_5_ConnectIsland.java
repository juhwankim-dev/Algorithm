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
        // ������ ���� ������� ����
        Arrays.sort(costs, new Comparator<int[]>(){
        	
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        });
        
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i; // ó������ �ڱ� �ڽ��� ����Ű����
        }
        
        int totalCost = 0; // �� ���
        int cntLine = costs.length; // ������ ����
        for(int i=0; i<cntLine && n-1 > 0; i++){ // ������ ������ŭ ���� && ���� �� ������ ����
            if(!hasCycle(costs[i][0], costs[i][1])){ // ����Ŭ�� �̷��� ������
                unionParent(costs[i][0], costs[i][1]); // ���� �հ� union�� ��ģ ������
                totalCost += costs[i][2]; // ��� �߰�
                n--; // �̾�� �� �� �ϳ� �پ���.
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
