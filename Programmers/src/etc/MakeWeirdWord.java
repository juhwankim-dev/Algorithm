package etc;

import java.util.*;

public class MakeWeirdWord {

	public static void main(String[] args) {
		System.out.println(solution("abcD ZYXz"));
	}
	
    public static String solution(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word : words) {
            for(int i=0; i<word.length(); i++) {
                char alphabet = word.charAt(i);
                
                if((i % 2 == 0) && !isUpperCase(alphabet)) { // Â¦¼ö¹øÂ° ÀÎµ¦½º(= È¦¼ö¹øÂ° ¾ËÆÄºª)
                    alphabet -= 32;
                } else if((i % 2 != 0) && isUpperCase(alphabet)) {
                    alphabet += 32;
                }
                sb.append(alphabet);
            }
            sb.append(" ");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    public static boolean isUpperCase(char alphabet) {
        if(65 <= alphabet && alphabet < 91) {
            return true;
        }
        
        return false;
    }
}
