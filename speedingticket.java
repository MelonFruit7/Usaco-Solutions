import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class speedingticket {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("speeding.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean check = true;
        int res = 0;
        int sl = 0;
        int s = 0;
        int[][] speedlimit = new int[n][2];
        int[][] speed = new int[m][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            speedlimit[i][0] = Integer.parseInt(st.nextToken());
            speedlimit[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            speed[i][0] = Integer.parseInt(st.nextToken());
            speed[i][1] = Integer.parseInt(st.nextToken());
        }

        while(check) {
            if (speedlimit[sl][0] - speed[s][0] == 0) {
                if (speedlimit[sl][1] - speed[s][1] < 0) {
                    if (speedlimit[sl][1] - speed[s][1] < res) {
                        res = speedlimit[sl][1] - speed[s][1];
                    }
                }
                sl++;
                s++;
                if (sl == n || s == m) {
                    check = false;
                    break;
                }
            } else if (speedlimit[sl][0] - speed[s][0] > 0) {
                if (speedlimit[sl][1] - speed[s][1] < 0) {
                    if (speedlimit[sl][1] - speed[s][1] < res) {
                        res = speedlimit[sl][1] - speed[s][1];
                    }
                }
                speedlimit[sl][0] = speedlimit[sl][0] - speed[s][0];
                s++;
                if (sl == n || s == m) {
                    check = false;
                    break;
                }
            } else {
                if (speedlimit[sl][1] - speed[s][1] < 0) {
                    if (speedlimit[sl][1] - speed[s][1] < res) {
                        res = speedlimit[sl][1] - speed[s][1];
                    }
                }
                speed[s][0] = Math.abs(speedlimit[sl][0] - speed[s][0]);
                sl++; 
                if (sl == n || s == m) {
                    check = false;
                    break;
                }
            }
        }

        pw.println(Math.abs(res));
        pw.close();
        br.close();

    }
}
