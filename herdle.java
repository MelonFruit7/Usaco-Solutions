import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class herdle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] answers = new char[3][3];
        char[][] guesses = new char[3][3];

        for (int i = 0; i < 3; i++) {
            answers[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < 3; i++) {
            guesses[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (answers[i][j] == guesses[i][j]) {
                    answers[i][j] = 'g';
                    guesses[i][j] = '!';
                }
            }
        }
        boolean temp = false;
        int storeK = 0, storeL = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (guesses[i][j] == answers[k][l]) {
                                temp = true;
                                storeK = k;
                                storeL = l;
                                break;
                        }
                        if (temp) {
                            break;
                        }
                    }
                }
                if (temp) {
                    answers[storeK][storeL] = 'y';
                }
                temp = false;
                storeK = 0;
                storeL = 0;
            }
        }

        int resGreen = 0;
        int resYellow = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (answers[i][j] == 'g') {
                    resGreen++;
                } else if (answers[i][j] == 'y') {
                    resYellow++;
                }
            }
        }
        System.out.println(resGreen);
        System.out.println(resYellow);
    }
}
