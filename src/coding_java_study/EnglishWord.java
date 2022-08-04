package coding_java_study;

import java.util.HashMap;
import java.util.Map;

public class EnglishWord {
	// 단어 하나씩 가져와 일치하는 값이 있으면 숫자로 변경
	
	//다른 사람 풀이
	public int solution2(String s) {
        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(int i=0;i<alphabets.length;i++) {
        	s = s.replaceAll(alphabets[i], Integer.toString(i));
        	System.out.println(s);
        }
        
		return Integer.parseInt(s);
	}
	
	//내 풀이
	public int solution(String s) {
		int answer = 0;
		String num ="";
        Map<Integer,String> map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        
        char[] word = s.toCharArray();
        String addWord ="";
        for(char n: word) {
        	addWord = addWord+n;
        	if(Character.isDigit(n)) {
        		num = num+addWord;
        		addWord ="";
        	}else {
            	for(Integer key: map.keySet()) {
            		if(map.get(key).equals(addWord)) {
            			num = num+key;
            			addWord ="";
            		}
            		
            	}
        	}
        }
        answer = Integer.parseInt(num);
        return answer;
    }
	
	public static void main(String[] args) {
		EnglishWord ew = new EnglishWord();
		ew.solution2("sevenone4eight");
		ew.solution("sevenone4eight");

	}

}
