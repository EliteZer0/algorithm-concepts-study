package Prim_Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prim_Loop {
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); // 정점 수
		int E = Integer.parseInt(st.nextToken()); // 간선 수

		// 인접 행렬 생성
		int[][] adjMatrix = new int[V][V];

		// 간선 정보 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			// 무방향 그래프
			adjMatrix[start][end] = adjMatrix[end][start] = weight;
		}

		System.out.println(prim(V, adjMatrix));
	}

	private static int prim(int V, int[][] adjMatrix) {
		boolean[] visited = new boolean[V];
		int[] parent = new int[V];
		int[] minWeight = new int[V];

		// 초기화
		for (int i = 0; i < V; i++) {
			parent[i] = -1;
			minWeight[i] = INF;
		}

		// 시작 정점 설정
		minWeight[0] = 0;
		int totalWeight = 0;

		// MST 구성
		for (int i = 0; i < V; i++) {
			int min = INF;
			int minVertex = -1;

			// 최소 가중치를 가진 정점 찾기
			for (int j = 0; j < V; j++) {
				if (!visited[j] && minWeight[j] < min) {
					min = minWeight[j];
					minVertex = j;
				}
			}

			visited[minVertex] = true;
			totalWeight += minWeight[minVertex];

			// 인접한 정점들의 가중치 갱신
			for (int j = 0; j < V; j++) {
				if (!visited[j] && adjMatrix[minVertex][j] != 0
						&& minWeight[j] > adjMatrix[minVertex][j]) {
					minWeight[j] = adjMatrix[minVertex][j];
					parent[j] = minVertex;
				}
			}
		}

		return totalWeight;
	}
}