import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MilkPails {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new FileReader("pails.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("pails.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int greatest = 0;
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int xtoM = 0;
        int temp = 0;
        while(temp + x < m) {
            temp += x;
            xtoM++;
        }
        temp = 0;

        int[] sum = new int[xtoM];
        for (int i = 0; i < xtoM; i++) {
            sum[i] = x;
        }

        for(int i = 0; i < xtoM + 1; i++) {
            for (int j = 0; j < xtoM; j++) {
                if (temp + x > m) {
                    break;
                }
                temp += sum[j];
            }
            if (temp > greatest && temp <= m) {
                greatest = temp;
            }
            if (i != xtoM) {
                sum[i] = y;
                temp = 0;
            }
        }

        pw.println(greatest);
        pw.close();
        br.close();


    }
}
