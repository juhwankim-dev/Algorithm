package hash;

import java.util.*;

public class _1_unfinishedRunner {

	public static void main(String[] args) {
		
	}

	public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hs = new HashMap<String, Integer>();
        for(String c : completion){
            hs.put(c, hs.getOrDefault(c, 0) + 1);
        }

        for(String p : participant){
            hs.put(p, hs.getOrDefault(p, 0) - 1);

            if(hs.get(p) < 0){
                answer = p;
                break;
            }
        }

        return answer;
    }
}

// getOrDefault라는 메서드를 처음 알았다...