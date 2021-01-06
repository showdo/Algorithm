package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Dijkstra_list {
    static final int INF = Integer.MAX_VALUE;

    static class Graph{
        private int v; // v为顶点个数
        private LinkedList<Edge>[] adj; // 邻接表

        public Graph(int v){
            this.v = v;
            adj = new LinkedList[v];
            for(int i=0;i<v;++i){
                adj[i] = new LinkedList<>();
            }
        }

        /**
         *
         * @param u 起点
         * @param v 终点
         * @param dist 距离
         */

        public void addEdge(int u,int v,int dist){
            adj[u].add(new Edge(u,v,dist));
        }

        private class Edge{
            public int u;
            public int v;
            public int dist;

            public Edge(int u, int v, int dist) {
                this.u = u;
                this.v = v;
                this.dist = dist;
            }
        }

    }



    /**
     *
     * @param s 表示起点
     * @param G 邻接表
     * @return 从起点出发到所有顶点的距离最小和
     */
    public static int Dijkstra_dist(int s,Graph G){
        int ans = 0;
        int n = G.v;
        int[] dist = new int[n];
        Arrays.fill(dist,INF);
        boolean[] vis = new boolean[n];
        dist[s] = 0;
        for(int i=0;i<n;i++){
            int u=-1,MIN=INF;
            for(int j=0;j<n;j++){
                if(vis[j] == false && dist[j] < MIN){
                    u = j;
                    MIN = dist[j];
                }
            }
            if(u == -1)return -1;
            vis[u] = true;
            for(int j=0;j<G.adj[u].size();j++){
                int v = G.adj[u].get(j).v;
                if(vis[v] == false && dist[u] + G.adj[u].get(j).dist < dist[v]){
                    dist[v] = dist[u] + G.adj[u].get(j).dist;
                }
            }
        }

        for(int d : dist){
            ans+=d;
            System.out.println(d);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); //多少顶点
        Graph G = new Graph(n);
        int m = input.nextInt(); //多少条边
        for(int i=0;i<m;i++){
            int u = input.nextInt();
            int v = input.nextInt();
            int dist = input.nextInt();
            G.addEdge(u,v,dist);
        }
        int s = input.nextInt();
        int i = Dijkstra_dist(s, G);
        System.out.println(i);
    }
}
