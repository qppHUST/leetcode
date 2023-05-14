package jan_10_2023;

import jan_9_2023.No21;

/**
 * ClassName: No23
 * PackageName:jan_10_2023
 * Description:
 * date: 2023/1/10 12:20
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No23 {

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode();
        ListNode helper = ans;
        int index = findIndex(lists);
        if (index == -1){
            return null;
        }
        boolean hasDone = true;
        while (true){
            index = findIndex(lists);
            for (int i = 0;i< lists.length;i++) {
                ListNode node = lists[i];
                if(node != null){
                    hasDone = false;
                    if (node.val <= lists[index].val){
                        index = i;
                    }
                }
            }
            if(hasDone){
                break;
            }
            hasDone = true;
            helper.next = lists[index];
            helper = helper.next;
            lists[index] = lists[index].next;
        }
        return ans.next;
    }

    private static int findIndex(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        ListNode node9 = new ListNode(8);
        ListNode node10 = new ListNode(9);
        ListNode node11 = new ListNode(11);
        ListNode node12 = new ListNode(15);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        node7.next = node8;
        node8.next = null;
        ListNode[] listNodes = {node1, node4, node7};
        ListNode node = mergeKLists(listNodes);
        while (node != null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
}
