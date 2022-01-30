import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BlockGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter pw = new PrintWriter(new PrintWriter("blocks.out"));

        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][2];
        int[] check = new int[26];
        int[] check2 = new int[26];
        int[] res = new int[26];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            for (int j = 0; j < arr[i][0].length(); j++) {
                check[(arr[i][0].charAt(j) - 97)] += 1;
            }
            arr[i][1] = st.nextToken();
            for (int j = 0; j < arr[i][1].length(); j++) {
                check2[(arr[i][1].charAt(j) - 97)] += 1;
            }
            for (int j = 0; j < 26; j++) {
                res[j] += Math.max(check[j],check2[j]);
            }
            check = new int[26];
            check2 = new int[26];
        }
        for (int i : res) {
            pw.println(i);
        }
        pw.close();
        br.close();
    }
}
