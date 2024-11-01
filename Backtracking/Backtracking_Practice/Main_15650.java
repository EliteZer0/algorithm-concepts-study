package Backtracking_Practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650 {
	static int n;
	static int r;
	static int[] nums;
	static int[] choice;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		nums = new int[n];
		
		for (int i = 0; i < n; i++) {
			nums[i] = i+1;
		}
		
		choice = new int[r];
		combi(0, 0);
	}

	static void combi(int start, int idx) {
		StringBuilder sb = new StringBuilder();
		
		if(idx == r) {
			for (int i = 0; i < r; i++) {
				sb.append(choice[i]).append(" ");
			}
			System.out.println(sb.toString());
			return;
		}
		
		for (int i = start; i < n; i++) {
			choice[idx] = nums[i];
			combi(i+1, idx+1);
		}
	}
}