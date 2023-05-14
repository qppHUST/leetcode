package jan_9_2023;

/**
 * ClassName: No21
 * PackageName:jan_9_2023
 * Description:
 * date: 2023/1/9 17:49
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No21 {

      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans;
        if(list1 == null && list2 == null){
            return null;
        } else if(list1 == null){
            ans = list2;
        }else if(list2 == null){
            ans = list1;
        }else {
            ans = list1.val <= list2.val ? list1:list2;
        }
        ListNode helper = ans;
        if(ans == list1){
            list1 = list1.next;
        }else {
            list2 = list2.next;
        }
        while(list1 != null || list2 != null){
            if(list1 == null){
                ans.next = list2;
                ans = ans.next;
                list2 = list2.next;
                continue;
            }else if(list2 == null){
                ans.next = list1;
                ans = ans.next;
                list1 = list1.next;
                continue;
            }
            if(list1.val <= list2.val){
                ans.next = list1;
                ans = ans.next;
                list1 = list1.next;
            }else {
                ans.next = list2;
                ans = ans.next;
                list2 = list2.next;
            }
        }
        return helper;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(1);
        ListNode node8 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        ListNode listNode = mergeTwoLists(node1, node4);
        while(listNode != null){
            System.out.print(listNode.val +" ");
            listNode = listNode.next;
        }
    }
}
