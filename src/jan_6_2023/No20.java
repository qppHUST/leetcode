package jan_6_2023;

import java.util.Stack;

/**
 * ClassName: No20
 * PackageName:jan_6_2023
 * Description:
 * date: 2023/1/6 19:13
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No20 {

    public static boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        String[] split = s.split("");
        Stack<String> helper = new Stack<String>();
        for (String s1 : split) {
            if(helper.size() == 0){
                helper.push(s1);
                continue;
            }
            String item = helper.peek();
            boolean ans = check(item,s1);
            if(ans){
                helper.pop();
            }else {
                helper.push(s1);
            }
        }
        return helper.size() == 0? true:false;
    }

    private static boolean check(String item, String s1) {
        if("(".equals(item) && ")".equals(s1) || "[".equals(item) && "]".equals(s1) || "{".equals(item) && "}".equals(s1) ){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{]"));
    }
}
