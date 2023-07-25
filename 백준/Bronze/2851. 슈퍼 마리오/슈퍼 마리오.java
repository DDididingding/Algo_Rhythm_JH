import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int temp = 0;
		int sum = 0;
		int sum1 = 0;
		
		for(int i = 0; i <10 ; i++) {
			temp = Integer.parseInt(br.readLine());
				sum += temp;
				if(sum == 100) {
					System.out.println(sum);
					break;
				}else if (sum > 100) {
					sum1 = sum;
					sum -= temp;
					
					if (sum1-100 > 100-sum) {
						System.out.println(sum);
					}else if(sum1-100 <= 100-sum) {
						System.out.println(sum1);
					}
					
					break;
				}
			
				if(i ==9 && sum<100) {
					System.out.println(sum);
				}
			}
		

		
	}
}
