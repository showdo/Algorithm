package Graph;

import java.util.Arrays;

public class Dijkstra_Matrix {
    static final int INF = Integer.MAX_VALUE;

    public static int Dijkstra_dist(int[][] map,int s){
        int n = map.length;
        int[] dist = new int[n];
        Arrays.fill(dist,INF);
        boolean[] vis = new boolean[n];
        dist[s] = 0;
        for(int i=0;i<n;i++){
            int u = -1,MIN=INF;
            for(int j=0;j<n;j++){
                if(vis[j]==false && dist[j] < MIN){
                    u = j;
                    MIN = dist[j];
                }
            }
            if(u==-1) return -1;
            vis[u] = true;
            for(int v=0;v<n;v++){
                if(vis[v] == false && map[u][v] != INF && dist[u] + map[u][v] < dist[v]){
                    dist[v] = dist[u] + map[u][v];
                }
            }
        }
        int ans = 0;
        for(int d : dist){
            ans+=d;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] map = {{0,10,INF,30,100},
                {INF,0,50,INF,INF},
                {INF,INF,0,INF,10},
                {INF,INF,20,0,60},
                {INF,INF,INF,INF,0}};
        int s = 0;
        int i = Dijkstra_dist(map,s);
        System.out.println(i);
    }
}
