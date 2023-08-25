import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			
			
			String[] str = br.readLine().split(" ");
			int height = Integer.parseInt(str[0]);
			int width = Integer.parseInt(str[1]);
			String[][] flag = new String[height][width];
			int[] W = new int [height];
			int[] B = new int [height];
			int[] R = new int [height];
					
			for(int i = 0; i<height; i++) {
				flag[i] = br.readLine().split(""); 
			}
			
			for(int i = 0; i<height; i++) {
				for(int j = 0; j<width; j++) {
					if(flag[i][j].equals("W")) W[i]++;
					if(flag[i][j].equals("B")) B[i]++;
					if(flag[i][j].equals("R")) R[i]++;// 열별로 W,B,R의 개수 구하기
				}
			}
			
			
			int min = Integer.MAX_VALUE;
			for(int i = 0; i<height-2; i++) {
				for(int j = i+1; j < height -1; j++) {
					for(int k = j+1; k< height; k++) {// 각 분기점 계산
						int cnt = 0;

						for(int w = 0; w<=i; w++) {
							cnt += width - W[w];// 라인마다  W가 아닌 점의 수 계산
						}
						for(int b = i+1; b<=j; b++) {
							cnt += width - B[b];// 라인마다  B가 아닌 점의 수 계산
						}
						for(int r = j+1; r<height; r++) {
							cnt += width - R[r];// 라인마다  R이 아닌 점의 수 계산
						}
						if(cnt<=min) {
							min = cnt; //다 더한게 최솟값보다 작으면 최소값에 저장
						}

					}
				}
				
			}
			
			System.out.println("#"+t+" "+min);
			
			
			
			
			
		}
		
	}
	
	

}