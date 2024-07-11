import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[] parent;
    static boolean[] truth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        truth = new boolean[N+1];
        parent = new int[N+1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        str = br.readLine().split(" ");
        int numOfTruth = Integer.parseInt(str[0]);

        for(int i = 1; i<=numOfTruth; i++){
            int now = Integer.parseInt(str[i]);
            truth[now] = true;
        }

        List<List<Integer>> parties = new ArrayList<>();

       for(int i = 0; i < M; i++){
           str = br.readLine().split(" ");
           int partySize = Integer.parseInt(str[0]);
           List<Integer> party = new ArrayList<>();
           for(int j = 1; j<= partySize; j++){
               party.add(Integer.parseInt(str[j]));
           }

           parties.add(party);

           for (int j = 1; j < party.size(); j++) { //한 파티에 있는 사람들을 같은 집합으로 묶음
               union(party.get(0), party.get(j));
           }
       }

       int trueRoot = -1;
       for(int i = 1; i <= N; i++){
           if(truth[i]){
               if(trueRoot == -1){
                   trueRoot = find(i);
               }else{
                   union(trueRoot, i);
               }
           }
       }

        for (int i = 1; i <= N; i++) {
            if (truth[i]) {
                truth[find(i)] = true;
            }
        }

        int count = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (truth[find(person)]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                count++;
            }
        }

        System.out.println(count);

    }

    public static int find(int x){
        if(parent[x] == x){
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    public static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            parent[rootY] = rootX;
        }
    }


}