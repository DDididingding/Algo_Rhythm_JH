class Solution {
    public int solution(String s) {
        String[] str = s.split(" ");
        int len = str.length;
        int sum = 0;
        
        for(int i = 0 ; i< len; i++){
            if(str[i].equals("Z")){
                sum -= Integer.parseInt(str[i-1]);
            }else{
                sum += Integer.parseInt(str[i]);
            }
        }
        
        
        int answer = sum;
        return answer;
    }
}