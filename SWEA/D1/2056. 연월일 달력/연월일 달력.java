import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		for(int i = 1; i<= N; i++) {
			String wow = bf.readLine();
			int month = Integer.parseInt(wow.substring(4, 6));
			int day = Integer.parseInt(wow.substring(6, 8));
			
			int[] days = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
			
			if(month>12 || month<1) {
				System.out.println("#"+ i + " "+ "-1");
			}else {
				if(day<0 || day >days[month-1]) {
					System.out.println("#"+ i + " "+"-1");
				}else {
					System.out.println("#"+ i + " " + wow.substring(0, 4)+"/"+ wow.substring(4, 6) + "/" + wow.substring(6, 8));
				}
			}
			
		}
		
		
		
		
	}

}
