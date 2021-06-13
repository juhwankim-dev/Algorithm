package etc;

import java.util.*;

public class MakeMin {

	public static void main(String[] args) {
		int[] A = { 1, 4, 2 };
		int[] B = { 5, 4, 4 };
		
		System.out.println(solution(A, B));
	}

    public static int solution(int []A, int []B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int len = A.length;
        for(int i=0; i<len; i++) {
        	answer += A[i] * B[len-1-i];
        }
        
        return answer;
    }
}
