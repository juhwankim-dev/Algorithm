package _16_greedyAlgorithm;

import java.io.*;
import java.util.*;

public class _2_ConferenceRooms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Conference[] list = new Conference[N];
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list[i] = new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(list, new Comparator<Conference>() {
			@Override
			public int compare(Conference o1, Conference o2) {
				
				if(o1.endTime == o2.endTime) {
					return o1.startTime-o2.startTime;
				}
				
				return o1.endTime - o2.endTime;
			}
		});
		
		int count=0;
		int preEndTime=0;
		for(int i=0; i<N; i++) {
			if(list[i].startTime >= preEndTime) {
				count++;
				preEndTime = list[i].endTime;
			}
		}
		
		System.out.println(count);
	}

}

class Conference {
	int startTime;
	int endTime;
	
	Conference(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
}

// ���� �а� �������� 3��
// 7�б��� Ǯ�ٰ� ���� ���ľ��� �𸣰ھ ��� ���... ���ĸ��� �� �����ϰ� ����
// 11�е��� Ǯ���µ� �ƹ��� ���� �ùٸ� ����� �ƴѰͰ���.
// ���� Ʋ�� ����̿���. �ٸ� ����� ���� ������.