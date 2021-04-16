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
        int[] studentClothes = new int[n]; // 학생들의 옷 보유 현황 
        int lostLength = lost.length;
        int reserveLength = reserve.length;

        // 아래 포문 2개를 돌고 나서 도난 당했으면 -1, 자기 것만있으면 0, 여분이 있으면 1이된다.
        for(int i=0; i<lostLength; i++){
            studentClothes[lost[i]-1]--;
        }

        for(int i=0; i<reserveLength; i++){
            studentClothes[reserve[i]-1]++;
        }

        // 첫번째 친구야, 너 여분 있고 다음 친구가 도난 당했으면 하나 주라.
        if(studentClothes[0] == 1
           && studentClothes[1] == -1){
            studentClothes[0]--;
            studentClothes[1]++;
        }
        for(int i=1; i<n-1; i++){
            if(studentClothes[i] == 1 // 내가 여분이 있는데
               && studentClothes[i+1] == -1 // 다음 번호 친구가 도난 당했고
               && studentClothes[i-1] != -1){ // 이전 번호 친구는 도난을 안당했다.
                studentClothes[i+1]++; // 그러면 그 친구 하나 줘!
                studentClothes[i]--; // 난 여분이 있으니까~
            } 
        }

        // 자 이번엔 반대로~
        for(int i=n-1; i>0; i--){
            if(studentClothes[i] == 1 // 내가 여분이 있는데
               && studentClothes[i-1] == -1) { // 이전 번호 친구가 도난 당했다.
                studentClothes[i-1]++; // 그러면 그 친구 하나 줘!
                studentClothes[i]--; // 난 여분이 있으니까~
            }
        }

        for(int student : studentClothes){
            if(student >= 0) answer++;
        }

        return answer;
    }
}
