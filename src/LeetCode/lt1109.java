package LeetCode;

import java.util.Arrays;

/**
 * 对数组{{1,2,10},{2,3,20},{2,5,25}}
 * 第1站到第2站有10个人，则第3站会少10人，因为这10个人在第二站就下飞机了
 * 同理，第2站到第3站有20人，则第4站会少20人。
 * 每站的人数为前一站人数加上当前人数的变化。
 * 所以counters数组变化过程为
 * {10,0,-10,0,0}
 * {10,20,-10,-20,0}
 * {10,45,-10,-20,0}
 * {10,55,45,25,25}
 */

public class lt1109 {
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] counters = new int[n];
        for (int[] booking : bookings) {
            counters[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                counters[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; ++i) {
            counters[i] += counters[i - 1];
        }
        return counters;
    }

    public static void main(String[] args) {
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int n = 5;
        int[] ints = corpFlightBookings(bookings, n);
        System.out.println(Arrays.toString(ints));
    }
}
