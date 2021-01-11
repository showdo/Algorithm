package LeetCode;

import java.util.*;

/**
 * 并查集思想，互相连接的字符索引，可以按字典序排序。
 * 使用并查集，找到互相连接的字符索引位置，构成了几个集合。
 * 每个集合内的字符，可以任意交换位置，按字典序排序。
 * 使用优先级队列，可以使得出队的字符永远是最小的字符。
 */

public class lt1202 {
    static class UnionFind {
        private int[] parent;
        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind unionFind = new UnionFind(n);
        for (List<Integer> list : pairs) {
            int x = list.get(0);
            int y = list.get(1);
            unionFind.union(x, y);
        }
        char[] chars = s.toCharArray();

        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = unionFind.find(i);
            if (hashMap.containsKey(root)) {
                hashMap.get(root).offer(chars[i]);
            } else {
                PriorityQueue<Character> minHeap = new PriorityQueue<>();
                minHeap.offer(chars[i]);
                hashMap.put(root, minHeap);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int root = unionFind.find(i);
            sb.append(hashMap.get(root).poll());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "dcabe";
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> pair = Arrays.asList(0, 3);
        List<Integer> pair1 = Arrays.asList(1, 2);
        List<Integer> pair2 = Arrays.asList(4,0);
        pairs.add(pair);
        pairs.add(pair1);
        pairs.add(pair2);
        String string = smallestStringWithSwaps(s, pairs);
        System.out.println(string);
    }
}
