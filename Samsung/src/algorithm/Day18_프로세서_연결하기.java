package algorithm;

import java.io.*;
import java.util.*;

public class Day18_프로세서_연결하기 {
	static int N, min, maxCore;
	static int[][] pro;
	static ArrayList<Core> coreList = new ArrayList<>();
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			pro = new int[N + 2][N + 2]; // 전원 사용 여부를 저장하기 위함
			coreList.clear();
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					pro[i][j] = Integer.parseInt(st.nextToken());

					if (pro[i][j] == 1 && (i > 1 && j > 1 && i < N && j < N)) {
						coreList.add(new Core(i, j));
					}
				}
			}

			maxCore = 0;
			min = Integer.MAX_VALUE;
			dfs(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int idx, int cableLen, int core) {
		
		// ************ 이거 가지치기하면 틀리다고 뜨는데 이유를 모르겟음;;;
		if (core < maxCore && cableLen >= min) { // 이전에 찾은 놈보다 코어수도 작은데 길이는 더 길다? 돌아가.
			return;
		}
		
		if (idx == coreList.size()) {
			if(maxCore < core) {
				maxCore = core;
				min = cableLen;
			} else if(maxCore == core){
				min = Math.min(cableLen, min);
			}
			
			return;
		}

		Core c = coreList.get(idx);
		for (int j = 0; j < 4; j++) {
			int powerY = (dy[j] == 0) ? c.y : getPowerPos(dy[j]);
			int powerX = (dx[j] == 0) ? c.x : getPowerPos(dx[j]);

			if (pro[powerY][powerX] == 0 && isConnectable(c.y, c.x, j)) {
				dfs(idx + 1, cableLen + connect(c.y, c.x, j, 2) - 1, core + 1); // 케이블 설치
				connect(c.y, c.x, j, 0); // 케이블 철수
			}
		}
		dfs(idx + 1, cableLen, core); // 선택하지 않는 경우
	}

	public static int getPowerPos(int xy) {
		return (xy == -1) ? 0 : N;
	}
	
	public static boolean isConnectable(int y, int x, int i) {
		while(check(y,x)) {
			y += dy[i];
			x += dx[i];
			
			if(pro[y][x] != 0) {
				return false;
			}
		}
		
		return true;
	}

	public static int connect(int y, int x, int i, int cable) {
		int cnt = 0;
		while(check(y, x)) {
			y += dy[i];
			x += dx[i];
			pro[y][x] = cable;
			cnt++;
		}
		return cnt;
	}

	public static boolean check(int y, int x) {
		if (y < 1 || x < 1 || y >= N + 1 || x >= N + 1)
			return false;
		else
			return true;
	}
}

class Core {
	int y;
	int x;

	public Core(int y, int x) {
		this.y = y;
		this.x = x;
	}
}