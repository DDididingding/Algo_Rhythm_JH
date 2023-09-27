class Solution {
    public int solution(int price) {
        double Price = price;
        if(price>= 500000){
            Price = Price*0.8;
        }else if(price>=300000){
            Price = Price*0.9;
        }else if(price >= 100000){
            Price = Price*0.95;
        }
        
        int answer = (int) Price;
        return answer;
    }
}