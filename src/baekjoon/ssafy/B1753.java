package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1753 {

    static class Node implements Comparable<Node>{
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    private static final int INF = Integer.MAX_VALUE;
    static int V, E, K;
    static List<Node>[] adjList;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        adjList = new ArrayList[V+1];
        distance = new int[V+1];
        Arrays.fill(distance, INF);

        for (int i = 1; i <= V; ++i) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; ++i) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[start].add(new Node(end, weight));
        } // 입력 완료

        StringBuilder sb = new StringBuilder();

        diskstra(K);
        for (int i = 1; i <= V; ++i) {
            if (distance[i] == INF) sb.append("INF\n");
            else sb.append(distance[i] + "\n");
        }

        System.out.println(sb);
    }

    private static void diskstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];

        distance[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            int currTo = currNode.end;

            if (visited[currTo]) continue;
            visited[currTo] = true;

            for (Node node : adjList[currTo]) {
                if (distance[node.end] > distance[currTo] + node.weight) {
                    distance[node.end] = distance[currTo] + node.weight;
                    queue.add(new Node(node.end, distance[node.end]));
                }
            }
        }
    }
}