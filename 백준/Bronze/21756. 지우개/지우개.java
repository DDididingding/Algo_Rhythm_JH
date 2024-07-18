import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            nums.add(i);
        }

        while(nums.size()>1){
            int end = nums.size()-1;
            if(end%2 == 0){
                for(int i = end; i>=0; i-=2){
                    nums.remove(i);
                }
            }else{
                for(int i = end-1; i>=0; i-=2){
                    nums.remove(i);
                }
            }
        }

        System.out.println(nums.get(0));
    }
}