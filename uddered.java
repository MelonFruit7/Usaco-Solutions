import java.io.BufferedReader;
import java.io.InputStreamReader;

class uddered {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min = 0;

        char[] a = br.readLine().toCharArray();
        char[] w = br.readLine().toCharArray();

        for (int i = 0; i < w.length;) {
            for (int j = 0; j < a.length; j++) {
                if (w[i] == a[j]) {
                    i++;
                }
                if (j == a.length - 1) {
                    min++;
                }
                if (i >= w.length) {
                    min++;
                    break;    
                }
            }
        }

        System.out.println(min);
        br.close();
        
    }
}