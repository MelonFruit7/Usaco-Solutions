import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class revegetate {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("revegetate.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String res = "";
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][2];
        int[] values = new int[n];
        int[] checks = new int[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
          for (int k = 0; k < m; k++) {
            for (int j = 0; j < 2; j++) {
                if (arr[k][j] == i + 1) {
                   if (j == 0) {
                        if (values[arr[k][j + 1] - 1] != 0) {
                            checks[values[arr[k][j + 1] - 1] - 1] = values[arr[k][j + 1] - 1];
                        }
                    } else {
                        if (values[arr[k][j - 1] - 1] != 0) {
                            checks[values[arr[k][j - 1] - 1] - 1] = values[arr[k][j - 1] - 1];
                        }
                    }
                }
            }
          }
          for (int j = 0; j < checks.length; j++) {
            if (checks[j] == 0) {
                values[i] = j + 1;
                break;
            }
          }
          checks = new int[n];
        }

        for (int i = 0; i < values.length; i++) {
            res += values[i];
        }
        pw.println(res);
        pw.close();
        br.close();
    } 
}