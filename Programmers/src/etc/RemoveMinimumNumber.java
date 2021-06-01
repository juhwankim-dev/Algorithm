package etc;

import java.util.*;

public class RemoveMinimumNumber {

	public static void main(String[] args) {
		int[] arr = {
				4,3,1,2
		};
		
		solution(arr);
	}
	
    public static int[] solution(int[] arr) {
        int[] answer;
        
        if(arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[arr.length-1];
            int[] copyArr = arr.clone();
            Arrays.sort(copyArr);
            int min = copyArr[0];
            int k = 0;
            
            for(int i=0; i<arr.length; i++) {
                if(arr[i] == min) {
                	k = -1;
                    continue;
                }
                answer[i + k] = arr[i];
            }
        }
        
        return answer;
    }
}
