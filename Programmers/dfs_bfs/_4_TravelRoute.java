package dfs_bfs;

import java.util.*;

public class _4_TravelRoute {

	static int numberTickets;
	static ArrayList<String> list = new ArrayList<String>();
	static StringBuilder sb;
	static boolean[] used;
	
	public static void main(String[] args) {
		String[][] tickets = {
				
				
				/*
				 * {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL",
				 * "SFO"}
				 */
				 
				 
				/*
				 * {"ICN", "A"}, {"A", "B"}, {"A", "C"}, {"C", "A"}, {"B", "D"}
				 */
				
				/*
				 * {"ICN","AAA"}, {"ICN","AAA"}, {"AAA","ICN"}, {"AAA","CCC"}
				 */
				
				  {"ICN","AAA"}, {"AAA","CCC"}, {"AAA","DDD"}, {"DDD","BBB"}, {"BBB","AAA"}
				 
		};

		String[] answer = solution(tickets);
		for(String s : answer) {
			System.out.println(s);
		}
	}

    public static String[] solution(String[][] tickets) {
        numberTickets = tickets.length;
        sb = new StringBuilder((numberTickets+1)*4);
        
        for(int i=0; i<numberTickets; i++) {
        	if(tickets[i][0].equals("ICN")) { // 출발은 무조건 ICN에서 해야하므로..
        		used = new boolean[numberTickets];
            	used[i] = true;
            	dfs(tickets[i][0], tickets[i][1], tickets, 1);
            	sb.setLength(0);
        	}
        }

        Collections.sort(list);       
        String[] answer = list.get(0).split(" ");

        return answer;
    }
    
    public static void dfs(String preCity, String nextCity, String[][] tickets, int cnt) {
    	sb.append(preCity);
    	sb.append(" ");
    	
    	if(cnt == numberTickets) {
        	sb.append(nextCity);
        	sb.append(" ");
    		list.add(sb.toString());
    		sb.delete(sb.length()-4, sb.length());
    		return;
    	}

    	for(int i=0; i<numberTickets; i++) {
    		if(nextCity.equals(tickets[i][0]) && !used[i]) { // 다음에 가려는 도시가 일치하고, 사용한 적 없는 티켓이면
    			used[i] = true;
    			dfs(nextCity, tickets[i][1], tickets, cnt+1);
    			sb.delete(sb.length()-4, sb.length());
    			used[i] = false;
    		}
    	}
    }
}

/*
import java.util.*;

class Solution {
	static int numberTickets;
    static ArrayList<String> list = new ArrayList<String>();
    
    public String[] solution(String[][] tickets) {
               numberTickets = tickets.length;

        for(int i=0; i<numberTickets; i++) {
        	if(tickets[i][0].equals("ICN")) { // 출발은 무조건 ICN에서 해야하므로..
        		boolean[] used = new boolean[numberTickets];
            	used[i] = true;
            	dfs(tickets[i][0], tickets[i][1], tickets, "", 0, used);
        	}
        }

        Collections.sort(list);       
        String[] answer = list.get(0).split(" ");

        return answer;
    }
    
    public static void dfs(String preCity, String nextCity, String[][] tickets, String route, int cnt, boolean[] used) {
    	if(cnt == numberTickets - 1) {
    		route += preCity + " ";
    		route += nextCity + " ";
    		list.add(route);
    		return;
    	}
    	
    	route += preCity + " ";
    	cnt++;
    	for(int i=0; i<numberTickets; i++) {
    		if(nextCity.equals(tickets[i][0]) && !used[i]) { // 다음에 가려는 도시가 일치하고, 사용한 적 없는 티켓이면
    			used[i] = true;
    			dfs(nextCity, tickets[i][1], tickets, route, cnt, used);
    			used[i] = false;
    			//route.substring(route.length()-4, route.length());
    		}
    	}
    }
}
*/