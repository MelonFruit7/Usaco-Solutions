import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class tamingHerd {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("taming.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("taming.out"));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int min = 1;
        int max = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[0] = 0;

        for (int i = n - 1; i > 0; i--) {
            if (arr[i] == 0) {
                min++;
                max++;
            } else if (arr[i] == -1) {
                max++;
            } else {
                if (arr[i - 1] == -1) {
                    arr[i - 1] = arr[i] - 1;
                } else if (arr[i] - 1 != arr[i - 1]) {
                    pw.println("-1");
                    br.close();
                    pw.close();
                }
            }
        }

        pw.println(min+" "+max);
        br.close();
        pw.close();
    }
}
