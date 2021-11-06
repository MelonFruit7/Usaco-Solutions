import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class bucketBrigade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("buckets.out"));

        int count = 0;
        int B1 = 0, B2 = 0, L1 = 0, L2 = 0;
        int updown = 0, leftright = 0;
        String[][] arr = new String[10][10];

        for (int i = 0; i < 10; i++) {
            arr[i] = br.readLine().split("");
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j].equals("B")) {
                    B1 = i;
                    B2 = j;
                } else if (arr[i][j].equals("L")) {
                    L1 = i;
                    L2 = j;
                }
            }
        }
        int updownAway = L1 - B1;
        int leftrightAway = L2 - B2;

        int temp = B1;
        //in this case up is negative and down is positive
        if (updownAway > 0) {
            updown = 1;
        } else {
            updown = -1;
        }
        if (leftrightAway > 0) {
            leftright = 1;
        } else {
            leftright = -1;
        }

        while (updownAway != 0) {
            count += updown;
            if (arr[B1 + count][B2].equals("R")) {
                pw.println(Math.abs(L2 - B2) + Math.abs(L1 - B1) + 1);
                br.close();
                pw.close();
                return;
            }
            updownAway -= updown;
            if (updownAway == 0) {
                temp = B1 + count;
            }
        }
        count = 0;

        while (leftrightAway != 0) {
            count += leftright;
            if (arr[temp][B2 + count].equals("R")) {
                pw.println(Math.abs(L2 - B2) + Math.abs(L1 - B1) + 1);
                br.close();
                pw.close();
                return;
            }
            leftrightAway -= leftright;
        }

        pw.println(Math.abs(L2 - B2) + Math.abs(L1 - B1) - 1);
        br.close();
        pw.close();
    }
}