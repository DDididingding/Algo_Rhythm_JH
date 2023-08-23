import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static String[][] tree;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			tree = new String[N + 1][3];
			for (int n = 1; n < N + 1; n++) {
				String[] str = br.readLine().split(" ");
				if (str.length == 4) {
					tree[n][0] = str[1];
					tree[n][1] = str[2];
					tree[n][2] = str[3];
				} else if (str.length == 2) {
					tree[n][0] = str[1];
				}
			}

			cal(1);
			System.out.println("#" + t + " " + tree[1][0]);

		}

	}

	public static void cal(int i) {
		if (i <= N) {
			if (!Character.isDigit(tree[i][0].charAt(0))) {// 내가 숫자가 아니면
				if (!Character.isDigit(tree[Integer.parseInt(tree[i][1])][0].charAt(0))) {// 나랑 연결된 앞 노드가 숫자가 아니면
					cal(Integer.parseInt(tree[i][1]));
				}
				if (!Character.isDigit(tree[Integer.parseInt(tree[i][2])][0].charAt(0))) {// 나랑 연결된 뒤 노드가 숫자가 아니면
					cal(Integer.parseInt(tree[i][2]));
				}

				if (tree[i][0].equals("+")) {
					tree[i][0] = Integer.toString(Integer.parseInt(tree[Integer.parseInt(tree[i][1])][0])
							+ Integer.parseInt(tree[Integer.parseInt(tree[i][2])][0]));
				} else if (tree[i][0].equals("-")) {
					tree[i][0] = Integer.toString(Integer.parseInt(tree[Integer.parseInt(tree[i][1])][0])
							- Integer.parseInt(tree[Integer.parseInt(tree[i][2])][0]));
				} else if (tree[i][0].equals("*")) {
					tree[i][0] = Integer.toString(Integer.parseInt(tree[Integer.parseInt(tree[i][1])][0])
							* Integer.parseInt(tree[Integer.parseInt(tree[i][2])][0]));
				} else if (tree[i][0].equals("/")) {
					tree[i][0] = Integer.toString(Integer.parseInt(tree[Integer.parseInt(tree[i][1])][0])
							/ Integer.parseInt(tree[Integer.parseInt(tree[i][2])][0]));
				}

			}
		}
	}

}