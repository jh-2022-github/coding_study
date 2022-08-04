package coding_java_study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


//문제. 신고 결과 받기
// 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
// 한 유저를 여러번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리합니다.
// k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송하니다.
// 유저가 신고한 모든 내용을 츃바하여 마지막에 한꺼번에 게시한 이용 정지를 시키면서 정지 메일을 발송합니다.

public class Reportresult {
	//이용자 id, 신고id, 신고 횟수
	
	//다른 사람 풀이
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = {};

		//한 사람의 신고 횟수를 하나로 처리
		//Arrays.stream: 배열스트림.중복제거.스트림을 list로 변경
		List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
		//카운트
		HashMap<String,Integer> count2 = new HashMap<>();
		
		for(String s:list) {
			//report 안의 값이 {유저 신고유저}로 공백으로 나눠져 있기 때문에 공백후 뒤의 신고 아이디를 가져온다
			String target = s.split(" ")[1];
			//getOrDefault(key, 기본값): 찾는 키가 없으면 기본값으로 출력(즉 있으면 +1해줌)
			count2.put(target, count2.getOrDefault(target, 0)+1);
			System.out.println(count2);
			//{muzi=1, neo=2, frodo=2}
		}
		
		return Arrays.stream(id_list).map(user->{
			//id_list에 값을 하나씩 꺼내 저장
			final String userId = user;
			//stream().filter: 스트림 내 요소 찾기
			//startsWith: list 하나의 값의 시작이 (userId+공백)이 존재하면 list로 만들어 저장
			List<String> reportList = list.stream().filter(s -> s.startsWith(userId+" ")).collect(Collectors.toList());
			System.out.println("reportList : "+reportList);
			
			//System.out.println(reportList.stream().filter(s -> count2.getOrDefault(s.split(" ")[1], 0)>=k).count());
			//reportList에 값을 하나씩 가져와 공백 기준으로 잘라 1번째 있는 값이 count에 존재하면 해당 값과 k값을 비교해 stream 개수 출력
			//즉,muzi가 신고한 2명은 이미 신고가 2번 들어가서 정지 결과를 2번 받고
			//apeach가 신고한 2명중 한명만 정지 결과를 받을 수 있어 1이 출력됨
			//여기서 출력되는 것은 정지 결과를 받는 횟수이다.
			return reportList.stream().filter(s -> count2.getOrDefault(s.split(" ")[1], 0)>=k).count();
		}).mapToInt(Long::intValue).toArray();
		//mapToInt(Long::intValue).toArray(): Stream을 IntStream으로 변환하고 배열로 만들어준다.
		//
		
	};
		

	public static void main(String[] args) {
		Reportresult a = new Reportresult();
		String[] list = {"muzi", "frodo", "apeach", "neo"};
		String[] report =  {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		System.out.println(a.solution(list,report, 2).toString());
		System.out.println("---------------------------");
//		String[] list2 = {"con", "ryan"};
//		String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
//		System.out.println(a.solution(list2,report2, 3));

	}

}
