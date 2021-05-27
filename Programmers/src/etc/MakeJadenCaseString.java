package etc;

public class MakeJadenCaseString {

	public static void main(String[] args) {
		System.out.println(solution(" 3people unFollowed me"));
	}

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        String[] words = s.split(" ", -1);
        
        for(String word : words) {
        	if(word.isBlank()) {
        		sb.append(word);
        		continue;
        	}
        	
            String temp = word.toLowerCase();
            char first = temp.charAt(0);
            if(Character.isLowerCase(first)) {
            	sb.append(Character.toUpperCase(first))
            	.append(temp.substring(1, temp.length()))
            	.append(" ");
            } else {
            	sb.append(temp).append(" ");
            }
        }
        
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
