import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class lostcow {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("lostcow.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        boolean xgreater = false;
        int walk = 1;
        int distance = 0;
        int res = 1;

        if (x > y) {
        xgreater = true;
        }

        while(x != y) {
            if (xgreater) { 
             if (x + walk <= y) {
                res -= Math.abs((x + walk) - y);
                x = y;
                break;
             }
             distance = x + walk;
             walk *= -2;
             res = res + Math.abs(distance - (x + walk));

            } else {
                if (x + walk >= y) {
                 res -= Math.abs((x + walk) - y);
                 x = y;
                 break;
                }
             distance = x + walk;
             walk *= -2;
             res = res + Math.abs(distance - (x + walk));
            }
        }


        pw.println(res);
        pw.close();
        br.close();

    }
}
