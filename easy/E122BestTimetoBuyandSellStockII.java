package easy;

public class E122BestTimetoBuyandSellStockII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		E122BestTimetoBuyandSellStockII e = new E122BestTimetoBuyandSellStockII();
		
		int[] prices = {7,1,5,3,6,4};
		
		System.out.println(e.maxProfit(prices));
	}

	//时间复杂度：O(n)，空间复杂度：O(1)
	public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0; i< prices.length-1; i++) {
        	if( prices[i+1] > prices[i]) 
        		max += prices[i+1] - prices[i];
        }
        
        return max;
    }
	
	//时间复杂度：O(n)，空间复杂度：O(1)
	public int maxProfit2(int[] prices) {
		if(prices == null || prices.length == 0) return 0;
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
}
