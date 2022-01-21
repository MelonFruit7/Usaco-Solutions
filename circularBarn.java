import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class circularBarn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cbarn.out"));

        int n = Integer.parseInt(br.readLine()), sum = 0, res = Integer.MAX_VALUE;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
           sum += (arr[i] = Integer.parseInt(br.readLine()));
        }
        int tempSum = sum, tempRes = 0; //;-;

        for (int i = 0; i < n; i++) {
            int leap = i;
            while(tempSum != 0) {
                if (leap >= n) {
                    leap = 0;
                }
                tempSum -= arr[leap++];
                tempRes += tempSum;
            }
            if (tempRes < res) {
                res = tempRes;
            }
            tempRes = 0;
            tempSum = sum;
        }
        pw.println(res);
        pw.close();
        br.close();
    }
} 