package test;

import leetcode.pojo.ListNode;

import java.util.Deque;
import java.util.LinkedList;


/**
 * 项目名称：algorithm
 * 包： test
 * 类名称：Demo.java
 * 类描述：测试而已
 * 创建人：wufuming
 * 创建时间：2019年01月16日
 */
public class Demo {
    public static void main(String[] arges) {
        System.out.println(5342 + 4655621);
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        l1.assemblyNode(new Integer[]{2, 4, 3, 5});
        l2.assemblyNode(new Integer[]{1, 2, 6, 5, 5, 6, 4});
        ListNode retNode = addTwoNumbers2(l1, l2);
        System.out.println(retNode);
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode retNode = dummyHead;
        ListNode n1 = l1, n2 = l2;
        int k = 0;
        for (; n1 != null; n1 = n1.next) {
            int val1 = (int) n1.val;
            int val2 = 0;
            if (n2 != null) {
                val2 = (int) n2.val;
                n2 = n2.next;
            }
            int val = val1 + val2 + k;
            if (val >= 10) {
                val = val % 10;
                k = 1;
            } else {
                k = 0;
            }
            dummyHead.next = new ListNode(val);
            dummyHead = dummyHead.next;
        }
        for (; n2 != null; n2 = n2.next) {
            int val = (int) n2.val;
            val = val + k;
            if (val >= 10) {
                val = val % 10;
                k = 1;
            } else {
                k = 0;
            }
            dummyHead.next = new ListNode(val);
            dummyHead = dummyHead.next;
        }
        return retNode.next;
    }


    /**
     * 时间复杂度O(n),空间复杂度O(n)
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int one = getSum(l1);
        int two = getSum(l2);
        int ret = one + two;
        String str = Integer.toString(ret);
        ListNode head = new ListNode(Integer.valueOf(str.substring(str.length() - 1)));
        ListNode retNode = head;
        for (int i = str.length() - 2; i >= 0; i--) {
            head.next = new ListNode(Integer.valueOf(str.substring(i, i + 1)));
            head = head.next;
        }
        return retNode;
    }

    private static int getSum(ListNode node) {
        Deque<Integer> stack = new LinkedList<>();
        for (ListNode cur = node; cur != null; cur = cur.next) {
            int val = (int) cur.val;
            stack.push(val);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return Integer.valueOf(sb.toString());
    }
}

    /*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

        示例：

        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)      2 4 3
                                                                   5 6 4 3
                                                                   7 0 8 3
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
