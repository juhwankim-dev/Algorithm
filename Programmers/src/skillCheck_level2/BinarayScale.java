package skillCheck_level2;

public class BinarayScale {

	public static void main(String[] args) {
		int[] answer = new int[2];
		answer = solution("110010101001");
		
		for(int a : answer) {
			System.out.println(a);
		}
	}

    public static int[] solution(String s) {
        int transferCnt = 0;
        int zeroCnt = 0;
        
        while(!s.equals("1")) {
        	// 1�ܰ�. 0�� �����ϰ� ī��Ʈ
        	int len = s.length();
        	int temp = 0;
            for(int i=0; i<len; i++) {
            	if(s.charAt(i) == '0') temp++;
            }
            zeroCnt += temp;

            // 2�ܰ�. 1�� �̷���� ���ڿ��� ���̸� 2�������� ǥ��
            len -= temp;
            s = Integer.toBinaryString(len);

        	transferCnt++;
        }
        
        int[] answer = new int[2];
        answer[0] = transferCnt;
        answer[1] = zeroCnt;
        
        return answer;
    }
}
