class Solution {
    public int solution(String[] spell, String[] dic) {
        
        for(int i = 0 ; i<spell.length; i++){
            for(int j = 0; j< dic.length; j++){
                if(!dic[j].contains(spell[i])){
                    dic[j] = "";
                }
            }
        }
        
        int answer = 2;
        
        for(int i = 0; i<dic.length; i++){
            if(dic[i].length() == spell.length) answer = 1;
        }
        
        
        return answer;
    }
}