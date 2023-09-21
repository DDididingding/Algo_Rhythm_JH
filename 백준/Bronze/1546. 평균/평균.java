import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0;
		int[] score = new int[N];
		float sum = 0 ; 
		if(N !=0) {
			for(int i = 0 ; i<N; i++) {
				score[i] = sc.nextInt();
				if(max<score[i]) max = score[i];
			}
			
			for(int i = 0; i<N; i++) {
				sum += ((float) score[i]/ (float) max)*100;
			}
			sum = sum/N;
			
			System.out.println(sum);
		}else {
			System.out.println(0);
		}
		
	}
}