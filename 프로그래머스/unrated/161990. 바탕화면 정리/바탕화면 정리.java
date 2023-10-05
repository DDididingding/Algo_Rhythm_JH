class Solution {
    public int[] solution(String[] wallpaper) {
        int luy = 100;
        int lux = 100;
        int rdy = -1;
        int rdx = -1;
        for(int i = 0 ; i<wallpaper.length; i++){
            for(int j = 0 ; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if(luy>i) luy = i;
                    if(lux>j) lux = j;
                    if(rdy<i) rdy = i;
                    if(rdx<j) rdx = j;
                }
            }
        }
        
        rdy++;
        rdx++;
        
        int[] answer = {luy,lux,rdy,rdx};
        return answer;
    }
}