import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class madScientist {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("breedflip.out"));

        int n = Integer.parseInt(br.readLine()), temp = 0, res = 0;
        char[][] arr = new char[2][n];
        for (int i = 0; i < 2; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            if (arr[0][i] != arr[1][i]) {
                temp = 1;
            } else {
                res += temp;
                temp = 0;
            }
        }

        pw.println(res);
        pw.close();
        br.close();
    }
}
