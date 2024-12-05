package DFS_Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS {
	static int V, E; // 정점의 갯수, 간선의 갯수
	static int[][] adj; // 인접행렬
	static boolean[] visited; // 방문체크

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		// 1번부터 V번까지의 정점을 표현하기 위해 V+1 크기로 배열 생성
		adj = new int[V + 1][V + 1];
		visited = new boolean[V + 1];

		// 간선 정보 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			// 무방향(양방향) 그래프이므로 양쪽 모두 연결 표시
			adj[A][B] = adj[B][A] = 1;
		}

		// 1번 정점부터 DFS 탐색 시작
		dfs(1);

	}

	// v : 현재 내가 있는 정점
	static void dfs(int v) {
		// 현재 정점 방문처리
		visited[v] = true;

		// 나와 인접하면서 방문하지 않은 정점을 방문
		for (int i = 1; i <= V; i++) {
			if (visited[i])
				continue;
			if (adj[v][i] == 1) {
				dfs(i);
			}
		}
	}
}
