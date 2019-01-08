package arraystack;

import array.Array;

/**
 * 项目名称：algorithm
 * 包： arraystack
 * 类名称：StackArray.java
 * 类描述：基于数组实现的栈
 * 创建人：wufuming
 * 创建时间：2019年01月07日
 */
public class ArrayStack<E> implements SelfStack<E>{

    private Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StackArray:[");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if (i!= array.getSize()-1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}