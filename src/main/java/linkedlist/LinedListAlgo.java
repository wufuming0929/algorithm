package linkedlist;


import java.util.NoSuchElementException;

/**
 * 项目名称：algorithm
 * 包： linkedlist
 * 类名称：LinedListAlgo.java
 * 类描述：
 * 利用单链表实现5个常见的操作：
 * ①单链表反转
 * ②链表中环的检测
 * ③两个有序的链表合并
 * ④删除链表倒数第n个结点
 * ⑤求链表的中间结点
 * 创建人：wufuming
 * 创建时间：2019年01月10日
 */
public class LinedListAlgo {
    /**
     * 删除链表倒数第n个结点
     * @param head 头节点
     * @param location 倒数的位置从1开始
     * @return 返回剩余节点，保持顺序
     */
    public static Node remove(Node head, int location) {
        int size = 0;
        for (Node next = head; next != null; next = next.next)
            size++;
        if (size == 0 || location <= 0 || location > size) return head;
        if (size == location) {
            Node next=head.next;
            head.next=null;
            return next;
        }
        Node prev = head;
        for (int i = 0; i < size - location - 1; i++)
            prev = prev.next;
        Node retNode = prev.next;
        prev.next = prev.next.next;
        retNode.next = null;
        return head;
    }

    /**
     * 求链表的中间结点
     * 思路：快慢指针法，快指针进2步，慢指针进1步，快指针遍历完后，慢指针就到中间节点了。
     * @param head 头节点
     * @return 中间节点
     */
    public static Node middle(Node head) {
        if (head == null) return head;
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 思路:快慢指针法,时间复杂度O(n),空间复杂度O(1)
     * 快指针先拿到前一节点,慢指针调整当前节点的next属性,一轮过后把快指针赋值给慢指针继续循环
     * @param head 头节点
     * @return 返回反转后的头节点
     */
    public static Node reverse(Node head) {
        if (head == null) return head;
        Node prev = null;
        Node fast = head.next;
        Node slow = head;
        while (fast != null) {
            Node next = fast;
            fast = fast.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        slow.next = prev;
        return slow;
    }

    /**
     * 单链表反转参考代码
     */
    public static Node reverse2(Node list) {
        Node headNode = null;

        Node previousNode = null;
        Node currentNode = list;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                headNode = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return headNode;
    }

    // 参考代码：删除倒数第K个结点(有bug!)
    public static Node remove2(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) return list;

        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }

    static class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        Node(int val) {
            this(val, null);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Node: head [");
            for (Node next = this; next != null; next = next.next)
                sb.append(next.val + "->");
            sb.append("NULL ] tail");
            return sb.toString();
        }
    }

    public static void main(String[] arges) {

        Node head = new Node(1);
        Node first = head;
        for (int i = 2; i < 6; i++) {
            head.next = new Node(i);
            head = head.next;
        }
        System.out.println(remove(first,6));
    }

}