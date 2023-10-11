import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static double sum;
	static int[] list;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new int[N];
			
			String[] str = br.readLine().split(" ");
			
			for(int i = 0; i< N; i++) {
				list[i] = Integer.parseInt(str[i]);
			}
			
			Subset(0,0,0,0);
			
			sum = sum/(Math.pow(2, N)-1);
			System.out.println("#"+t+" "+sum);
			
			sum = 0;
		}
		
		
	}

	private static void Subset(int now, int idx, double plus, double cnt) {
		if(idx == N && cnt != 0) {
			sum += plus/cnt;
			return;
		}else if(idx == N && cnt == 0){
			return;
		}
		
		Subset(list[idx], idx+1, plus+list[idx],cnt+1);
		Subset(list[idx], idx+1, plus,cnt);
		
		
	}

}