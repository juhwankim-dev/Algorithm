package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _4_LifeBoat {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int size = st.countTokens();
		int[] people = new int[size];
		
		for(int i=0; i<size; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(people, 100));
	}

    public static int solution(int[] people, int limit) {
        int cntPeople = people.length;
        Arrays.sort(people); // �ϴ� ����
        
        int solo = 0; // ȥ�� Ÿ���ϴ� ��� �Ф�...
        int couple = 0; // ���� Ÿ�� �׷�
        int idx = cntPeople; // �ڿ��� ���� �������� �ε���
        int i=0;
        
        while(i < idx--) {
        	if(people[i] + people[idx] > limit){
                solo++;
            } else {
            	couple++;
            	i++;
            }
        }
        
        return solo + couple;
    }
}
