package etc;

import java.util.*;

public class MakePrime {

	public static void main(String[] args) {
		int[] nums = {998,999,1000};
		System.out.println(solution(nums));
	}

    public static int solution(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int max = nums[len-1] + nums[len-2] + nums[len-3];
        boolean[] generalNumber = new boolean[max+1];
        
        for(int i=2; i*i<=max; i++) {
			for(int j=2; i*j<=max; j++) {
				generalNumber[i*j] = true;
			}
		}

        int cnt = 0;
        for(int i=0; i<len-2; i++){
            for(int j=i+1; j<len-1; j++){
                for(int k=j+1; k<len; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(!generalNumber[sum]) cnt++;
                }
            }
        }
        
        return cnt;
    }
}
