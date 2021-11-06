import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class bovineShuffle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("shuffle.out"));

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] temp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                temp[j] = arr2[arr1[j] - 1];
            }
            arr2 = temp;
            temp = new int[n];
        }

        String res = "";
        for (int i = 0; i < n; i++) {
            res += (i == n - 1) ? arr2[i] : arr2[i] + "\n";
        }

        pw.println(res);
        pw.close();
        br.close();
    }
}
