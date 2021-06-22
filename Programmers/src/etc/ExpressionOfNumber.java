package etc;

public class ExpressionOfNumber {

	public static void main(String[] args) {
		System.out.println(solution(15));
	}

    public static int solution(int n) {
        int answer = 1;
        
        for(int i=2; i<n/2; i++) {
        	int end = n - (n/i)+1;
        	if(isExpressible(n, i, end)) {
        		answer++;
        	}
        }
        
        return answer;
    }
    
    public static boolean isExpressible(int n, int numCnt, int end) {
    	int sum1 = end*(end+1)/2; // 1부터 end까지의 합
    	int sum2 = (end-numCnt)*(end-numCnt+1)/2; // 1부터 end-numCnt까지의 합
    	int sum3 = sum1 - sum2;

    	if(sum3-n < (end-numCnt+1)*numCnt) {
    		return (sum3 - n) % numCnt == 0;
    	}
    	
    	return false;
    }
}
