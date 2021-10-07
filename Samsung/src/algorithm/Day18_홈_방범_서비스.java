package algorithm;

import java.io.*;
import java.util.*;

public class Day18_홈_방범_서비스 {
	static int[][] city;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[] profits = new int[23];
	static int N, M, homeMax;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			city = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					city[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			init();

			homeMax = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					calc(i,j);
				}
			}

			sb.append("#").append(tc).append(" ").append(homeMax).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void init() {
		for (int k = 1; k <= 22; k++) {
			profits[k] = k * k + (k - 1) * (k - 1);
		}
	}
	
	static void calc(int x, int y) {
        for (int k = 0; k < N + 2; k++) {
            int homecnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (Math.abs(i - x) + Math.abs(j - y) < k && city[i][j] == 1) {
                        homecnt++;
                    }
                }
            }
            int profit = (homecnt * M) - profits[k];
            if (profit < 0)
                continue;
            else
            	homeMax = Math.max(homecnt, homeMax);
        }
	}
}
/*

package algorithm;

import java.io.*;
import java.util.*;

public class Day18_홈_방범_서비스 {
	static int[][] city;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[] profits = new int[23];
	static int N, M, homeCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			city = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					city[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			init();

			int homeMax = 0, profit = 0;
			for (int k = N - 1; k > 0; k--) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						visited = new boolean[N][N];
						homeCnt = 0;
						bfs(i, j, k);

						profit = homeCnt * M - profits[k];
						//System.out.println("homeCnt: " + homeCnt + " M: " + M + " profits[k]: " + profits[k]);
						//System.out.println("homeCnt: " + homeCnt);
						if (homeCnt > homeMax && profit >= 0) {
							
							//System.out.println("homeCnt: " + homeCnt + " K: " + k + " profit: " + profit);
							//System.out.println();
							homeMax = homeCnt;
						}
					}
				}
				
				if(profit > 0) break;
			}

			sb.append("#").append(tc).append(" ").append(homeMax).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void init() {
		for (int k = 1; k <= 22; k++) {
			profits[k] = k * k + (k - 1) * (k - 1);
		}
	}
	
	public static void bfs(int y, int x, int k) {
		Queue<P> queue = new LinkedList<>();
		queue.add(new P(y, x));
		visited[y][x] = true;
		if(city[y][x] == 1) homeCnt++;
		
		while(!queue.isEmpty()) {
			P p = queue.poll();
			
			// 범위를 넘어서면 continue
			//if() {
			//	System.out.println(homeCnt + " " + y + " " + x);
			//	break;
			//}
			
			for(int i=0; i<4; i++) {
				int newY = p.y + dy[i];
				int newX = p.x + dx[i];
				
				if (check(newY, newX) && !visited[newY][newX] && Math.abs(y - newY) + Math.abs(x - newX) < k) {
					//System.out.println(homeCnt + " (" + y + ", " + x + ")");
					visited[newY][newX] = true;
					queue.add(new P(newY, newX));
					if(city[newY][newX] == 1) homeCnt++;
				}
			}
		}
	}

	public static boolean check(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= N) {
			return false;
		}

		return true;
	}
}

class P {
	int y;
	int x;
	
	public P(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

*/