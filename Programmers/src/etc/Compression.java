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
        
        // A~Z �ֱ�
        for(int i=65; i<91; i++) {
        	hs.put(toString(i), i-64);
        }
        
        int idxNumber = 27;
        for(int i=0; i<msg.length(); i++) {
        	StringBuilder sb = new StringBuilder();
        	sb.append(toString(msg.charAt(i)));
        	
        	// ��ϵ��� ���� �ܾ ã�������� �ݺ�
        	while(i+1 < msg.length() && hs.containsKey(sb.toString())) {
        		sb.append(toString(msg.charAt(++i)));
        	}
        	
        	if(!hs.containsKey(sb.toString())) {
        		// ���� �Է�(w)�� ���� ��ȣ�� ����ϰ�
        		String w = sb.substring(0, sb.length()-1);
        		queue.add(hs.get(w));
        		
        		// ���� ���ڸ� ������ �ܾ ������ ����Ѵ�.
        		hs.put(sb.toString(), idxNumber++);
        	} else {
        		// ���� ���ڰ� �� �̻� ���� ���� ���� �Է�(w)�� ���� ��ȣ�� ����ϰ� Ż��
        		String w = sb.substring(0, sb.length());
        		queue.add(hs.get(w));
        		break;
        	}
        	
        	// �ʱ�ȭ �۾�
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
