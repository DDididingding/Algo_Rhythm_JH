import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int [][] pic;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		pic = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j<N; j++) {
				pic[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		System.out.println(zip(0,0,N));
		
		
	}
	
	static String zip(int y, int x, int num) {
		boolean isbreak = false;
		
		for(int i = y; i<y+num; i++) {
			for(int j = x; j<x+num; j++ ) {
				if(pic[i][j] != pic[y][x]) {
					isbreak = true;
					break;
				};
			}
			if(isbreak) break;
		}
		
		if(isbreak) {
			num = num/2;
			String a = zip(y,x,num);
			String b = zip(y+num,x,num);
			String c = zip(y,x+num,num);
			String d = zip(y+num,x+num,num);
			return "("+a+c+b+d+")";
		}else if(pic[y][x] == 0) {
			return "0";
		}else if(pic[y][x] == 1) {
			return "1";
		}
		return "SOMETHING WRONG";
	}

}