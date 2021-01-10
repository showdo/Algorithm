package LeetCode;

import java.util.Arrays;

/**
 * 旋转数组，对数组{1,2,3,4,5,6,7}，k=3
 * 先翻转{1,2,3,4}变为{4,3,2,1}
 * 再翻转{5,6,7}变为{7,6,5}
 * 最后整个数组翻转即可得到答案{5,6,7,1,2,3,4}
 * 算法时间复杂度O(n),原地操作，所以空间复杂度O(1)
 */

public class lt189 {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int move = k % n;
        if(move == 0) return;
        rotate_nums(nums,0,n-move-1);
        rotate_nums(nums,n-move,n-1);
        rotate_nums(nums,0,n-1);
    }

    public static void rotate_nums(int[] nums,int start,int end){
        while (start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int k = 2;
        rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }
}
