package etc;

public class CaesarPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder(s.length());
        
        for(int i=0; i<s.length(); i++){
            int ch = s.charAt(i);
            
            if(ch == ' ') {
                sb.append(' ');
                continue;
            } 

            if(Character.isUpperCase(ch)){
                if(ch + n <= 'Z') {
                	ch += n;
                } else {
                	ch += n - 26;
                }
            } else {
                if(ch + n <= 'z') {
                	ch += n;
                } else {
                	ch += n - 26;
                }
            }
            
            sb.append((char)ch);
        }
        
        return sb.toString();
    }
}
