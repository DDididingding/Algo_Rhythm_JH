import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int GCD = 0;
		int LCM = 0;
		
		if(A<B) {	//sort A,B
			int temp = A;
			A = B;
			B = temp;
		}
		int R1 = A;
		int R2 = B;
		

		while(true) {
			if(R1%R2 ==0) {
				GCD = R2;
				break;
			}else {
				int temp = R1; //renew R1,R2
				R1 = R2;
				R2 = temp%R2;
			}
		}
		
		System.out.println(GCD);
		
		int a = A/GCD;
		int b = B/GCD;
		
		LCM = a*b*GCD;
		
		System.out.println(LCM);
		
		
	}
}