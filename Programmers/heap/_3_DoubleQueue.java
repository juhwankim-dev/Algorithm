package heap;

import java.util.*;

public class _3_DoubleQueue {

	public static void main(String[] args) {
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		
		int[] answer = solution(operations);
		for(int a : answer) {
			System.out.println(a);
		}
	}

    public static int[] solution(String[] operations) {
        // ascendQ: 우선 순위가 높은 순 = 오름차순
        // descendQ: 우선 순위가 낮은 순 = 내림차순
        PriorityQueue<Integer> ascendQ = new PriorityQueue<>();
        PriorityQueue<Integer> descendQ = new PriorityQueue<>(Collections.reverseOrder());

        int temp;
        for(String s : operations) {
        	StringTokenizer st = new StringTokenizer(s, " ");
        	String operator = st.nextToken();
        	if(operator.equals("I")) {
        		temp = Integer.parseInt(st.nextToken());
        		ascendQ.add(temp);
        		descendQ.add(temp);
        	} else if(ascendQ.size() > 0) {
        		if(st.nextToken().equals("1")) {
        			temp = descendQ.poll();
        			ascendQ.remove(temp);
        		} else {
        			temp = ascendQ.poll();
        			descendQ.remove(temp);
        		}
        	}
        }
        
        
        int[] answer = {0, 0};
        if(ascendQ.size() > 0) {
        	answer[0] = descendQ.peek();
        	answer[1] = ascendQ.peek();
        }
        
        return answer;
    }
}


/*
package heap;

import java.util.*;

public class _3_DoubleQueue {

	public static void main(String[] args) {
		
	}

    public int[] solution(String[] operations) {
        int[] answer = {};
        
        Deque<String> deque = new ArrayDeque<>();
        
        for(String s : operations) {
        	StringTokenizer st = new StringTokenizer(s, " ");
        	String operator = st.nextToken();
        	if(operator == "I") {
        		deque.addFirst(st.nextToken());
        	} else {
        		if(st.nextToken() == "1") {
        			deque.removeLast();
        		} else {
        			deque.removeFirst();
        		}
        	}
        }
        
        deque.peekFirst();
        deque.peekLast();
        
        return answer;
    }
}
*/