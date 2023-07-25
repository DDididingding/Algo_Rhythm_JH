
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int onoff = Integer.parseInt(br.readLine());
		String[] onofflist = br.readLine().split(" ");// 스위치 리스트 입력받기
		
		int person = Integer.parseInt(br.readLine());// 몇명
		
		for(int i = 0; i < person; i++) {
			
			String[] go = br.readLine().split(" ");
			int[] go1 = new int[2];
			go1[0] = Integer.parseInt(go[0]);
			go1[1] = Integer.parseInt(go[1]); // 조작법 입력받기
			int idx = 0;
// 여기까진 됨
			if(go1[0] == 1) { //남자면
				//여기도 됨
				int q = 1;
				while(true) {// 일단 실행
					idx = q*go1[1]-1; //배수인 인덱스 찾아서
					if (idx >= onoff) break; // 인덱스가 onoff길이 바깥이면 break 
					if (onofflist[idx].equals("0")) {
						onofflist[idx] = "1";
						

					}else if (onofflist[idx].equals("1")) {

						onofflist[idx] = "0";

					}
						
					// 아니면 조작
					q++;// 다음 배수 찾기
					
				}


			}else if(go1[0] == 2) {//여자면
				idx = go1[1]-1;
				int step = 0;
				while(true) {//대칭인지 검사
					if (idx-step < 0 || idx + step > onoff-1) {
						step--;
						for (int s = idx-step; s <= idx+step; s++) {
							if (onofflist[s].equals("0")) {
								onofflist[s] = "1";
							}else if (onofflist[s].equals("1")) onofflist[s] = "0";
							
						}
						break;
					}
					if(onofflist[idx-step].equals(onofflist[idx+step]) ) {
						
						step++;
						
					}else { //대칭 아니면
						step--; //이전 간격으로
						for (int s = idx-step; s <= idx+step; s++) {
							if (onofflist[s].equals("0")) {
								onofflist[s] = "1";
							}else if (onofflist[s].equals("1")) onofflist[s] = "0";
							
						}
						break;
					}
					
				}
				
		
				
			}
			
			
			

			
			
		}
		for (int i =0; i < onoff; i++) {
			System.out.print(onofflist[i]);
			if((i+1)%20 == 0) {
				System.out.println();
			}else {
				System.out.print(" ");
			}
		}
		

		
	}

}
