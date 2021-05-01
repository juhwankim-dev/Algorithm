package stackQueue;

import java.util.*;

public class _4_Printer {

	public static void main(String[] args) {
		int[] p = {1,1,9,1,1};
		
		System.out.println(solution(p, 2));
	}
	
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Print> queue = new LinkedList<>();
        int[] waiting = new int[9]; // �߿䵵 1~9, �ε��� 0~8
        int i=0;
        for(int p : priorities){
            queue.add(new Print(i++, p));
            waiting[p-1]++;
        }
        
        while(!queue.isEmpty()){ // ť�� ����������� �ݺ�
        	int top = queue.peek().priorty;
            
            if(hasHigher(waiting, queue.peek().priorty)) { // �� ū ���ڰ� ��ٸ��� �ִ� ���
                queue.add(queue.poll());
            } else {
            	answer++;
                if(queue.peek().location == location){
                    break;
                }
                
                waiting[top-1]--;
                queue.remove();
            }
        }
        
        return answer;
    }
	
	public static boolean hasHigher(int[] waiting, int value) {
		for(int i=value; i<9; i++) {
			if(waiting[i] > 0) {
				return true;
			}
		}
		return false;
	}
}

class Print {
	int location;
	int priorty;
	
	Print(int location, int priorty) {
		this.location = location;
		this.priorty = priorty;
	}
}

/* ó���� �����ߴ� TreeMap�� ����ϴ� ���
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Print> queue = new LinkedList<>();
        TreeMap<Integer, Integer> waiting = new TreeMap<>();
        int i=0;
        for(int p : priorities){
            queue.add(new Print(i++, p));
            waiting.put(p, waiting.getOrDefault(p, 0)+1);
        }
        
        Map.Entry<Integer, Integer> entry = null;
        while(!queue.isEmpty()){ // ť�� ����������� �ݺ�
        	int top = queue.peek().priorty;
            entry = waiting.higherEntry(top); // ����� �� �� �տ� ������ �� ���� ��
            
            if(entry != null) { // �� �տ� ��尡 ���� ū ���� ���
            	queue.add(queue.poll());
            } else {
            	answer++;
                if(queue.peek().location == location){
                    break;
                }
                
                int temp = waiting.get(top);
                if(temp > 1) {
                	waiting.put(top, temp--);
                } else {
                	waiting.remove(top);
                }
                queue.remove();
            }
        }
        
        return answer;
    }


class Print {
	int location;
	int priorty;
	
	Print(int location, int priorty) {
		this.location = location;
		this.priorty = priorty;
	}
}
*/