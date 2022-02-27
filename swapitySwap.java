import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swapitySwap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("swap.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("swap.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<int[]> arr = new ArrayList<int[]>();

        int nums = Integer.parseInt(st.nextToken());
        int swaps = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int b1 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int[] origin = new int[nums];
        for (int i = 1; i <= nums; i++) {
            origin[i - 1] = i;
        }
        arr.add(origin);

        int[] newAdd = new int[nums];
        for (int i = 1; i <= nums; i++) {
            newAdd[i - 1] = i;
        }
        reverseBetween(newAdd, a1 - 1, a2 - 1);
        reverseBetween(newAdd, b1 - 1, b2 - 1);
        int[] newnew = new int[nums];
        for (int i = 0; i < nums; i++) {
            newnew[i] = newAdd[i];
        }
        arr.add(newnew);

        while(!Arrays.equals(newAdd, arr.get(0))) {
            reverseBetween(newAdd, a1 - 1, a2 - 1);
            reverseBetween(newAdd, b1 - 1, b2 - 1);
            newnew = new int[nums];
           for (int i = 0; i < nums; i++) {
             newnew[i] = newAdd[i];
           }
            arr.add(newnew);
        }


        int[] actual = arr.get(swaps % (arr.size() - 1));
        for (int i = 0; i < actual.length; i++) {
            pw.println(actual[i]);
        }
        pw.close();
        br.close();
    }

    public static void reverseBetween(int[] a, int i, int j) {
        int[] arr = new int[(j - i) + 1];

        int count = 0;
        for (int k = j; k >= i; k--) {
            arr[count] = a[k];
            count++;
        }

        count = 0;
        for (int k = i; k <= j; k++) {
            a[k] = arr[count];
            count++;
        }
    }
}
