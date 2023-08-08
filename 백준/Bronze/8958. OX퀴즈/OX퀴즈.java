import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			String quiz = br.readLine();
			int score = 0;
			int totalScore = 0;
			for(int i = 0; i< quiz.length(); i++) {
				if(quiz.charAt(i)=='O' ) {
					score++;
				}else {
					score = 0;
				}
				totalScore += score;
			}
			
			System.out.println(totalScore);
		}
		
	}

}