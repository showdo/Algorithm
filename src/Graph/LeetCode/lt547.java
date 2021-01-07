package Graph.LeetCode;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.LinkedList;
import java.util.Queue;

public class lt547 {
    //深度优先搜索
    public int findCircleNum_dfs(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int ans = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                ans++;
                dfs(isConnected,vis,i);
            }
        }
        return ans;
    }
    public void dfs(int[][] map,boolean[] vis,int i){
        vis[i] = true;
        for(int k=0;k<map.length;k++){
            if(map[i][k] == 1 && !vis[k]){
                dfs(map,vis,k);
            }
        }
    }

    //广度优先搜索
    public int findCircleNum_bfs(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(!vis[i]){
                queue.offer(i);
                while (!queue.isEmpty()){
                    int k = queue.poll();
                    vis[k] = true;
                    for(int j=0;j<n;j++){
                        if(isConnected[k][j] == 1 && !vis[j]){
                            queue.offer(j);
                        }
                    }
                }
                ans++;
            }
        }
        return ans;
    }

    // 并查集
    //TODO
    
}
