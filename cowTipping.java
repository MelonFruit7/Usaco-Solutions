import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class cowTipping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cowtip.out"));

        int n = Integer.parseInt(br.readLine()),res = 0;
        int[] columns = new int[n];
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
             if (columns[j] % 2 == 0) {
                if (arr[i][j] == '1') {
                    for (int k = j; k >= 0; k--) {
                        columns[k]++;
                    }
                    res++;
                }
             } else {
                if (arr[i][j] == '0') {
                    for (int k = j; k >= 0; k--) {
                        columns[k]++;
                    }
                    res++;
                } 
             }
            }
        }
        pw.println(res);
        pw.close();
        br.close();
    }
}
