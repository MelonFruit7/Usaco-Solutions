import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WordProcessor {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("word.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("word.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int words = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        String[] arr = br.readLine().split(" ");
        String formated = arr[0];
        String temp = arr[0];

        for (int i = 1; i < words; i++) {
                if (temp.length() + arr[i].length() <= max) {
                    formated += " " + arr[i];
                    temp += arr[i];
                } else {
                    formated += "\n" + arr[i];
                    temp = arr[i];
                }
        }
            pw.println(formated);
            pw.close();
            br.close();
    }
}
