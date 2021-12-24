import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class diamondCollector {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("diamond.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int res = 0;
        int temp = 0;
        int temp2 = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int val = 0; val < n; val++) {
        for (int i = val + 1; i < n; i++) {
            if (arr[i] - arr[val] <= k) {
                temp++;
            }
        }
        for (int j = val - 1; j >= 0; j--) {
            if (arr[val] - arr[j] <= k) {
                temp2++;
            }
        }
        if (Math.max(temp, temp2) > res) {
            res = temp;
        }
        temp = 0;
        temp2 = 0;
    }

        pw.println(res + 1);
        br.close();
        pw.close();
    }
}
