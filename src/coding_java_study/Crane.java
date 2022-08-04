package coding_java_study;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Crane {
	
	//2차원 배열 
	//사라진 같은 값의 개수 구하기
	
	//재 풀이
    public int solution3(int[][] board, int[] moves) {
    	int answer = 0;
    	Stack<Integer> stack = new Stack<>();
    	
    	for(int n : moves) {
        	for(int j=0;j<board.length;j++) {
        		if(board[j][n-1]!=0) {
        			if(stack.isEmpty()) {
        				stack.push(board[j][n-1]);
        			}else{           			
        				if(stack.peek()== board[j][n-1]) { //stack.peek(): stack의 가장 위에 있는 값 반환
        					stack.pop();					//마지막 값 꺼내기
            				answer+=2;						//사라진 인형 개수 등록
            			}else {
            				stack.push(board[j][n-1]);
            			}
        			}
        			

        			board[j][n-1]=0;	//값 0으로 처리
        			break;				//값을 가져왔으면 for문 나오기
        		}
    		}
    	}
    	
        return answer;
    }
	
    
	//다른 사람 풀이
	public int solution2(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>(); //후입선출
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (stack.isEmpty()) {				//값이 없으면
                        stack.push(board[j][move - 1]);
                        board[j][move - 1] = 0;
                        break;
                    }
                    if (board[j][move - 1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else
                        stack.push(board[j][move - 1]);
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
	
	//내 풀이
    public int solution(int[][] board, int[] moves) {
    	int answer = 0;
    	List<Integer> box = new ArrayList<>();
    	
    	for(int n : moves) {
        	for(int j=0;j<board.length;j++) {
        		if(board[j][n-1]!=0) {
        			if(box.size()==0) {
        				box.add(board[j][n-1]);
        			}else {           			
        				if(box.get(box.size()-1)== board[j][n-1]) { //box 마지막 값과 크레인으로 가져온 값이 동일하면
            				box.remove(box.size()-1);		//box 마지막 값 삭제
            				answer+=2;						//사라진 인형 개수 등록
            			}else {
            				box.add(board[j][n-1]);
            			}
        			}
        			

        			board[j][n-1]=0;	//값 0으로 처리
        			break;				//값을 가져왔으면 for문 나오기
        		}
    		}
    	}
    	
        return answer;
    }
	
    //재 풀이
    
    
	public static void main(String[] args) {
		Crane crane = new Crane();
		int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2},{3, 5, 1, 3, 1}};
		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
		crane.solution(board,moves);

	}

}
//4204
//[[0,0,0,0,0],
// [0,0,1,0,3],
// [0,2,5,0,1],
// [4,2,4,4,2],
// [3,5,1,3,1]]
//{1, 5, 3, 5, 1, 2, 1, 4}
// 4, 3, 1, 1  3 ,2  0, 4		 