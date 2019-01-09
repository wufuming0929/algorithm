package linkedlist;

/**
 * 项目名称：algorithm
 * 包： linkedlist
 * 类名称：LinkedList.java
 * 类描述：单链表,实现crud操作
 * 创建人：wufuming
 * 创建时间：2019年01月09日
 */
public class LinkedList<E> {

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
            return e==null?"null":e.toString();
        }
    }

    private Node dummyHead;//虚拟节点
    private int size;

    public LinkedList() {
        dummyHead = new Node();
    }

    public void add(int index, E e) {
        checkAddIndex(index);
        Node prev = findPrev(index);
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        checkRemoveIndex(index);
        return findCur(index).e;
    }
    public E getFirst(){
        return get(0);
    }
    public E getLast(){
        return get(size - 1);
    }

    public E remove(int index) {
        checkRemoveIndex(index);
        Node prev = findPrev(index);
        return delNode(prev);
    }

    public boolean removeElement(E  e){
        if (e==null) {
            for(Node prev=dummyHead;prev.next!=null;prev=prev.next){
                Node delNode = prev.next;
                if (delNode.e==null) {
                    delNode(prev);
                    return true;
                }
            }
        }else {
            for(Node prev=dummyHead;prev.next!=null;prev=prev.next){
                Node delNode = prev.next;
                if (e.equals(delNode.e)) {
                    delNode(prev);
                    return true;
                }
            }
        }
        return false;

    }
    private E delNode(Node prev){
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void set(int index, E e) {
        checkRemoveIndex(index);
        Node cur = findCur(index);
        cur.e = e;
    }

    public boolean contains(E e) {
        if (e == null) {
            for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
                if (cur.e == null) {
                    return true;
                }
            }
        } else {
            for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
                if (e.equals(cur.e)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node findCur(int index) {
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur;
    }

    private Node findPrev(int index) {
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;
        return prev;
    }

    private void checkAddIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is Ilegal.");
        }
    }

    private void checkRemoveIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is Ilegal.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            sb.append(cur.e + "-->");
        sb.append("NULL");
        return sb.toString();
    }
}