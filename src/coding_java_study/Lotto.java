package coding_java_study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//로또의 최고 순위와 최저 순위
// 로또의 일부번호가 훼손 되어 0으로 처리했을 때 0의 값이 로또값과 동일시 했을 때의 최고 순위와 0일때의 최저 순위를 알아보자
public class Lotto {
	
	//다른 사람 풀이
	public int[] solution(int[] lottos, int[] win_nums) {
		//HashMap<Integer,Boolean> map = new HashMap<Integer, Boolean>();
		List<Integer> list = new ArrayList<>();
        int zeroCount=0;
        
        //로또 번호가 0이면 zeroCount에 값을 더해서 0 개수 세기
        for(int lotto: lottos){
            if(lotto ==0){
                zeroCount++;
            }
            //0이 아닌 값을 map으로 저장
            //map.put(lotto,true);
            list.add(lotto);
        }
        
        int sameCount = 0;
        //map안에 win_nums값이 있으면 sameCount에 값 더하기
        for(int winNum : win_nums) {
        	//if(map.containsKey(winNum)) sameCount++;
        	if(list.contains(winNum)) sameCount++;
        }
        //순위 구하기
        int maxRank = 7-(sameCount+zeroCount); //7-(같은번호개수+0개수)
        int minRank = 7-sameCount;			   //7-같은번호개수
        if(maxRank > 6) maxRank=6;				//번호가 다 일치하지 않으면 7이기 때문에 6으로 변경
        if(minRank > 6) minRank=6;
        return new int[] {maxRank,minRank};
    }
    
	public static void main(String[] args) {
		Lotto lo = new Lotto();
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		System.out.println(lo.solution(lottos, win_nums));
		
		int[] lottos2 = {0, 0, 0, 0, 0, 0};
		int[] win_nums2 = {38, 19, 20, 40, 15, 25};
		System.out.println(lo.solution(lottos2, win_nums2));
		
		int[] lottos3 = {45, 4, 35, 20, 3, 9};
		int[] win_nums3 = {20, 9, 3, 45, 4, 35};
		System.out.println(lo.solution(lottos3, win_nums3));
		

	}

}
