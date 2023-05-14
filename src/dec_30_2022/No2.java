package dec_30_2022;

/**
 * ClassName: No2
 * PackageName:oct_30_2022
 * Description: 原题地址:  https://leetcode.cn/problems/add-two-numbers/?favorite=2cktkvj
 * date: 2022/12/30 14:18
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No2 {
    static class ListNode{
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0,null);
        ListNode cursor = ans;
        int flag = 0;
        int flag1 = 1;
        int flag2 = 1;
        while(flag1 != 0 || flag2 != 0 || flag != 0){
            int num1 = 0;
            int num2 = 0;
            if (flag1 == 0){
                num1 = 0;
            }else {
                num1 = l1.val;
            }
            if (flag2 == 0){
                num2 =0;
            }else {
                num2 = l2.val;
            }
            if(l1.next == null){
                flag1 = 0;
            }else {
                l1 = l1.next;
            }
            if(l2.next == null){
                flag2 = 0;
            }else {
                l2 = l2.next;
            }
            int sum = num1 +num2+flag;
            flag = sum>=10? 1 :0;
            int nodeNum = sum%10;
            cursor.val = nodeNum;
            ListNode newNode ;
            if(flag1 != 0 || flag2 != 0 || flag != 0){
                newNode = new ListNode(0,null);
            }else {
                newNode = null;
            }
            cursor.next = newNode;
            cursor = cursor.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(8);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        n4.next = n5;
        n5.next = null;
//        n6.next = null;
        ListNode listNode = new No2().addTwoNumbers(n1, n4);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
