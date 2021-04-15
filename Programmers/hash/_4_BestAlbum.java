package practiceCodingTest;

import java.io.*;
import java.util.*;

public class _4_BestAlbum {

	public static void main(String[] args) throws IOException {
		/* 테스트 하려고 적은거
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
        
        // 장르별로 횟수를 합침
        for(int i=0; i<numPlays; i++){
            tempMap.put(genres[i], tempMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 플레이 횟수 순으로 정렬하기 위해 Value <-> Key 바꾸어 TreeMap에 넣음
        for(String key : tempMap.keySet()){
            playCntSumMap.put(tempMap.get(key), key);
        }
        
        HashMap<String, Integer> rankMap = new HashMap<String, Integer>(); // 장르 별 순위 map
        int rank = 100; // 걍 꼴찌가 100등부터 시작한다 하자.
        for(String val : playCntSumMap.values()){ // 장르 순위별로 배열에 담기 (오름차순)
            rankMap.put(val, rank--); // 장르, 순위
        }
        
        Song[] songs = new Song[numPlays];
        for(int i=0; i<numPlays; i++){
            songs[i] = new Song(rankMap.get(genres[i]), plays[i], i);
        }
        
        Arrays.sort(songs, new Comparator<Song>(){
           
            @Override
            public int compare(Song o1, Song o2){
                if(o1.genreRank != o2.genreRank){ // 장르가 같지 않다면
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
            if(preGenre != song.genreRank){ // 새로운 장르가 나오면
                cnt = 0; // 카운트 초기화
                preGenre = song.genreRank;
            } else if (cnt>=2) { // 이미 상위 2개를 저장했으면
                continue; // 다음걸로 넘어가
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
    int genreRank; // 장르 순위
    int plays; // 플레이 횟수
    int uniqueNumber; // 고유 번호
    
    Song (int genreRank, int plays, int uniqueNumber){
        this.genreRank = genreRank;
        this.plays = plays;
        this.uniqueNumber = uniqueNumber;
    }
}