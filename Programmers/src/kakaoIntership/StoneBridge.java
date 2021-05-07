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

/* 처음에 큐를 이용해서 풀어봄
int max=0;
int answer =Integer.MAX_VALUE;

Queue<Integer> queue = new LinkedList<>();
for(int i=0; i<k; i++) {
	queue.add(stones[i]); // 우선 k개 만큼 넣음
	max = Math.max(max, stones[i]); // k개 중 가장 큰 값을 구함
}
answer = max;

for(int i=k; i<stones.length; i++) {
	int out = queue.poll();
	int in = stones[i];
	queue.add(in);
	
	// 최댓값이 나갈 차례라면
	if(out == max) {
		// k개의 그룹 안에서 최댓값 찾기
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

/* 시간초과가 나서 배열을 이용해서 풀어봄
public static int solution(int[] stones, int k) {
// 처음 k개 돌 중 최댓값 찾기
int max=0;
for(int i=0; i<k; i++) {
	max = Math.max(max, stones[i]);
}
int answer = max;

// k개 이후의 돌을 k개 만큼 그룹으로 묶어 검사하며 최댓값 찾기
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