import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[100][100];
		int sum = 0;
		
		
		for(int n = 0; n<N; n++) {
			String[] str = new String[2];
			str = br.readLine().split(" ");
			int startx = Integer.parseInt(str[0]);
			int starty = Integer.parseInt(str[1]);
			
			for(int i = startx; i<startx+10; i++) {
				for(int j = starty; j <starty+10; j++) {
					paper[i][j] = 1;
				}
			}
		}
		
		for(int i =0 ;i<100; i++) {
			for(int j =0; j<100; j++) {
				sum += paper[i][j];
			}
		}
		
		System.out.println(sum);
		
	}
}