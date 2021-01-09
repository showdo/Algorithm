package ArraysT.LeetCode;

/**
 * 前缀和
 */
public class lt1588 {
    public static int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int ans = arr[0];
        res[0] = arr[0];
        for(int i=1;i<n;i++){
            res[i] = res[i-1] +  arr[i];
            ans += arr[i];
        }
        //对长度为3、5、7...n（若为奇数）| n-1的子数组求和。
        for(int i=2;i<n;i+=2){
            int k = 0;
            ans += res[i];
            for(int j=i+1;j<n;j++){
                ans += res[j] - res[k++];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int i = sumOddLengthSubarrays(arr);
        System.out.println(i);
    }
}
