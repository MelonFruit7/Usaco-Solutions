import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class sleepyherd {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("herding.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("herding.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = 0;
        int max = 0;

        int pos1 = Integer.parseInt(st.nextToken());
        int pos2 = Integer.parseInt(st.nextToken());
        int pos3 = Integer.parseInt(st.nextToken());

            if (pos3 - pos2 > pos2 - pos1) {
                max = pos3 - pos2 - 1;
                if (pos2 - pos1 == 2) {
                    min = 1;
                } else if (pos2 - pos1 > 2 || pos2 - pos1 == 1) {
                    min = 2;
                }
            } else if (pos3 - pos2 < pos2 - pos1) {
                max = pos2 - pos1 - 1;
                if (pos3 - pos2 == 2) {
                    min = 1;
                } else if (pos3 - pos2 > 2 || pos3 - pos2 == 1) {
                    min = 2;
                }
            } else {
                max = pos3 - pos2 - 1;
                if (pos2 - pos1 == 2) {
                    min = 1;
                } else if (pos2 - pos1 > 2) {
                    min = 2;
                }
            }

        pw.println(min);
        pw.println(max);
        pw.close();
        br.close();
    }
}
