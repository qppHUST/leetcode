package may_1_2023;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.Stack;

/**
 * ClassName: No1003
 * PackageName:may_1_2023
 * Description:
 * date: 2023/5/3 23:01
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No1003 {

    public boolean isValid(String s) {
        if (s.charAt(s.length()-1) != 'c'){
            return false;
        }
        if (s.length()<3){
            return false;
        }
        ArrayList<Stack<Character>> buckets = new ArrayList<>();
        for (int i = s.length()-1; i >= 0; i--) {
            boolean flag = false;
            char c = s.charAt(i);
            if (c == 'c'){
                Stack<Character> bucket = new Stack<>();
                bucket.push(c);
                buckets.add(bucket);
                continue;
            }
            char need = (char)(c+1);
            for (Stack<Character> bucket : buckets) {
                if (bucket.peek() == need){
                    flag =true;
                    if (c == 'a'){
                        buckets.remove(bucket);
                        break;
                    }
                    bucket.push(c);
                    break;
                }
            }
            if (!flag){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new No1003().isValid("abcabcababcc"));
    }
}
