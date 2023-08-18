import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int[][] sudoku = new int[9][9];
            boolean good = true;

            for (int i = 0; i < 9; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(str[j]);
                }
            }

            // Check rows and columns
            for (int i = 0; i < 9; i++) {
                boolean[] rowCheck = new boolean[10];
                boolean[] colCheck = new boolean[10];
                for (int j = 0; j < 9; j++) {
                    if (rowCheck[sudoku[i][j]] || colCheck[sudoku[j][i]]) {
                        good = false;
                        break;
                    }
                    rowCheck[sudoku[i][j]] = true;
                    colCheck[sudoku[j][i]] = true;
                }
                if (!good) {
                    break;
                }
            }

            // Check subgrids
            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    boolean[] subgridCheck = new boolean[10];
                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                            if (subgridCheck[sudoku[x][y]]) {
                                good = false;
                                break;
                            }
                            subgridCheck[sudoku[x][y]] = true;
                        }
                        if (!good) {
                            break;
                        }
                    }
                }
                if (!good) {
                    break;
                }
            }

            if (good) {
                System.out.println("#" + t + " " + 1);
            } else {
                System.out.println("#" + t + " " + 0);
            }
        }
    }
}