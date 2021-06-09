package etc;

public class Joystick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(String name) {
		int answer = 0;

		int len = name.length();

		// 최대로 가질 수 있는 min값은 끝까지 가는것
		int min_move = len - 1;

		for (int i = 0; i < len; i++) {
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

			// 좌우: 연속된 A의 등장에 따라 최소 움직임이 달라진다
			int next = i + 1;// 현재 다음 위치부터
			// 내 다음이 A라면 계속 NEXT++
			while (next < len && name.charAt(next) == 'A')
				next++;

			min_move = Math.min(min_move, i + len - next + i);
		}

		answer += min_move;

		return answer;
	}
}


/*
 * public int solution(String name) { boolean[] arr = new
 * boolean[name.length()]; int sum = 0;
 * 
 * for(int i=0; i<name.length(); i++) { char ch = name.charAt(i);
 * 
 * if(ch != 'A') { // A가 아님을 저장 arr[i] = true;
 * 
 * // A로 만드는데 필요한 이동횟수 카운트 int distance = name.charAt(i) - 'A'; sum += (distance
 * < 14) ? distance : distance - 13; } }
 * 
 * 
 * 
 * return 0; }
 * 
 * public static int prevIdx(boolean[] arr, int curIdx) { for(int i=curIdx-1;
 * i>=0; i--) { if(arr[i]) { return i; } }
 * 
 * for(int i=arr.length-1; i>curIdx; i--) { if(arr[i]) { return i; } }
 * 
 * return -1; }
 * 
 * public static int nextIdx(boolean[] arr, int curIdx) { for(int i=curIdx+1;
 * i<arr.length; i++) { if(arr[i]) { return i; } }
 * 
 * for(int i=0; i<curIdx; i++) { if(arr[i]) { return i; } }
 * 
 * return -1; }
 */
