package Kruskal.Kruskal_Practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1197 {
	static int V,E;
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int weight;
		
		public Edge(int s, int e, int weight) {
			this.s = s;
			this.e = e;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge eg) {
			return Integer.compare(weight, eg.weight);
		}
	}
	static PriorityQueue<Edge> pre;
	static int min;
	static int[] p;
	static int[] r;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V= Integer.parseInt(st.nextToken());
		E= Integer.parseInt(st.nextToken());
		pre = new PriorityQueue<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pre.offer(new Edge(s, e, w));
		}
		//1. makeset
		makeset();
		//2. 
		int cnt = 0;
		min = 0;
		while(cnt != V-1) {
			Edge edge = pre.poll();
			if(union(edge.s, edge.e)) {
				cnt++;
				min += edge.weight;
			}
		}
		System.out.println(min);
	}
	//3. union
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) return false;
		if(r[x]<r[y]) {
			r[y] += r[x];
			p[x] = y;
		}else {
			r[x] += r[y];
			p[y] = x;
		}
		return true;
	}
	
	static int find(int x) {
		if(x==p[x]) return p[x];
		return p[x] = find(p[x]);
	}
	
	static void makeset() {
		p = new int[V+1];
		r = new int[V+1];
		for (int i = 1; i < V+1; i++) {
			p[i] = i;
			r[i] = 1;
		}
	}
}
