package greedy;

import java.util.*;

public class _6_Camera {

	public static void main(String[] args) {
		int[][] routes = {
				{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}
		};
		System.out.println(solution(routes));
	}

    public static int solution(int[][] routes) {
        int answer = 0;
        
        // ���� ���� �������� ����, ���� ���ٸ� ���� ���� ����
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
        });
    
        //���ٽ� ����ϴ� ��쵵 �ͼ����� ��
        //Arrays.sort(routes, (a, b) -> Integer.compare(a[0], a[1]));
        
        int preOut = routes[0][1];
        int routesSize = routes.length;
        for(int i=1; i<routesSize; i++){
            if(routes[i][0] <= preOut){
                preOut = Math.min(preOut, routes[i][1]);
            } else {
                answer++; // ī�޶� �߰�
            }
        }
        
        return answer+1;
    }
}
