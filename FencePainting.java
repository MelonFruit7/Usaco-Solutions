import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FencePainting {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("paint.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("paint.out"));

        String[] farmer = br.readLine().split(" ");
        String[] cow = br.readLine().split(" ");
        int res = 0;
        int lowest = 0;
        int greatest = 0;

        if (Integer.parseInt(farmer[0]) > Integer.parseInt(cow[0])) {
            lowest = Integer.parseInt(cow[0]);
        } else {
            lowest = Integer.parseInt(farmer[0]);
        }

        if (Integer.parseInt(farmer[1]) > Integer.parseInt(cow[1])) {
            greatest = Integer.parseInt(farmer[1]);
        } else {
            greatest = Integer.parseInt(cow[1]);
        }
        


        if (Integer.parseInt(farmer[0]) > Integer.parseInt(cow[1])) {
            if (Integer.parseInt(farmer[1]) > Integer.parseInt(cow[0])) {
                res = (Integer.parseInt(farmer[1]) - Integer.parseInt(farmer[0])) + (Integer.parseInt(cow[1]) - Integer.parseInt(cow[0]));
            } else {
                res = greatest - lowest;
            }
        } else if (Integer.parseInt(farmer[1]) > Integer.parseInt(cow[0])) {
            res = greatest - lowest;
        } else {
            res = (Integer.parseInt(farmer[1]) - Integer.parseInt(farmer[0])) + (Integer.parseInt(cow[1]) - Integer.parseInt(cow[0]));
        }

        pw.println(res); 
        pw.close();
        br.close();

    }
}
