import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class cowcrossroad3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cowqueue.out"));

        int temp1 = 0;
        int temp2 = 0;
        int res = 0;
        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (time[i][0] > time[j][0]) {
                    temp1 = time[j][0];
                    temp2 = time[j][1];
                    time[j][0] = time[i][0];
                    time[j][1] = time[i][1];
                    time[i][0] = temp1;
                    time[i][1] = temp2;
                }
            }
        }

        for (int i = 0; i < 1; i++) {
            res = time[i][0] + time[i][1];
            for (int j = 1; j < n; j++) {
                if (res > time[j][0]) {
                    res += time[j][1];
                } else {
                    res = time[j][0] + time[j][1];
                }
            }
        }

        pw.println(res);
        pw.close();
        br.close();

    }
}
