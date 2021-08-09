import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class ABCs {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] values = new int[7];
        int A = 0, B = 0, C = 0;
        int ABC;
        int BC;

        for (int i = 0; i < 7; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(values);
        A = values[0];
        ABC = values[6];
        BC = ABC - A;

        for (int i = 1; i < 5; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (values[i] + values[j] == BC) {
                    B = values[i];
                    C = values[j];
                    break;
                } 
            }
        }

        System.out.println(A + " " + B + " " + C);
    }
}
