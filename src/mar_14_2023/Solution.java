package mar_14_2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: Solution
 * PackageName:mar_14_2023
 * Description:
 * date: 2023/3/18 10:31
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class Solution {

    int method(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] items = s.split(" ");
        int i = Integer.parseInt(items[0]);
        int total = i;
        int A = Integer.parseInt(items[1]);
        int B = Integer.parseInt(items[2]);
        int count = 0;
        int ans = 0;
        List<int[]> invaders = new ArrayList<>();
        while (count<total){
            String[] s1 = scanner.nextLine().split(" ");
            int[] ints = new int[2];
            ints[0] = Integer.parseInt(s1[0]);
            ints[1] = Integer.parseInt(s1[1]);
            invaders.add(ints);
            count++;
        }
        for (int[] invader : invaders) {
            int sum1 = 0;
            int sum2 = 0;
            int sum3 = 0;
            int sum4 = 0;
            for (int[] ints : invaders) {
                int widthA = Math.abs(invader[0]-ints[0]);
                boolean flagA = ints[0]-invader[0] >= 0;
                int widthB = Math.abs(invader[1]-ints[1]);
                boolean flagB = ints[1]-invader[1] >= 0;
                boolean ok = widthA<=A&&widthB<=B;
                if (ok&&flagA&&flagB){
                    sum1++;
                }else if (ok&&!flagA&&!flagB){
                    sum2++;
                } else if (ok && !flagA && flagB) {
                    sum3++;
                } else if (ok && flagA && !flagB) {
                    sum4++;
                }
            }
            int sumMax = Math.max(Math.max(Math.max(sum1,sum2),sum3),sum4);
            ans = sumMax>ans? sumMax:ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] items = s.split(" ");
        int i = Integer.parseInt(items[0]);
        int total = i;
        int A = Integer.parseInt(items[1]);
        int B = Integer.parseInt(items[2]);
        int count = 0;
        int ans = 0;
        List<int[]> invaders = new ArrayList<>();
        while (count<total){
            String[] s1 = scanner.nextLine().split(" ");
            int[] ints = new int[2];
            ints[0] = Integer.parseInt(s1[0]);
            ints[1] = Integer.parseInt(s1[1]);
            invaders.add(ints);
            count++;
        }
        for (int[] invader : invaders) {
            int sum1 = 0;
            int sum2 = 0;
            int sum3 = 0;
            int sum4 = 0;
            for (int[] ints : invaders) {
                int widthA = Math.abs(invader[0]-ints[0]);
                boolean flagA = ints[0]-invader[0] >= 0;
                int widthB = Math.abs(invader[1]-ints[1]);
                boolean flagB = ints[1]-invader[1] >= 0;
                boolean ok = widthA<=A&&widthB<=B;
                if (ok&&flagA&&flagB){
                    sum1++;
                }else if (ok&&!flagA&&!flagB){
                    sum2++;
                } else if (ok && !flagA && flagB) {
                    sum3++;
                } else if (ok && flagA && !flagB) {
                    sum4++;
                }
            }
            int sumMax = Math.max(Math.max(Math.max(sum1,sum2),sum3),sum4);
            ans = sumMax>ans? sumMax:ans;
        }
        System.out.println(ans);
    }
}
