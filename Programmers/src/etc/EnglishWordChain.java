package etc;

import java.util.*;

public class EnglishWordChain {

	public static void main(String[] args) {
		String[] words = {
				"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"
		};
		int[] test = solution(3, words);
	}

	public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> hs = new HashSet<>();
        hs.add(words[0]);
        char first;
        char last = words[0].charAt(words[0].length() - 1);
        
        for(int i=1; i<words.length; i++) {
            first = words[i].charAt(0);
            
            if((first != last) || (hs.contains(words[i]))) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
        
            hs.add(words[i]);
            last = words[i].charAt(words[i].length() - 1);
        }

        return answer;
    }
}
