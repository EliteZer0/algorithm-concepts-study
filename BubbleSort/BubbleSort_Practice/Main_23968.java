package BubbleSort_Practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_23968 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] data = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int swapCount = 0;
        boolean canPrint = false;

        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swapCount++;
                }
                if (swapCount == k) {
                    System.out.printf("%d %d", data[j], data[j + 1]);
                    canPrint = true;
                    return;
                }
            }
        }

        if (!canPrint) {
            System.out.println(-1);
        }

    }
}
