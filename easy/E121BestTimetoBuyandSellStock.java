package easy;

public class E121BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		E121BestTimetoBuyandSellStock e = new E121BestTimetoBuyandSellStock();
		
		int[] prices = {7,1,5,3,6,4};
		
		System.out.println(e.maxProfit(prices));
	}
	
	//时间复杂度：O(n^2)，空间复杂度：O(1)
	public int maxProfit(int[] prices) {
        int max = 0;
		for(int i = 0; i< prices.length; i++)
		{
			for(int j = i+1; j<prices.length; j++)
			{
					if(prices[j] - prices[i] > max)
						max = prices[j] - prices[i];
			
			}
		}
		return max;
    }

	//时间复杂度：O(n)，空间复杂度：O(1)
	public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int gain = 0;
        for(int price:prices){
            min = Math.min(min,price);
            gain = Math.max(gain,price-min);
        }
        return gain;
    }
	
	//Kadane's Algorithm,用于解决最大子序列的和
	//时间复杂度：O(n)，空间复杂度：O(1)
	public int maxProfit3(int[] prices) {
        int max = 0;
        int cur = 0;
        for(int i =  1; i < prices.length; i++) {
            cur = Math.max(0, cur += prices[i] - prices[i-1]);
            max = Math.max(cur, max);
        }
        return max;
    }
	
}
