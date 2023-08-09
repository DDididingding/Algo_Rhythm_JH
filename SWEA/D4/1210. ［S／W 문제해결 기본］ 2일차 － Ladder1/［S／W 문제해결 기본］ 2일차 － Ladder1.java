import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t<=10; t++) {
			String T = br.readLine();
			
			int[][] map = new int[100][100];
			int row = 99;
			int col = 0;
			int X = 0; //출발지점
			
			for(int n = 0; n<100; n++) {
				String[] str = br.readLine().split(" ");
				for (int m = 0; m<100; m++) {
					map[n][m] = Integer.parseInt(str[m]);
				}
			}	//2차원 배열 입력받기
			
			for(int n = 0; n<100; n++) {
				if(map[99][n] == 2) {
					col = n;
					break;
				}
			} //도착지점 인덱스 찾기
			
			
			while(row>0) { //row가 0이되면 종료
				if(col!=0 && map[row][col-1]==1) { //내 왼쪽에 1이 있으면
					while( map[row][col-1]==1) { //왼쪽 벽을 마주치거나 , 더이상 왼쪽에 1이 안나올때까지
						col--;	//왼쪽으로 이동
						if(col == 0) break;
					}
					row--; //왼쪽 이동을 마쳤으면 한칸 위로 무조건 올라감
					
				}else if(col!=99 && map[row][col+1]==1) { //아니고 내 오른쪽에 1이 있다면
					while( map[row][col+1]==1) { //오른쪽 벽을 마주치거나, 더이상 오른쪽에 1이 안나올때까지
						col++;//오른쪽으로 이동
						if (col == 99) break;
					}
					row--; //오른쪽 이동을 마쳤으면 한칸 위로 무조건 올라감
				
				}else {
					row--; //아무것도 없으면 위로
				}
				
			}
			//이 작업을 마친 후
			X = col; //현재 열 번호가 답
			
			System.out.printf("#%d %d%n",t,X);
			
			
			
			
		}
		
	}

}