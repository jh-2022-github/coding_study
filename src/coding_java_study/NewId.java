package coding_java_study;

public class NewId {
	
	//내 풀이
	public String solution(String new_id) {
		
        //소문자로 변경 - 문자 제거 - 마침표 2개 이상은 .으로 바꾸기
        new_id = new_id.toLowerCase().replaceAll("[^-_.0-9-_.a-z-_.]","").replaceAll("[.]+",".");

        //마침표 처음이나 끝에 있으면 제거
        if(new_id.startsWith(".")) {
        	new_id= new_id.substring(1);
        }
        if(new_id.endsWith(".")) {
        	new_id= endwith(new_id);
        }
        //빈 문자열이면 a넣기
        if(new_id.equals("")){
        	new_id="a";
        }
        //길이가 16자 이상이면 15개 문자를 제외한 나머지 제거
        if(new_id.length()>=16) {
        	new_id=new_id.substring(0, 15);
        	//제거후 마지막 문자가 .이면 . 삭제
            if(new_id.endsWith(".")) {
            	new_id= endwith(new_id);
            }
        }else if(new_id.length()<=2){ //길이가 2자 이하면, 마지막 문자를 길이가 3이 될 때까지 반복
        	for(;new_id.length()<3;){
        		String endWord = new_id.substring(new_id.length()-1);
        		new_id+=endWord;
        	}
        }
		return new_id;
	}
	public String endwith(String newId) {
		return newId.substring(0,newId.length()-1);
	}
	
	public static void main(String[] args) {
		NewId ni = new NewId();
		ni.solution( "...!@BaT#*..y.abcdefghijklm.");
		ni.solution( "...!@Bq");
		
	}

}
