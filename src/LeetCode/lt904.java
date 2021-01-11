package LeetCode;



public class lt904 {
    public static int totalFruit(int[] tree) {
        int n = tree.length;
        int ans = 0;
        int[] fruits = {-1,-1};
        fruits[0] = tree[0];
        for(int i=0;i<n;){
            int j = i+1;
            while (j < n){
                if(tree[j] != fruits[0] && fruits[1] == -1){
                    fruits[1] = tree[j];
                }
                if(tree[j] == fruits[0] || tree[j] == fruits[1]) {
                    j++;
                } else {
                    break;
                }
            }
            int temp = j - i;
            ans = Math.max(ans,temp);
            if(j < n){
                fruits[0] = tree[j-1];
                fruits[1] = tree[j];
                int k = j - 1;
                while (k > 0 && tree[k] == tree[k-1]){
                    k--;
                }
                i = k;
            } else{
                i = j;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] tree = {1,0,1,4,1,4,1,2,3};
        int i = totalFruit(tree);
        System.out.println(i);
    }
}
