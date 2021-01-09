package StringY.LeetCode;


/**
 * 解题思路
 * 1.使用数组res统计字符串T中字符出现的次数。
 * 2.遍历字符串S中的字符c，如果字符串T中含有c，则根据规则将c放置到前面。
 * 3.遍历res，如果有未出现在S中的字符，则添加到ans的后面。
 */

public class lt791 {
    public static String customSortString(String S, String T) {
        int[] res = new int[26];
        for(int i=0;i<T.length();i++){
            char c = T.charAt(i);
            res[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            while (res[c-'a'] > 0){
                ans.append(c);
                res[c-'a']--;
            }
        }
        for(int i=0;i<26;i++){
            while (res[i] > 0){
                ans.append((char)(i+'a'));
                res[i]--;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String S = "cba";
        String T = "abcd";
        String string = customSortString(S, T);
        System.out.println(string);
    }
}
