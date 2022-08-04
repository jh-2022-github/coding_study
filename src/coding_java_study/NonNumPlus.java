package coding_java_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonNumPlus {
	
	//다른 사람 풀이
	public int solution2(int[] numbers) {
		int sum = 45;
		for(int i : numbers) {
			sum -=i;
		}
		return sum;
	} 
	
	//내 풀이
	public int solution(int[] numbers) {
		 int answer = 0;
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		
        for(int num :numbers){
        	//일치하는값 삭제
        	list.remove(Integer.valueOf(num));
        }
        for(int num:list) {
        	answer +=num;
        }
       System.out.println(answer);
        return answer;
    }
	
	public static void main(String[] args) {
		NonNumPlus nnp = new NonNumPlus();
		int[] a= {1, 2, 3, 4, 6, 7, 8, 0};
		nnp.solution(a);
	}
}
