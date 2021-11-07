import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class cowcrossroad2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("circlecross.out"));
        String letters = br.readLine();
        int res = 0;

        for (int i = 0; i < letters.length(); i++) {
            for (int j = i+1; j < letters.length(); j++) {
                if (letters.charAt(j) != letters.charAt(i)) {
                    for (int k = j+1; k < letters.indexOf(letters.charAt(i)+"", j); k++) {
                        if (letters.charAt(j) == letters.charAt(k)) {
                            res -= 2;
                            break;
                        }
                    }
            if (letters.indexOf(letters.charAt(i)+"", j) != -1) {
                res++;
            }
                } else {
                    if (j == i + 1) {
                        i++;
                        break;
                    }
                    break;
                }
            }
        }

        pw.println(res / 2);
        br.close();
        pw.close();
    }
}
