package practiceCodingTest;

import java.io.*;
import java.util.*;

public class _4_BestAlbum {

	public static void main(String[] args) throws IOException {
		/* �׽�Ʈ �Ϸ��� ������
		 * classic pop classic classic jazz pop Rock jazz
			500 600 150 800 1100 2500 100 1000

		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 * StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		 * 
		 * int size = st.countTokens();
		 * 
		 * String[] t1 = new String[size]; int[] t2 = new int[size];
		 * 
		 * for(int i=0; i<size; i++) { t1[i] = st.nextToken(); }
		 * 
		 * StringTokenizer st2 = new StringTokenizer(br.readLine(), " "); for(int i=0;
		 * i<size; i++) { t2[i] = Integer.parseInt(st2.nextToken()); }
		 * 
		 * int[] temp = solution(t1, t2);
		 * 
		 * for(int t : temp) { System.out.println(t); }
		 */
	}

	public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int numPlays = plays.length;
        HashMap<String, Integer> tempMap = new HashMap<String, Integer>();
        TreeMap<Integer, String> playCntSumMap = new TreeMap<Integer, String>();
        
        // �帣���� Ƚ���� ��ħ
        for(int i=0; i<numPlays; i++){
            tempMap.put(genres[i], tempMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // �÷��� Ƚ�� ������ �����ϱ� ���� Value <-> Key �ٲپ� TreeMap�� ����
        for(String key : tempMap.keySet()){
            playCntSumMap.put(tempMap.get(key), key);
        }
        
        HashMap<String, Integer> rankMap = new HashMap<String, Integer>(); // �帣 �� ���� map
        int rank = 100; // �� ��� 100����� �����Ѵ� ����.
        for(String val : playCntSumMap.values()){ // �帣 �������� �迭�� ��� (��������)
            rankMap.put(val, rank--); // �帣, ����
        }
        
        Song[] songs = new Song[numPlays];
        for(int i=0; i<numPlays; i++){
            songs[i] = new Song(rankMap.get(genres[i]), plays[i], i);
        }
        
        Arrays.sort(songs, new Comparator<Song>(){
           
            @Override
            public int compare(Song o1, Song o2){
                if(o1.genreRank != o2.genreRank){ // �帣�� ���� �ʴٸ�
                    return o1.genreRank - o2.genreRank;
                } else if(o1.plays != o2.plays){
                    return o2.plays - o1.plays;
                }
                return o1.uniqueNumber - o2.uniqueNumber;
            }
        });
        
        ArrayList<Integer> albumList = new ArrayList<Integer>();
        int cnt = 0;
        int preGenre = Integer.MAX_VALUE;
        for(Song song : songs){
            if(preGenre != song.genreRank){ // ���ο� �帣�� ������
                cnt = 0; // ī��Ʈ �ʱ�ȭ
                preGenre = song.genreRank;
            } else if (cnt>=2) { // �̹� ���� 2���� ����������
                continue; // �����ɷ� �Ѿ
            }
            albumList.add(song.uniqueNumber);
            cnt++;
        }
        
        int albumSize = albumList.size();
        answer = new int[albumSize];
        for(int i=0; i<albumSize; i++) {
        	answer[i] = albumList.get(i);
        }
        
        return answer;
    }

}

class Song {
    int genreRank; // �帣 ����
    int plays; // �÷��� Ƚ��
    int uniqueNumber; // ���� ��ȣ
    
    Song (int genreRank, int plays, int uniqueNumber){
        this.genreRank = genreRank;
        this.plays = plays;
        this.uniqueNumber = uniqueNumber;
    }
}