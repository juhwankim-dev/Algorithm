package codeChallenge;

import java.io.IOException;

public class ReverseTriadSystem {

	public static void main(String[] args) throws IOException {
		System.out.println(solution(45));
	}
	
	public static int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        // 10柳过 -> 3柳过
        while(n / 3 != 0){
            sb.append(n%3);
            n /= 3;
        }
        sb.append(n);
        
        // 3柳过 -> 10柳过
        sb.reverse();
        for(int i=0; i<sb.length(); i++){
            answer += (sb.charAt(i) - '0') * Math.pow(3, i);
        }
        
        return answer;
    }
}
