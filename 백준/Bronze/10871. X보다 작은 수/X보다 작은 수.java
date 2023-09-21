import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int X = sc.nextInt();
		
		for(int i = 0 ; i< N; i++) {
			int now = sc.nextInt();
			
			if(now<X) {
				sb.append(now);
				sb.append(" ");
			}
		}
		
		sb.deleteCharAt(sb.length()-1);
		
		System.out.println(sb);
	}
}