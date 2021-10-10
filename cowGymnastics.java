import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class cowGymnastics {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("gymnastics.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] values = new int[k][n];

        int total = 0;
        boolean check = false;
        String store = "";
        int count = 0;
        String[] arr;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                values[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //This scares me
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < n; l++) {
                    store += values[j][l] + " ";
                    if (values[j][l] == i) {
                        break;
                    }
                }
            }
                arr = store.split(" ");
                for (int l = 0; l < arr.length; l++) {
                    for (int m = l; m < arr.length; m++) {
                        if (arr[l].equals(arr[m]) && l != m) {
                            check = true;
                        } 
                        if (m + 1 == arr.length && check == false) {
                            ++count;
                        }
                    }
                    check = false;
                }
                total += (n - count);
                store = "";
                count = 0;
        }

        pw.println(total);
        pw.close();
        br.close();
    }
}
