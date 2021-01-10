package LeetCode;

/**
 * 最多买卖两次，任一天结束有5种状态，未进行操作、进行了一次买操作、完成一次交易、第二次买操作、完成第二次交易
 * 未进行操作的利润为0，不用记录
 * buy1 表示进行一次买操作
 * sell1 表示完成了第一次交易
 * buy2 表示进行了第二次买操作
 * sell2 表示完成了两次交易
 *
 */

public class lt123 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) { //状态转移方程
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int[] prices1 = {1,2,3,4,5};
        int[] prices2 = {7,6,4,3,1};
        int[] prices3 = {1};
        int[] prices4 = {1,2,4,2,5,7,2,4,9,0};
        int i = maxProfit(prices4);
        System.out.println(i);
    }
}
