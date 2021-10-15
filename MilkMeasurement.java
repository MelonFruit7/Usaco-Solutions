import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MilkMeasurement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("measurement.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String[][] arr = new String[n][3];
        String[] temp = new String[3];
        int Mildred = 7;
        int Elsie = 7;
        int Bessie = 7;

        int highest = 7;
        int tempHighest = 0;
        int numberOfHighest = 3;
        int numberOfHighestTemp = 0;
        int res = 0;
        //record number of highest numbers and highest numbers 
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
            arr[i][2] = st.nextToken();
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (Integer.parseInt(arr[j][0]) < Integer.parseInt(arr[i][0])) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        String stringHighest = arr[0][1];

        

        for (int i = 0; i < arr.length; i++) {
            switch(arr[i][1]) {
                case "Bessie": Bessie += Integer.parseInt(arr[i][2]);
                break;
                case "Elsie": Elsie += Integer.parseInt(arr[i][2]);
                break;
                case "Mildred": Mildred += Integer.parseInt(arr[i][2]);
            }
            numberOfHighestTemp = 0;
            tempHighest = Math.max(Math.max(Bessie, Elsie), Math.max(Elsie, Mildred));
            if (tempHighest == Bessie) {
                numberOfHighestTemp++;
            } 
            if (tempHighest == Elsie) {
                numberOfHighestTemp++;
            } 
            if (tempHighest == Mildred) {
                numberOfHighestTemp++;
            }

            if ((tempHighest != highest && !arr[i][1].equals(stringHighest)) || numberOfHighestTemp != numberOfHighest || (arr[i][1].equals(stringHighest) && tempHighest != highest + Integer.parseInt(arr[i][2]))) {
                res++;
                numberOfHighest = numberOfHighestTemp;
            }
            highest = tempHighest;
            if (highest == Bessie) {
                stringHighest = "Bessie";
            } 
            if (highest == Elsie) {
                stringHighest = "Elsie";
            } 
            if (highest == Mildred) {
                stringHighest = "Mildred";
            }
        }

        pw.println(res);
        pw.close();
        br.close();
    }
}
