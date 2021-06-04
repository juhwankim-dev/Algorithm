package etc;

public class StringCompression {

	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
	}

    public static int solution(String s) {
        int min = Integer.MAX_VALUE;

        StringBuilder original = new StringBuilder();
        StringBuilder compress = new StringBuilder();
        original.append(s);
        
        for(int i=1; i<=s.length()/2; i++) {
        	int cnt = 1;
        	String word = original.substring(0, i); // 기준이 되는 문자
        	for(int j=i; j<s.length(); j=j+i) {
        		if(word.equals(original.substring(j, j+i))) { // 압축이 가능한 경우
        			cnt++;
        		} else { // 더이상 압축이 불가능 한 경우
        			if(cnt != 1) { // 압축된 게 있으면 숫자넣고 cnt 초기화
        				compress.append(cnt);
        				cnt = 1; // 초기화
        			}
    				compress.append(word);
    				word = original.substring(j, j+i); // 새로운 문자를 기준으로 잡는다.
        		}
        	}
        	min = Math.min(min, cnt);
        }
        
        return min;
    }
}
