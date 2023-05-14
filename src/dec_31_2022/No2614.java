package dec_31_2022;

import java.util.Stack;

/**
 * ClassName: No2614
 * PackageName:dec_31_2022
 * Description:
 * date: 2022/12/31 9:56
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No2614 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            ListNode push = stack.push(head);
            head = head.next;
        }
        ListNode pop = stack.pop();
        ListNode ans = new ListNode(pop.val);
        ListNode cursor = ans;
        while (!stack.empty()){
            ListNode node = stack.pop();
            cursor.next = node;
            cursor = cursor.next;
        }
        cursor.next = null;
        return ans;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode ans = reverseList(node1);
        while (ans != null){
            System.out.print(ans.val+" ");
            ans = ans.next;
        }
    }
}
