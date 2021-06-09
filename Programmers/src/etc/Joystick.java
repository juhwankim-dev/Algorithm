package etc;

public class Joystick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(String name) {
		int answer = 0;

		int len = name.length();

		// �ִ�� ���� �� �ִ� min���� ������ ���°�
		int min_move = len - 1;

		for (int i = 0; i < len; i++) {
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

			// �¿�: ���ӵ� A�� ���忡 ���� �ּ� �������� �޶�����
			int next = i + 1;// ���� ���� ��ġ����
			// �� ������ A��� ��� NEXT++
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
 * if(ch != 'A') { // A�� �ƴ��� ���� arr[i] = true;
 * 
 * // A�� ����µ� �ʿ��� �̵�Ƚ�� ī��Ʈ int distance = name.charAt(i) - 'A'; sum += (distance
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
