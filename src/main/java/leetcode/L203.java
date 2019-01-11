package leetcode;

/**
 * 项目名称：algorithm
 * 包： leetcode
 * 类名称：L203.java
 * 类描述：删除链表中等于给定值 val 的所有节点
 * 创建人：wufuming
 * 创建时间：2019年01月11日
 */
public class L203 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        //虚拟节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        for (ListNode first = dummyHead.next; first != null; first = first.next) {
            if (first.val == val) {
                prev.next = first.next;
                first.next = null;
                first = prev;
            } else {
                prev = first;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] arges) {

        ListNode la = new ListNode(1);
        ListNode firstA = la;
        for (int i = 2; i < 5; i = i + 1) {
            la.next = new ListNode(i);
            la = la.next;
        }
        ListNode listNode = removeElements(firstA, 3);
        System.out.println(listNode);


    }
}
