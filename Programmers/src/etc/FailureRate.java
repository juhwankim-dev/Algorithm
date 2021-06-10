package etc;

import java.util.*;

public class FailureRate {

	public static void main(String[] args) {
		int[] stages = {
				4, 4, 4, 4, 4
		};
		
		int[] result = solution(4, stages);
		for(int r : result) {
			System.out.println(r);
		}
	}

    public static int[] solution(int N, int[] stages) {
    	// 스테이지 별 유저 인원 구하기 + 스테이지 순으로 정렬
    	TreeMap<Integer, Integer> hs = new TreeMap<>();
    	for(int i=1; i<=N; i++) {
    		hs.put(i, 0);
    	}
    	for(int stage : stages) {
    		if(stage != N+1) {
    			hs.put(stage, hs.get(stage) + 1);
    		}
    	}
    	
    	// 스테이지 별 실패율 구하기
    	float numberUsers = stages.length;
    	float[][] failureRate = new float[N][2];
    	int idx = 0;
    	for(Integer key : hs.keySet()) {
    		int unClearedUsers = hs.get(key);
    		failureRate[idx][0] = key;
    		failureRate[idx++][1] = unClearedUsers / numberUsers;
    		numberUsers -= unClearedUsers;
    	}
    	
    	// 실패율 높은 순서로 정렬
    	Arrays.sort(failureRate, new Comparator<float[]>() {

			@Override
			public int compare(float[] o1, float[] o2) {
				
				// 실패율이 같다면 스테이지 번호가 작은 순서
				if(o1[1] == o2[1]) {
					return (o1[0] < o2[0]) ? -1 : 1;
				}
				
				return (o2[1] < o1[1]) ? -1 : 1;
			}
    		
    	});
    	
    	int[] result = new int[N];
    	idx = 0;
    	for(float[] stage : failureRate) {
    		result[idx++] = (int) stage[0];
    	}
    	return result;
    }
}
