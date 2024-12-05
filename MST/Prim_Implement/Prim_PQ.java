package Prim_Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prim_PQ {
    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점 수
        int E = Integer.parseInt(st.nextToken()); // 간선 수

        // 인접 리스트 초기화
        List<Edge>[] adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 무방향 그래프
            adjList[start].add(new Edge(start, end, weight));
            adjList[end].add(new Edge(end, start, weight));
        }

        System.out.println(prim(V, adjList));
    }

    private static int prim(int V, List<Edge>[] adjList) {
        boolean[] visited = new boolean[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int totalWeight = 0;
        int count = 1;

        // 시작 정점(0) 처리
        visited[0] = true;
        pq.addAll(adjList[0]);

        // MST 구성
        while (!pq.isEmpty() && count < V) {
            Edge current = pq.poll();

            if (visited[current.end])
                continue;

            visited[current.end] = true;
            totalWeight += current.weight;
            count++;

            pq.addAll(adjList[current.end]);
        }

        return totalWeight;
    }
}