import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class shellGame {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("shell.out"));
        
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        int[] swap = {0,0,0};
        int res = 0; //result

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //subtracting one to fit array index's later
            arr[i][0] = Integer.parseInt(st.nextToken()) - 1;
            arr[i][1] = Integer.parseInt(st.nextToken()) - 1;
            arr[i][2] = Integer.parseInt(st.nextToken()) - 1;
        }
        int tempSwap = 0;
        int tempHold = 0;
        for (int i = 0; i < 3; i++) {
            swap[i] = 1;
            for (int j = 0; j < n; j++) {
               tempSwap = swap[arr[j][0]];
               swap[arr[j][0]] = swap[arr[j][1]];
               swap[arr[j][1]] = tempSwap;
               if (swap[arr[j][2]] == 1) {
                   tempHold++;
               }
            }
            res = (tempHold > res) ? tempHold : res;
            tempHold = 0;
            swap = new int[]{0,0,0};
        }
        pw.println(res);
        br.close();
        pw.close();
    }
}
