import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
	public static void main(String[] args) throws IOException{
		String[] Alpha = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z" };
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String trans = br.readLine();

		for (int i =0; i <trans.length(); i++) {
			
			for (int j = 0; j< 26; j++) {
				if(trans.substring(i,i+1).equals(Alpha[j])) {
					System.out.print(j+1+" ");
				}
			}
			
		}
		
		
		
	}
}
