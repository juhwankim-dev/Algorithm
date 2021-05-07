package kakaoIntership;

public class StoneBridge {

	public static void main(String[] args) {
		int[] stones = {
				2, 4, 5, 3, 2, 1, 4, 2, 5, 1
		};
		int k = 3;
		System.out.println(solution(stones, k));
	}

    public static int solution(int[] stones, int k) {
    	int len = stones.length;
    	int high = Integer.MIN_VALUE;
    	int low = Integer.MAX_VALUE;
    	for(int i=0; i<len; i++) {
    		high = Math.max(high, stones[i]);
    		low = Math.min(low, stones[i]);
    	}
    	
    	int answer=0;
    	while(low <= high) {
    		int mid = (low + high) / 2;
    		if(canCross(stones, k, mid)) {
    			answer = mid;
    			low = mid + 1;
    		} else {
    			high = mid - 1;
    		}
    	}
    	
    	return answer;
    }
    
    public static boolean canCross(int[] stones, int k, int mid) {
    	int len = stones.length;
    	int cnt=0;
    	
    	for(int i=0; i<len; i++) {
    		if(stones[i] < mid) cnt++;
    		else cnt=0;
    		
    		if(cnt >= k) {
    			return false;
    		}
    	}

    	return true;
    }
}

/* ó���� ť�� �̿��ؼ� Ǯ�
int max=0;
int answer =Integer.MAX_VALUE;

Queue<Integer> queue = new LinkedList<>();
for(int i=0; i<k; i++) {
	queue.add(stones[i]); // �켱 k�� ��ŭ ����
	max = Math.max(max, stones[i]); // k�� �� ���� ū ���� ����
}
answer = max;

for(int i=k; i<stones.length; i++) {
	int out = queue.poll();
	int in = stones[i];
	queue.add(in);
	
	// �ִ��� ���� ���ʶ��
	if(out == max) {
		// k���� �׷� �ȿ��� �ִ� ã��
		int j=0;
		max = 0;
		
		while(j++ < k) {
			int val = queue.poll();
			max = Math.max(max, val);
			queue.add(val);
		}
		answer = Math.min(answer, max);
	}
}
*/

/* �ð��ʰ��� ���� �迭�� �̿��ؼ� Ǯ�
public static int solution(int[] stones, int k) {
// ó�� k�� �� �� �ִ� ã��
int max=0;
for(int i=0; i<k; i++) {
	max = Math.max(max, stones[i]);
}
int answer = max;

// k�� ������ ���� k�� ��ŭ �׷����� ���� �˻��ϸ� �ִ� ã��
for(int cursor=1; cursor<=stones.length - k; cursor++) {
	int out = stones[cursor-1];
	
	if(out == max) {
		max = 0;
    	for(int i=cursor; i<cursor+k; i++) {
    		max = Math.max(max, stones[i]);
    	}
    	answer = Math.min(answer, max);
	}
}

return answer;
}
*/