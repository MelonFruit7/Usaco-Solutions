import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class angryCows {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("angry.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("angry.out"));

        int n = Integer.parseInt(br.readLine());
        int res = 0;
        int temp = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);



        for (int temp2 = 0; temp2 < n; temp2++) {
        int val = temp2;
        int currentRaidus = 1;
        boolean allgood = false;
        temp = 0;
        for (int i = val + 1; i < n; i++) {
            if (arr[val] + currentRaidus >= arr[i]) {
                temp++;
                allgood = true;
               
            } else if (allgood) {
                currentRaidus++;
                val = --i;
                allgood = false;
            } else {
                break;
            }
        }
        val = temp2;
        currentRaidus = 1;
        allgood = false;
        for (int i = val - 1; i >= 0; i--) {
            if (arr[val] - currentRaidus <= arr[i]) {
                temp++;
                allgood = true;
            } else if (allgood) {
                currentRaidus++;
                val = ++i;
                allgood = false;
            } else {
                break;
            }
        }
        if (temp > res) {
            res = temp;
        }

        
    }

        pw.println(res + 1);
        pw.close();
        br.close();
    }
}