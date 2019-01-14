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
    public static <E> ListNode removeElements(ListNode<E> head, E val) {
        //虚拟节点
        ListNode<E> dummyHead = new ListNode<>(val);
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

    public static <E> ListNode remove(ListNode<E> head, E val) {
        //1.理解递归的宏观语义，就是要清楚递归函数需要解决的问题
        //2.把一个问题拆解成更小的相同问题，直到变成最基本的问题
        //3.把调用递归函数本身就当作调用普通函数
        //4.千万不要绕进递归函数的微观调用里面
        //递归函数仅包含两个两部分
        //1）最基本情况的解是什么(递归头)
        //2）
        if (head==null)return null;
        if (head.val.equals(val)) {
            head=head.next;
            return remove(head, val);
        }
        head.next=remove(head.next,val);
        return head;
    }

    /**
     * 推荐：这个求解最棒！！！
     */
    public static <E> ListNode remove2(ListNode<E> head, E val) {
        if (head==null)return null;
        head.next = remove2(head.next, val);
        return head.val==(val)?head.next:head;
    }
    public static <E> ListNode remove3(ListNode<E> head, E val) {
        if (head==null)return null;
        ListNode dummyHead = new ListNode(val);
        dummyHead.next=head;
        return remove3(head.next, val);
    }

    public static void main(String[] arges) {

        Integer[] arr = {1,3,5,6,3,7,9};
        ListNode<Integer> head = new ListNode<>();
        head = head.assemblyNode(arr);
        System.out.println(head);
        //head = removeElements(head, 6);
        ListNode remove = remove3(head, 3);
        System.out.println(remove);
    }
}
