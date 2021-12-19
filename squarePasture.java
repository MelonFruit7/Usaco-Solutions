import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class squarePasture {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("square.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("square.out"));

        int[][] arr = new int[2][4];

        for (int i = 0; i < 2; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[i][0] = Integer.parseInt(st.nextToken());
        arr[i][1] = Integer.parseInt(st.nextToken());
        arr[i][2] = Integer.parseInt(st.nextToken());
        arr[i][3] = Integer.parseInt(st.nextToken());
        }

        //0 is x, 1 is y, 2 is x2, 3 is y2
        int x = Math.max(arr[0][2], arr[1][2]) - Math.min(arr[0][0], arr[1][0]);
        int y = Math.max(arr[0][3], arr[1][3]) - Math.min(arr[0][1], arr[1][1]);

        pw.println((int)Math.pow(Math.max(x, y), 2));
        pw.close();
        br.close();
    }
}
