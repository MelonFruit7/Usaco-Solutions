import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class comfortableCows {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[1001][1001];
        boolean[][] exists = new boolean[1001][1001];
        StringTokenizer st;
        int x, y, res = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            exists[x][y] = true;
            switch(x) {
                case 0:
                 if (++arr[x + 1][y] == 3 && exists[x + 1][y]) res++;
                 else if (arr[x + 1][y] == 4 && exists[x + 1][y]) res--;
                break;
                case 1000:
                 if (++arr[x - 1][y] == 3 && exists[x - 1][y]) res++;
                 else if (arr[x - 1][y] == 4 && exists[x - 1][y]) res--;
                break;
                default:
                if (++arr[x - 1][y] == 3 && exists[x - 1][y]) res++;
                else if (arr[x - 1][y] == 4 && exists[x - 1][y]) res--;

                if (++arr[x + 1][y] == 3 && exists[x + 1][y]) res++;
                else if (arr[x + 1][y] == 4 && exists[x + 1][y]) res--;
            }
            switch(y) {
                case 0: 
                if (++arr[x][y + 1] == 3 && exists[x][y + 1]) res++;
                else if (arr[x][y + 1] == 4 && exists[x][y + 1]) res--;
                break;
                case 1000:
                if (++arr[x][y - 1] == 3 && exists[x][y - 1]) res++;
                else if (arr[x][y - 1] == 4 && exists[x][y - 1]) res--;
                break;
                default:
                if (++arr[x][y - 1] == 3 && exists[x][y - 1]) res++;
                else if (arr[x][y - 1] == 4 && exists[x][y - 1]) res--;

                if (++arr[x][y + 1] == 3 && exists[x][y + 1]) res++;
                else if (arr[x][y + 1] == 4 && exists[x][y + 1]) res--;
            }
            System.out.println(res);
        }
    }
}