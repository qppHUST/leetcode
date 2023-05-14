package dec_31_2022;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: No2627
 * PackageName:dec_31_2022
 * Description:
 * date: 2022/12/31 10:13
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No2627 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        List<Node> list = new ArrayList<>();
        Node helper = head;
        Node bridge = head;
        int sum = 0;
        int To = 0;
        while (helper != null){
            sum++;
            Node node = new Node(helper.val);
            list.add(node);
            helper = helper.next;
        }
        int[] randomTo = new int[sum];
        int i = 0;
        helper = head;
        while (helper != null){
            if(helper.random == null){
                randomTo[i++] = -1;
                helper = helper.next;
                continue;
            }
            while (bridge != null){
                if(bridge == helper.random){
                    randomTo[i++] = To;
                    break;
                }
                bridge = bridge.next;
                To++;
            }

            helper = helper.next;
            To = 0;
            bridge = head;
        }
        for (int j = 0; j < sum; j++) {
            if(j < sum-1){
                list.get(j).next = list.get(j+1);
            }
            int index = randomTo[j];
            if(index == -1){
                list.get(j).random = null;
            }else {
                list.get(j).random = list.get(index);
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {

        //[[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node node = copyRandomList(node1);
        while (node != null){
            int val = -1;
            if(node.random != null){
                val = node.random.val;
            }
            System.out.print("值是:"+node.val+",random的值是: "+val);
            node = node.next;
        }
    }
}
