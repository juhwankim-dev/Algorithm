package etc;

import java.util.*;

public class N_LeastCommonMeasure {

	public static void main(String[] args) {
		int[] arr = {2,6,8,14};
		
		System.out.println(solution(arr));
	}

    public static int solution(int[] arr) {
    	int pre = 1;
    	
    	for(int cur : arr) {
    		int max = Math.max(pre, cur);
    		int min = Math.min(pre, cur);
    		
    		pre = (pre * cur) / GCD(max, min);
    	}
    	
        return pre;
    }
    
    public static int GCD(int a, int b) {
    	if(a % b == 0) {
    		return b;
    	}
    	
    	return GCD(b, a % b);
    }
}