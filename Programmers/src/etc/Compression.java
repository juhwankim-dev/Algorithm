package etc;

import java.util.*;

public class Compression {
	static HashMap<String, Integer> hs = new HashMap<>();
	
	public static void main(String[] args) {
		Queue<Integer> queue = solution("KAKAO");
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

    public static Queue<Integer> solution(String msg) {
        Queue<Integer> queue = new LinkedList<>();
        
        // A~Z 넣기
        for(int i=65; i<91; i++) {
        	hs.put(toString(i), i-64);
        }
        
        int idxNumber = 27;
        for(int i=0; i<msg.length(); i++) {
        	StringBuilder sb = new StringBuilder();
        	sb.append(toString(msg.charAt(i)));
        	
        	// 등록되지 않은 단어를 찾을때까지 반복
        	while(i+1 < msg.length() && hs.containsKey(sb.toString())) {
        		sb.append(toString(msg.charAt(++i)));
        	}
        	
        	if(!hs.containsKey(sb.toString())) {
        		// 현재 입력(w)의 색인 번호를 출력하고
        		String w = sb.substring(0, sb.length()-1);
        		queue.add(hs.get(w));
        		
        		// 다음 글자를 포함한 단어를 사전에 등록한다.
        		hs.put(sb.toString(), idxNumber++);
        	} else {
        		// 다음 글자가 더 이상 없는 경우는 현재 입력(w)의 색인 번호를 출력하고 탈출
        		String w = sb.substring(0, sb.length());
        		queue.add(hs.get(w));
        		break;
        	}
        	
        	// 초기화 작업
        	i--;
        	sb.setLength(0);
        }
        
        return queue;
    }
    
    public static String toString(int ch) {
    	return Character.toString((char)ch);
    }
    
    public static String toString(char ch) {
    	return Character.toString(ch);
    }
}
