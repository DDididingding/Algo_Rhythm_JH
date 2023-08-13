import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] A = new int[9][9];
		String[] str;
		int max = -1;
		int x = -1;
		int y = -1;
		
		
		for(int i = 0; i <9; i++) {
			str = br.readLine().split(" ");
			for(int j = 0; j<9; j++) {
				A[i][j] = Integer.parseInt(str[j]);
				if(max<= A[i][j]) {
					max = A[i][j];
					x = i+1;
					y = j+1;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(x+" "+y);
		
	}

}