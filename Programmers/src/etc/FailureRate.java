package etc;

import java.util.*;

public class FailureRate {

	public static void main(String[] args) {
		int[] stages = {
				2, 1, 2, 6, 2, 4, 3, 3
		};
		solution(5, stages);
	}

    public static int[] solution(int N, int[] stages) {
        float[] count = new float[N+2];
        
        for(int stage : stages){
            count[stage]++; // 3스테이지를 도전 중이면 3번째 배열 +1 
        }
        
        int cntPlayer = stages.length;
        float[][] result = new float[N][2];
        for(int i=1; i<N+1; i++){
            result[i-1][0] = i;
            result[i-1][1] = count[i] / cntPlayer;
            
            cntPlayer -= count[i];
        }
        
        Arrays.sort(result, new Comparator<float[]>(){

			@Override
			public int compare(float[] o1, float[] o2) {
				if(o1[1] == o2[1]) {
					return (int) (o1[0] - o2[0]);
				}
				return (int) (o2[1] - o1[1]);
			}
            
        });
        
        int[] answer = new int[N];
        for(int i=0; i<result.length; i++) {
        	answer[i] = (int) result[i][0];
        }
        
        return answer;
    }
}
