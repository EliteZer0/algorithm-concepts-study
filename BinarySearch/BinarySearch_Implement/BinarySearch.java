package BinarySearch_Implement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("배열의 크기를 입력하세요 : ");
		int n = Integer.parseInt(br.readLine());

		int[] data = new int[n];
		System.out.println("배열의 요소를 입력하세요 : ");
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println("찾으려는 값을 입력하세요 : ");
		int answer = Integer.parseInt(br.readLine());

		Arrays.sort(data);

		int left = 0;
		int right = n - 1;
		boolean exist = false;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (data[mid] == answer) {
				exist = true;
				break;
			} else if (data[mid] < answer) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(exist);

	}
}
