package skillCheck_level2;

public class _2_numberInARow {

	public static void main(String[] args) {
		System.out.println(solution(15));
	}

    public static int solution(int n) {
        int count = 0;
        
        int lastNum = n/2 + 1; // �ڱ��ڽ��� ������ʿ���� ���߿� �� +1 ���ָ� ��
        int cntNum=2;
        
        while(true) {
        	int sum = 0;
        	if(lastNum < cntNum) break;
        	
        	int temp = lastNum;
        	for(int i=0; i<cntNum ;i++) {
        		sum += temp--; // ���ӵ� ���ڸ� ��ġ��
        	}
        	
        	if(sum == n) { // ���� ���ӵ� ������ ���� n�� ���ٸ�
        		count++; // ī���� ������Ű��
        		cntNum++; // ��� ���ڷ� ������ ������ ���ϴ� �� + 1
        		lastNum--;
        	}
        	else if(sum < n) {
        		cntNum++;
        	} else if(sum > n){ // sum�� �� ũ�� new
        		lastNum--; // ������ ���ڸ� ���ҽ�Ų��.
        	}
        }
        
        return count+1;
    }
}
