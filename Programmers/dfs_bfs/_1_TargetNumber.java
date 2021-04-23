package dfs_bfs;

import java.util.*;

public class _1_TargetNumber {
	
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		
		System.out.println(solution(numbers, target));
	}

    public static int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    public static int dfs(int[] numbers, int target, int i, int pre) {
    	if(i >= numbers.length) {
    		if(pre == target) {
    			return 1;
    		}
    		return 0;
    	}
    	
    	int cur1 = pre + numbers[i];
    	int cur2 = pre - numbers[i];
    	
    	return dfs(numbers, target, i+1, cur1) + dfs(numbers, target, i+1, cur2);
    }
}
