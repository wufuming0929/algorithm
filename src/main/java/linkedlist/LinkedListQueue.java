package linkedlist;

import arrayqueue.Queue;

import java.util.NoSuchElementException;

/**
 * 项目名称：algorithm
 * 包： linkedlist
 * 类名称：LinkedListQueue.java
 * 类描述：基于链表实现的队列,入队和出队的时间复杂度都为O(1)
 * 创建人：wufuming
 * 创建时间：2019年01月10日
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        E e;
        Node next;

        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        Node(E e) {
            this(e, null);
        }

        Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e == null ? "null" : e.toString();
        }
    }

    private Node head, tail;
    private int size;

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue：front [");
        for (Node d = head; d != null; d = d.next) {
            sb.append(d.e);
            if (d != tail) {
                sb.append(",");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] arges) {

        Queue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        queue.dequeue();
        System.out.println(queue.getFront());

    }
}