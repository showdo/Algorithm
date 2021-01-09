package ArraysT.LeetCode;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class lt1029 {
    public static int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });
        int ans = 0;
        int n = costs.length / 2;
        for(int i=0;i<n;i++){
            ans += costs[i][0] + costs[i+n][1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] costs = {{10,20},{30,200},{400,50},{50,200}};
        int i = twoCitySchedCost(costs);
        System.out.println(i);
    }

    /**
     * 不太美观的代码，我太菜了。 *_*
     * @param costs
     * @return
     */

    public int twoCitySchedCost_(int[][] costs) {
        int n = costs.length;
        PriorityQueue<Pair<Integer,Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for(int i=0;i<n;i++){
            int tmp = Math.abs(costs[i][1] - costs[i][0]);
            priorityQueue.add(new Pair<>(i,tmp));
        }
        int ans = 0;
        int toA = 0;
        int toB = 0;
        boolean flagA = false;
        boolean flagB =false;
        for(int i=0;i<n;i++){
            Pair<Integer,Integer> tmp = priorityQueue.remove();
            int k = tmp.getKey();
            if(costs[k][0] > costs[k][1]){
                toB++;
                ans+=costs[k][1];
                if(toB == n / 2){
                    flagA = true;
                    break;
                }
            } else if(costs[k][0] < costs[k][1]){
                toA++;
                ans+=costs[k][0];
                if(toA == n / 2){
                    flagB = true;
                    break;
                }
            } else {
                if(toA > toB){
                    toB++;
                } else{
                    toA++;
                }
                ans+=costs[k][1];
            }
        }
        while (!priorityQueue.isEmpty()){
            Pair<Integer,Integer> tmp = priorityQueue.remove();
            int k = tmp.getKey();
            if(flagA){
                ans += costs[k][0];
            }
            if(flagB){
                ans += costs[k][1];
            }
        }
        return ans;
    }
}
