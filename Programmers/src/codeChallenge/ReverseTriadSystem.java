package codeChallenge;

import java.io.IOException;

public class ReverseTriadSystem {

	public static void main(String[] args) throws IOException {
		System.out.println(solution(45));
	}
	
	public static int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        // 10진법 -> 3진법
        while(n / 3 != 0){
            sb.append(n%3);
            n /= 3;
        }
        sb.append(n);
        
        // 3진법 -> 10진법
        sb.reverse();
        for(int i=0; i<sb.length(); i++){
            answer += (sb.charAt(i) - '0') * Math.pow(3, i);
        }
        
        return answer;
    }
}
