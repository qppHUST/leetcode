package dec_31_2022;

import java.util.Stack;

/**
 * ClassName: No2597
 * PackageName:dec_31_2022
 * Description:
 * date: 2022/12/31 9:48
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No2597 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        while ( !stack.empty()){
            ans[i++] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        int[] ints = reversePrint(node1);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }

}
