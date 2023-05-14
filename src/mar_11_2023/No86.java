package mar_11_2023;

/**
 * ClassName: No86
 * PackageName:mar_11_2023
 * Description:
 * date: 2023/3/11 18:00
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No86 {
      static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode();
        ListNode helper1 = smallHead;
        ListNode other = new ListNode();
        ListNode helper2 = other;
        ListNode helper = head;
        while (helper != null){
            if (helper.val <x){
                smallHead.next = new ListNode(helper.val);
                smallHead = smallHead.next;
            }else {
                other.next = new ListNode(helper.val);
                other = other.next;
            }
            helper = helper.next;
        }
        helper1 = helper1.next;
        helper2 = helper2.next;
        smallHead.next = helper2;
        return helper1 == null ? helper2 :helper1;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(4);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(2);
//        ListNode listNode5 = new ListNode(5);
//        ListNode listNode6 = new ListNode(2);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
        ListNode partition = new No86().partition(listNode1, 0);
        while (partition !=null){
            System.out.println(partition.val);
            partition = partition.next;
        }
    }
}
