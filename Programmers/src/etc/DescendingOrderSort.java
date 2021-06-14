package etc;

import java.util.*;

public class DescendingOrderSort {

	public static void main(String[] args) {
		System.out.println(solution(118372));
	}

    public static long solution(long n) {
        int[] count = new int[10];
        String number = Long.toString(n);
        
        // 카운팅
        for(int i=0; i<number.length(); i++) {
        	count[number.charAt(i) - '0']++;
        }
        
        // 내림차순으로
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
        	while(count[i] > 0) {
        		sb.append(i);
        		count[i]--;
        	}
        }
        
        return Long.parseLong(sb.toString());
    }
}