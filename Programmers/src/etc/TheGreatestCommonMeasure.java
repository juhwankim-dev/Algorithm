package etc;

import java.util.*;

public class TheGreatestCommonMeasure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        
        // 최대공약수 (유클리드)
        while(max % min != 0) {
        	int temp = min;
        	min = max % min;
        	max = temp;
        }
        int greatest = min;
        
        // 최소공배수
        HashSet<Integer> set = new HashSet<>();
        for(int i=1; i<=m; i++) {
        	set.add(n*i);
        }
        
        int least = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
        	if(set.contains(m*i)) {
        		least = m*i;
        		break;
        	}
        }
        
        answer[0] = greatest;
        answer[1] = least;
        
        return answer;
    }
}
