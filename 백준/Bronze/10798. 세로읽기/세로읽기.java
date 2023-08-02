import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [][] str = new String[5][15];
		String[][] decode = new String[5][15];//문자 변환을 위한 두 개의 배열 생성
		
		
		
		for(int i = 0; i <5; i++) {
			decode[i] = br.readLine().split(""); 
			//문자열 입력받기 이렇게 받으면 15줄 보다 작으면 칸을 안남겨놓고 남은 칸은 삭제해버리더라
			for(int j = 0; j< decode[i].length; j++) {
				str[i][j] = decode[i][j]; //5*15의 크기를 가진 배열에 글자 이식
			}
			
		}
		
//		for(int i = 0; i<15; i++) {
//			for(int j = 0; j<5; j++) {
//				if(str[j][i] == null) {
//					str[j][i] ="_";
//				}
//				}
//			} //처음엔 초기화를 해야하나 해서 초기화했는데 안해도 됨
		
		for(int i = 0; i<15; i++) {
			for(int j = 0; j<5; j++) {
				if(str[j][i]!= null) {
					System.out.print(str[j][i]);
				}
			}
		}
		
	}

}