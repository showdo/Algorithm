package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 *双指针问题，找到一个递增为1的区间[i,j]。
 * 如果i != j，list.add(nums[i] + "->" + nums[j-1]);
 * 如果i == j，list.add(nums[i] + "");
 * 最后更新i = j。
 */

public class lt228 {
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;){
            int j = i+1;
            while (j < n && nums[j] == nums[j-1] + 1){
                j++;
            }
            StringBuilder temp = new StringBuilder(Integer.toString(nums[i]));
            if(i < j - 1){
                temp.append("->");
                temp.append(nums[j - 1]);
            }
            i = j;
            list.add(temp.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1};
        List<String> list = summaryRanges(nums);
        System.out.println(list);
    }
}
