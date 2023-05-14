package jan_6_2023;

/**
 * ClassName: No19
 * PackageName:jan_6_2023
 * Description:
 * date: 2023/1/6 19:00
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No19 {

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        int i = 0;
        ListNode cursor = head;
        while (cursor != null){
            i++;
            cursor = cursor.next;
        }
        if(i == n){
            return head.next;
        }
        cursor = head;
        ListNode helper = cursor.next;
        while (true){
            i--;
            if(i == n){
                cursor.next = helper.next;
                break;
            }
            cursor = helper;
            if(cursor == null){
                break;
            }
            helper = cursor.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = null;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = null;
        ListNode listNode = removeNthFromEnd(node1, 2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
