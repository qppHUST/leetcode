package jan_6_2023;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: No17
 * PackageName:jan_6_2023
 * Description:
 * date: 2023/1/6 17:36
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No17 {
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return new ArrayList<>();
        }
        String[] split = digits.split("");
        List<int[]> borders = new ArrayList<>();
        for (String s : split) {
            Integer num = Integer.valueOf(s);
            int[] border = new int[2];
            if(num <= 6){
                border[0] = 97+(num-2)*3;
                border[1] = border[0]+2;
            }else if(num == 7){
                border[0] = 97+15;
                border[1] = border[0]+3;
            }else if(num == 8){
                border[0] = 97+15+4;
                border[1] = border[0]+2;
            }else {
                border[0] = 97+15+4+3;
                border[1] = border[0]+3;
            }
            borders.add(border);
        }
        ArrayList<String> head = new ArrayList<>();
        int[] border = borders.get(0);
        for (int i = border[0]; i <= border[1]; i++) {
            String s = String.valueOf(((char) i));
            head.add(s);
        }
        return recursion(head,1,borders);
    }
    private static List<String> recursion(List<String> previous,int i,List<int[]> borders){
        if(i == borders.size()){
            return previous;
        }
        ArrayList<String> next = new ArrayList<>();
        int[] border = borders.get(i);
        for (String s : previous) {
            for (int j = border[0]; j <=border[1]; j++) {
                String item = s + String.valueOf(((char) j));
                next.add(item);
            }
        }
        return recursion(next,i+1,borders);
    }

    public static void main(String[] args) {
        List<String> strings = letterCombinations("233");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
