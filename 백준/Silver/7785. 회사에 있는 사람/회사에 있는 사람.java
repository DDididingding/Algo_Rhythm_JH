import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, String> map = new TreeMap<String, String>(Collections.reverseOrder());
		String[] log = new String[2];
		int N = Integer.parseInt(br.readLine());
		for(int n = 1; n<=N; n++) {
			log = br.readLine().split(" ");
			map.put(log[0],log[1]);			
		}
		
        for (String key : map.keySet()) {
            String value = map.get(key);
            if (value.equals("enter")) {
                System.out.println(key);
            }
        }
		
		
		
		
		
	}
}