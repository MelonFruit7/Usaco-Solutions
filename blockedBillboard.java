import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class blockedBillboard {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("billboard.out"));

        int[][] arr = new int[3][4];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }
        int area1 = (arr[0][2] - arr[0][0]) * (arr[0][3] - arr[0][1]);
        int area2 = (arr[1][2] - arr[1][0]) * (arr[1][3] - arr[1][1]);
        int temp1 = 0, temp2 = 0;

        //0 = x1, 1 = y1, 2 = x2, 3 = y2;
        for (int i = 0; i < 2; i++) {
          //if truck coordinates is above or below both coordinates meaning the whole board is visible
          if (arr[2][0] > arr[i][2] || arr[2][2] < arr[i][0]) {
            temp1 = 0;
            break;
          } else if (arr[2][1] > arr[i][3] || arr[2][3] < arr[i][1]) {
            temp2 = 0;
            break;
          }

          //for x
          if (arr[2][0] < arr[i][0]) {
              if (arr[2][2] < arr[i][2]) {
                  temp1 = arr[2][2] - arr[i][0];
              } else {
                  temp1 = arr[i][2] - arr[i][0];
              }
          } else if (arr[2][0] < arr[i][2]) {
            if (arr[2][2] < arr[i][2]) {
                temp1 = arr[2][2] - arr[2][0];
            } else {
                temp1 = arr[i][2] - arr[2][0];
            }
          }

           //for y
           if (arr[2][1] < arr[i][1]) {
            if (arr[2][3] < arr[i][3]) {
                temp2 = arr[2][3] - arr[i][1];
            } else {
                temp2 = arr[i][3] - arr[i][1];
            }
           } else if (arr[2][1] < arr[i][3]) {
             if (arr[2][3] < arr[i][3]) {
              temp2 = arr[2][3] - arr[2][1];
             } else {
              temp2 = arr[i][3] - arr[2][1];
             }
           }

           if (i == 0) {
               area1 -= temp1 * temp2;
           } else {
               area2 -= temp1 * temp2;
           }
        }
        pw.println(area1 + area2);
        pw.close();
        br.close();
    }
}