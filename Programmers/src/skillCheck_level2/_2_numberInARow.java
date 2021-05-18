package skillCheck_level2;

public class _2_numberInARow {

	public static void main(String[] args) {
		System.out.println(solution(15));
	}

    public static int solution(int n) {
        int count = 0;
        
        int lastNum = n/2 + 1; // 자기자신은 계산할필요없음 나중에 걍 +1 해주면 돼
        int cntNum=2;
        
        while(true) {
        	int sum = 0;
        	if(lastNum < cntNum) break;
        	
        	int temp = lastNum;
        	for(int i=0; i<cntNum ;i++) {
        		sum += temp--; // 연속된 숫자를 합치고
        	}
        	
        	if(sum == n) { // 만약 연속된 숫자의 합이 n과 같다면
        		count++; // 카운터 증가시키고
        		cntNum++; // 몇개의 숫자로 조합할 것인지 정하는 값 + 1
        		lastNum--;
        	}
        	else if(sum < n) {
        		cntNum++;
        	} else if(sum > n){ // sum이 더 크면 new
        		lastNum--; // 마지막 숫자를 감소시킨다.
        	}
        }
        
        return count+1;
    }
}
