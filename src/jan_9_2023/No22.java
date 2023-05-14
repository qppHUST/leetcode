package jan_9_2023;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * ClassName: No22
 * PackageName:jan_9_2023
 * Description:
 * date: 2023/1/9 18:10
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No22 {

    public static List<String> generateParenthesis(int n) {
        TreeSet<String> previous = new TreeSet<>();
        previous.add("()");
        TreeSet<String> ans =  generate(1,previous,n);
        return new ArrayList<>(ans);
    }

    private static TreeSet<String> generate(int i, TreeSet<String> previous, int n) {
        if(i == n){
            return previous;
        }
        TreeSet<String> next = new TreeSet<>();
        for (String s : previous) {
            for (int j = 0; j < s.length() + 1; j++) {
                String front = s.substring(0, j);
                String end = s.substring(j, s.length());
                String item = front+"()"+end;
                next.add(item);
            }
        }
        return generate(i+1,next,n);
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        for (String string : strings) {
            System.out.print(string+" ");
        }
    }
}
