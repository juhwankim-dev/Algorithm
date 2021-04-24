package binarySearch;

import java.util.*;

public class _1_Immigration {
	public static void main(String[] args) {
		int[] times = {
			7, 10	
		};
		
		System.out.println(solution(6, times));
	}
	
    public static long solution(int n, int[] times) {
        int timeSize = times.length;
        Arrays.sort(times);
        
        long sum = 0;
        long max = (long)times[0] * n;
        long min = 1;
        long mid = 0;
        long answer = max;
        while(min <= max) {
        	sum = 0;
            mid = (max + min) / 2;
            for(int i=0; i<timeSize; i++) {
            	sum += mid / times[i];
            }
            
            if(sum >= n) {
            	answer = Math.min(answer, mid);
            	max = mid-1;
            } else {
            	min = mid+1;
            }
        }
        
        return answer;
    }
}
