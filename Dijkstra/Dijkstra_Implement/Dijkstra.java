package Dijkstra_Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra{
    static class Node implements Comparable<Node> {
        int v, w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
    }
    
    static int V, E;
    static List<Node>[] adjList;
    static int[] dis;
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[V+1];
		
		for (int i = 1; i < V+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		dis = new int[V+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[a].add(new Node(b, w));
			// 양방향일때
			// adjList[b].add(new Node(a, w));
		}
		
		dijkstra(1);
		
		if(dis[V] == Integer.MAX_VALUE) {
		    System.out.println("경로 없음");
		} else {
		    System.out.println("1번에서 " + V + "번까지의 최단거리: " + dis[V]);
		}
    }

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		
		dis[start] = 0;
		
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.v]) continue;
			visited[cur.v] = true;
			
			for (Node node : adjList[cur.v]) {
				if(visited[node.v]) continue;
				if(dis[node.v]>dis[cur.v]+node.w) {
					dis[node.v] = dis[cur.v] + node.w;
					pq.add(new Node(node.v, dis[node.v]));
				}
			}
		}
	}
}