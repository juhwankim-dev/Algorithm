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
        
        // 진입 지점 기준으로 정렬, 만약 같다면 진출 지점 기준
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
        });
    
        //람다식 사용하는 경우도 익숙해질 것
        //Arrays.sort(routes, (a, b) -> Integer.compare(a[0], a[1]));
        
        int preOut = routes[0][1];
        int routesSize = routes.length;
        for(int i=1; i<routesSize; i++){
            if(routes[i][0] <= preOut){
                preOut = Math.min(preOut, routes[i][1]);
            } else {
                answer++; // 카메라 추가
            }
        }
        
        return answer+1;
    }
}
