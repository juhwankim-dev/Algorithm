package sort;

import java.io.*;
import java.util.*;

public class _2_BiggestNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int size = st.countTokens();
		int[] numbers = new int[size];
		for(int i=0; i<size; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
        String answer = "";
        
        // 숫자를 전부 string형으로 변환
        int size = numbers.length;
        String[] numbers_ = new String[size];
        for(int i=0; i<size; i++){
            numbers_[i] = Integer.toString(numbers[i]);
        }
        
        // 정렬
        Arrays.sort(numbers_, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                int a = Integer.parseInt(o1 + o2); // '3' + '10' = 310
                int b = Integer.parseInt(o2 + o1); // '10' + '3' = 103
                
                return b-a;
            }
        });
        
        if(numbers_[0].equals("0")){
            answer = "0";
        } else {
            StringBuilder sb = new StringBuilder();
            for(String num : numbers_){
                sb.append(num);
                answer = sb.toString();
            }
        }
        return answer;
    }
}