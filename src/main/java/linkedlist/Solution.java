package linkedlist;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：algorithm
 * 包： linkedlist
 * 类名称：Solution.java
 * 类描述：单链表判断字符串回文
 * 创建人：wufuming
 * 创建时间：2019年01月09日
 */
public class Solution {

    public static void main(String[] arges) {
        List<ListNode> list = new ArrayList<>();
        String str = "123444320";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            ListNode node = new ListNode(c);
            list.add(node);
        }
        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).next=list.get(i+1);
        }
        System.out.println(list);
        ListNode head = list.get(0);
        list.clear();
        System.out.println(head);
        System.out.println(isPalindrome(head));

    }

    /**
     * 思路：
     * 使用快慢两个指针找到链表中点，慢指针每次前进一步，快指针每次前进两步。
     * 在慢指针前进的过程中，同时修改其 next 指针，使得链表前半部分反序。最后比较中点两侧的链表是否相等。
     * 时间复杂度O(n),空间复杂度O(1)
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }

    static class ListNode {
        char val;
        ListNode next;

        ListNode(char x) {
            val = x;
        }

        @Override
        public String toString() {
           return String.valueOf(val);
        }
    }
}