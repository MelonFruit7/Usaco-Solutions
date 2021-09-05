import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer; 

class Bucket {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("blist.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("blist.out"));

        int buckets = 0;
        int temp = 0;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][1] > arr[j][0] && arr[i][1] <= arr[j][1]) {
                    temp += arr[j][2];
                }
            } 
            if (temp > buckets) {
                buckets = temp;
            }
            temp = 0;
        }
        pw.println(buckets);
        pw.close();
        br.close();
    }
}