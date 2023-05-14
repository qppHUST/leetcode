package miHaYo;

import java.util.Scanner;

/**
 * ClassName: Main
 * PackageName:miHaYo
 * Description:
 * date: 2023/3/19 20:26
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class Main {
    public static void main(String[] args) {
        String[] s = new Scanner(System.in).nextLine().split(" ");
        int row = Integer.parseInt(s[0]);
        int col = Integer.parseInt(s[1]);
        int xIndex = 0;
        int yIndex = 0;
        while (xIndex <row){
            int numToPrint = xIndex;
            while (yIndex++<col){
                System.out.print(numToPrint+" ");
                numToPrint += row;
                numToPrint = numToPrint >9?numToPrint-10:numToPrint;
            }
            System.out.println();
            yIndex = 0;
            xIndex++;
        }
    }
}
