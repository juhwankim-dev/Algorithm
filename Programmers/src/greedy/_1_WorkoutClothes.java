package greedy;

import java.util.*;
import java.io.*;

public class _1_WorkoutClothes {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int size = st.countTokens();
		int[] lost = new int[size];
		
		for(int i=0; i<size; i++) {
			lost[i] = Integer.parseInt(st.nextToken());
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		size = st2.countTokens();
		int[] reserve = new int[size];
		
		for(int i=0; i<size; i++) {
			reserve[i] = Integer.parseInt(st2.nextToken());
		}
		
		System.out.println(solution(n, lost, reserve));
	}

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] studentClothes = new int[n]; // �л����� �� ���� ��Ȳ 
        int lostLength = lost.length;
        int reserveLength = reserve.length;

        // �Ʒ� ���� 2���� ���� ���� ���� �������� -1, �ڱ� �͸������� 0, ������ ������ 1�̵ȴ�.
        for(int i=0; i<lostLength; i++){
            studentClothes[lost[i]-1]--;
        }

        for(int i=0; i<reserveLength; i++){
            studentClothes[reserve[i]-1]++;
        }

        // ù��° ģ����, �� ���� �ְ� ���� ģ���� ���� �������� �ϳ� �ֶ�.
        if(studentClothes[0] == 1
           && studentClothes[1] == -1){
            studentClothes[0]--;
            studentClothes[1]++;
        }
        for(int i=1; i<n-1; i++){
            if(studentClothes[i] == 1 // ���� ������ �ִµ�
               && studentClothes[i+1] == -1 // ���� ��ȣ ģ���� ���� ���߰�
               && studentClothes[i-1] != -1){ // ���� ��ȣ ģ���� ������ �ȴ��ߴ�.
                studentClothes[i+1]++; // �׷��� �� ģ�� �ϳ� ��!
                studentClothes[i]--; // �� ������ �����ϱ�~
            } 
        }

        // �� �̹��� �ݴ��~
        for(int i=n-1; i>0; i--){
            if(studentClothes[i] == 1 // ���� ������ �ִµ�
               && studentClothes[i-1] == -1) { // ���� ��ȣ ģ���� ���� ���ߴ�.
                studentClothes[i-1]++; // �׷��� �� ģ�� �ϳ� ��!
                studentClothes[i]--; // �� ������ �����ϱ�~
            }
        }

        for(int student : studentClothes){
            if(student >= 0) answer++;
        }

        return answer;
    }
}
