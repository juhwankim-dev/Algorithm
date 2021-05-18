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
        	// 1단계. 0을 제거하고 카운트
        	int len = s.length();
        	int temp = 0;
            for(int i=0; i<len; i++) {
            	if(s.charAt(i) == '0') temp++;
            }
            zeroCnt += temp;

            // 2단계. 1로 이루어진 문자열의 길이를 2진법으로 표현
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
