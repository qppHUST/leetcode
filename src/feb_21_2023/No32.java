package feb_21_2023;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

/**
 * ClassName: No32
 * PackageName:feb_21_2023
 * Description:
 * date: 2023/2/21 16:01
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No32 {

    public int longestValidParentheses(String s) {
        String[] items = s.split("");
        ArrayList<Integer> ans = new ArrayList<>();
        int helper = 0;
        Stack<String> stack = new Stack<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String item : items) {
            stack.push(item);
        }
        while (!stack.empty()){
            String item = stack.pop();
            if(queue.isEmpty()){
                queue.addLast(item);
                continue;
            }
            String first = queue.getFirst();
            if("(".equals(item) && ")".equals(first)){
                queue.removeFirst();
                helper ++;
                ans.add(helper);
            }else {
                queue.addLast(item);
                if(helper != 0){
                    ans.add(helper);
                    helper = 0;
                }
            }
            if(stack.empty()){
                ans.add(helper);
            }
        }
        return ans.size() == 0? 0 : (ans.stream().sorted().toList().get(ans.size()-1))*2;
    }

    public static void main(String[] args) {
        int i = new No32().longestValidParentheses(")()())");
        System.out.println(i);
    }
}
