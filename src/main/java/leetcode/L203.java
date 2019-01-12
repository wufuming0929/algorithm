package leetcode;

import leetcode.pojo.ListNode;

/**
 * 项目名称：algorithm
 * 包： leetcode
 * 类名称：L203.java
 * 类描述：删除链表中等于给定值 val 的所有节点
 * 创建人：wufuming
 * 创建时间：2019年01月11日
 */
public class L203 {
    public static <E>ListNode removeElements(ListNode<E> head, E val) {
        //虚拟节点
        ListNode<E> dummyHead = new ListNode(0);
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

        Integer[] arr = {1, 2, 6,3, 4, 6, 6};
        ListNode<Integer> head = new ListNode<>();
        head = head.assemblyNode(arr);
        System.out.println(head);
        head = removeElements(head, 6);
        System.out.println(head);
    }
}
