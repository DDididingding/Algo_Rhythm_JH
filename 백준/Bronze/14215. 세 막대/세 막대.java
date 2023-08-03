import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] side = br.readLine().split(" ");
		int a = Integer.parseInt(side[0]);
		int b = Integer.parseInt(side[1]);
		int c = Integer.parseInt(side[2]);
		int Max = 0;
		
		if(a>=b) {
			if(a>=c) {
				Max = a;
			}else {
				Max = c;
			}
		}else {
			if(b>=c) {
				Max = b;
			}else {
				Max = c;
			}
		}

		int sum = a+b+c;
		int sum1 = 0;
		sum1 = sum - Max;
		if(sum1>Max) {
			System.out.println(sum);
		}else if(sum1 <= Max){
			System.out.println(sum1*2-1);
		}
		
		
	}
	
}
