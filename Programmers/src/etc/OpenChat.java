package etc;

import java.util.*;

public class OpenChat {

	public static void main(String[] args) {

	}

    public static ArrayList<String> solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        int recordSize = record.length;
        
        // 사용하기 편하게 분리 & 최종 닉네임 구하기
        String[] log = new String[recordSize*3];
        for(int i=0; i<recordSize; i++) {
        	StringTokenizer st = new StringTokenizer(record[i]);
        	
        	log[i*3] = st.nextToken();
        	log[i*3 + 1] = st.nextToken();
        	if(log[i*3].equals("Leave"))
        		continue;
        	
        	log[i*3 + 2] = st.nextToken();
        	map.put(log[i*3 + 1], log[i*3 + 2]);
        }
        
        ArrayList<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder(20);
        for(int i=0; i<recordSize; i++) {
        	sb.setLength(0);
        	switch(log[i*3]){
        		case "Enter" :
        			sb.append(map.get(log[i*3  + 1])).append("님이 들어왔습니다.");
        			answer.add(sb.toString());
        			break;
        		case "Leave" :
        			sb.append(map.get(log[i*3  + 1])).append("님이 나갔습니다.");
        			answer.add(sb.toString());
        			break;
        	}
        }
        
        return answer;
    }
}
