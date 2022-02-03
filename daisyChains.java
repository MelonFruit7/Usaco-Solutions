import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class daisyChains {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] checking = new int[1001];
        Arrays.fill(checking, -1);
        for (int i = 0; i < n; i++) {
            for (int j = n; i < j; j--) {
                double avg = 0;
                for (int k = i; k < j; k++) {
                    avg += arr[k];
                    checking[arr[k]] = 1;
                }
                avg /= (j - i);
              if (avg - Math.floor(avg) == 0) {
                if (checking[(int)avg] == 1) {
                    res++;
                }
              }
                Arrays.fill(checking, -1);
            }
        }
        System.out.println(res);
    }
}
