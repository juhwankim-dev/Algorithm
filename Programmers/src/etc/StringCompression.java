package etc;

import java.util.*;

public class StringCompression {

	public static void main(String[] args) {
		System.out.println(solution("a"));
	}

    public static int solution(String s) {
        int min = Integer.MAX_VALUE;
        StringBuilder str = new StringBuilder();
        StringBuilder compressedStr = new StringBuilder();
        String unit;
        
        for(int i=1; i<=s.length()/2; i++) { // 몇개의 단위로 잘라 압축할건지
        	str.append(s);
        	String pattern = "";
        	int cnt=1;
        	
        	while(str.length() >= i) { // 더이상 자를 str이 없을 때까지 반복
        		// 문자열 자르기
        		unit = str.substring(0, i);
        		str.delete(0, i);
        		
        		// 다음 문자열이 현재 패턴과 같다면
        		if(unit.equals(pattern)) {
        			cnt++; // 카운트
        		} else { // 같지 않다면
        			if(cnt != 1) {
            			compressedStr.append(cnt); // 숫자를 넣고
            			cnt = 1; // 숫자 초기화
        			}
        			compressedStr.append(unit); // 패턴을 넣고
        			pattern = unit; // 패턴 변경
        		}
        	}
        	
        	// 숫자를 못넣고 while문이 끝나는 경우를 위해
			if(cnt != 1) {
    			compressedStr.append(cnt);
			}
			
			// 남은 문자열이 단위보다 작아서 남은 경우를 위해
        	compressedStr.append(str.substring(0, str.length()));

        	min = Math.min(min, compressedStr.length());
        	compressedStr.setLength(0);
        	str.setLength(0);
        }
        
        return min;
    }
}

/*
public class StringCompression {

	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
	}

    public static int solution(String s) {
        int min = Integer.MAX_VALUE;
        String word="";
        int cnt=0;
        StringBuilder original = new StringBuilder();
        StringBuilder compress = new StringBuilder();
        original.append(s);
        
        for(int i=1; i<=s.length()/2; i++) {
        	for(int j=0; j<s.length(); j=j+i) {
        		String pattern = original.substring(0, i);
        		cnt = compress(pattern, original.toString());
        		
        		if(cnt == 0) {
        			compress.append(pattern);
        		}
        		
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
        	
			if(cnt != 1) { // 압축된 게 있으면 숫자넣고 cnt 초기화
				compress.append(cnt);
			}
			compress.append(word);
			
        	min = Math.min(min, compress.length());
        	compress.setLength(0);
        }
        
        return min;
    }
    
    public static int compress(String pattern, String s) {
    	int pLen = pattern.length();
    	int	sLen = s.length();
    	
    	if(pLen > sLen) {
    		return 0;
    	}
    	
    	if(pattern.equals(s.substring(0, pLen))) {
    		return 1 + compress(pattern, s.substring(pLen, sLen));
    	} else {
    		return 0;
    	}
    }
}
 */

/*
    public static int solution(String s) {
        int min = Integer.MAX_VALUE;

        StringBuilder original = new StringBuilder();
        StringBuilder compress = new StringBuilder();
        original.append(s);
        
        for(int i=3; i<=s.length()/2; i++) {
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
        	
			if(cnt != 1) { // 압축된 게 있으면 숫자넣고 cnt 초기화
				compress.append(cnt);
			}
			compress.append(word);
			
        	min = Math.min(min, compress.length());
        	compress.setLength(0);
        }
        
        return min;
    }
    */
