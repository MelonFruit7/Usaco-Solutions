import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class milkFactory {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("factory.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("factory.out"));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n - 1][2];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][1] == arr[j][0]) {
                    break;
                }
                if (j + 1 == n - 1 && arr[i][1] != arr[j][0] && arr[i][1] != res) {
                    res = arr[i][1];
                    count++;
                } 
            }
        }
        pw.println((count > 1) ? -1 : res);
        pw.close();
        br.close();
    }
}
