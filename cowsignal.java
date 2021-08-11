import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class cowsignal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cowsignal.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String res = "";
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int temp1 = 0;
        String temp2 = "";

        char[][] signal = new char[m][n*k];

        for (int i = 0; i < m; i++) {
            char[] get = br.readLine().toCharArray();
            for (int j = 0; j < n * k; j++) {
            signal[i][j] = get[temp1];
            temp1++;
            j += k - 1;
            }
            temp1 = 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n * k; j += k) {
                for (int l = 1; l < k; l++) {
                    signal[i][j + l] = signal[i][j];
                }
            }
        }

        for (int i = 0; i < signal.length; i++) {
            for (int j = 0; j < signal[0].length; j++) {
                res += signal[i][j];
                temp2 += signal[i][j];
            }
            for (int j = 1; j < k; j++) {
            res += "\n" + temp2;
            }
            temp2 = "";
            if (i + 1 == signal.length) {
                break;
            }
            res += "\n";
        }

        pw.println(res);
        pw.close();
        br.close();

    }
}
