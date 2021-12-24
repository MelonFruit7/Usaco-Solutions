import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class aircowditioning {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int res = 0;
        int[][] arr = new int[2][n];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
            arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] subtractions = new int[n];

        int temp = 0;
        for (int i : arr[0]) {
            subtractions[temp] = i - arr[1][temp++];
        }

        int startIndex = 0;
        int endIndex = 0;
        int move = 0;
        for (int i = 0; i < subtractions.length; i++) {
            if (subtractions[i] == 0) {
                continue;
            } else if (subtractions[i] < 0) {
                //for negative numbers
                startIndex = i;
                endIndex = i;
                for (int j = i + 1; j < subtractions.length; j++) {
                    if (subtractions[j] > 0) {
                        endIndex = j - 1;
                        break;
                    } else if (subtractions[j] < 0) {
                        if(j + 1 == subtractions.length) {
                            endIndex = j;
                        }
                    } else {
                        endIndex = j - 1;
                        break;
                    }
                }
                move = Math.max(subtractions[startIndex], subtractions[endIndex]);
                for (int k = startIndex; k <= endIndex; k++) {
                    subtractions[k] -= move;
                }
                if(subtractions[i] != 0) {
                    i -= 1;
                }
                res += Math.abs(move);
            } else {
                //for positive numbers
                startIndex = i;
                endIndex = i;
                for (int j = i + 1; j < subtractions.length; j++) {
                    if (subtractions[j] < 0) {
                        endIndex = j - 1;
                        break;
                    } else if (subtractions[j] > 0) {
                        if(j + 1 == subtractions.length) {
                            endIndex = j;
                        }
                    } else {
                        endIndex = j - 1;
                        break;
                    }
                }
                move = Math.min(subtractions[startIndex], subtractions[endIndex]);
                for (int k = startIndex; k <= endIndex; k++) {
                    subtractions[k] -= move;
                }
                if(subtractions[i] != 0) {
                    i -= 1;
                }
                res += Math.abs(move);
            }
        }
        System.out.println(res);
        br.close();
    }
}
