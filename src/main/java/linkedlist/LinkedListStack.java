package linkedlist;

import arraystack.Stack;

/**
 * 项目名称：algorithm
 * 包： linkedlist
 * 类名称：LinkedListStack.java
 * 类描述：基于单链表实现的栈。入栈，出栈的时间复杂度都为O(1)
 * 创建人：wufuming
 * 创建时间：2019年01月10日
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack:top ");
        sb.append(list);
       return sb.toString();
    }
    public static void main(String[] arges) {

        Stack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());


    }
}