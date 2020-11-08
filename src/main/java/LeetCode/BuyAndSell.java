package LeetCode;

public class BuyAndSell {

    public static void main(String[] args) {
        BuyAndSell bs = new BuyAndSell();
        int res = bs.maxProfit(new int[]{1,2,3,0,2});
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {

        int profit = 0;
        boolean isSold = false;
        int soldAt = 0;

        for(int i =0; i< prices.length;i++){
            int cur = prices[i];
            int j =i+1;
            if(soldAt == i && isSold)
                continue;


            if(!isSold && j<prices.length && cur < prices[j]){
                profit= profit + (prices[j] - cur);
                soldAt = j;
                isSold = true;
            }
            else if(isSold || (j<prices.length && cur > prices[j])){
                isSold = false;
                continue;
            }
        }
        return profit;

    }
}
