import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
			String st = br.readLine();
			String[] str = st.split(" ");
			int A = Integer.parseInt(str[0]);
			int B = Integer.parseInt(str[1]);
			System.out.println(A*B);

	}
}