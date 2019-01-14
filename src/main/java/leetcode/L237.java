package leetcode;

import leetcode.pojo.ListNode;

/**
 * 项目名称：algorithm
 * 包： leetcode
 * 类名称：L237.java
 * 类描述：删除链表中的节点
 * 创建人：wufuming
 * 创建时间：2019年01月13日
 */
/**
 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 4 -> 5 -> 1 -> 9
 示例 1:
 输入: head = [4,5,1,9], node = 5
 输出: [4,1,9]
 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 示例 2:
 输入: head = [4,5,1,9], node = 1
 输出: [4,5,9]
 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 说明:
 1.链表至少包含两个节点。
 2.链表中所有节点的值都是唯一的。
 3,给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 4.不要从你的函数中返回任何结果。
 */
public class L237 {
    public static void main(String[] arges) {
        Integer[] arr = {1,3,5,6,3,7,9};
        ListNode<Integer> head = new ListNode<>();
        System.out.println(head);
        new Solution().deleteNode(head);
    }
}


class Solution {
    /**
     * 思路：正常是要拿到前一个节点才能做删除操作，
     * 这个思路是把后一节点中的值挪到参数节点，再删除后一节点，太精妙了！
     */
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}